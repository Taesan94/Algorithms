package Programmers.Level2;

public class Delivery {
	
	static boolean[] result = new boolean[51];
	
	public static void main(String[] args) {

		int N = 6 ; //6 5 4
		int K = 4 ; //4 3 3
		int[][] road = {
				{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}
				//{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}
				//{ 1,2,1 } , { 2,3,1 } , { 3,1,1 } , { 3,4,1 } 
		};

		int answer = solution(N,road,K);
		//int answer = solution2(N,road,K);

		System.out.println(answer);

	}//main

	public static int solution(int N, int[][] road, int K) {

		int answer = 0;

		int boxSize = N+1;

		int[][] box = new int[boxSize][boxSize];
		boolean[][] visits = new boolean[boxSize][boxSize];

		//make Box
		for ( int i = 0 ; i < road.length; i ++ ) {

			int[] wk = road[i];

			int a = wk[0];
			int b = wk[1];
			int c = wk[2];

			if ( box[a][b] != 0 && box[a][b] < c ) {
				c = box[a][b];
			}

			box[a][b] = c;
			box[b][a] = c;
		}

		sol ( box, visits , 1,-1, 0, K);
		
		for ( int k = 1 ; k <= N; k++ ) {
			if ( result[k] ) {
				answer++;
			}
		}
		return answer;
	}

	static int cnt = 0 ;
	
	private static void sol( int[][] box , boolean[][] visits , int start , int before , int distance, int max) {

		if ( distance > max ) return;
		
		//1번에 연결된 가게를 모두 찾는다.
		for ( int j = 1; j < box.length; j++ ) {
			
			cnt++;
			
			if ( j == before || box[start][j] == 0 ) continue;
			
			int dis = distance + box[start][j];
			
			if ( dis <= max ) {
				
				result[start] = true;
				result[j] = true;

				if ( dis < max ) {
					sol(box, visits, j, start, dis,max);
				}
			}
		}
		
		System.out.println(" start : " + start + ", cnt : " + cnt);
	}
	
}//class
