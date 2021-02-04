package Basic.AlgorithmBasic.Graph;

import java.util.Arrays;

public class FloydWarshall {

	public static void main(String[] args) {
		int n =5 ; //5 , 8

		int[][] results ={
				{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}
				//{1,2},{2,3},{3,4},{5,6},{6,7},{7,8},{4,5}
		};	

		int result = solution(n,results);

		System.out.println( " result : " + result );
	}
	
	static int INF = 101;
	public static int solution(int n, int[][] results) {
		int answer = 0;

		// 각 선수간의 그래프를 표현하기 위한 인접배열
		int[][] data = new int[n+1][n+1];

		// 갈 수 있는 경우만 가중치를 1로 기록. 없는 경우는 무한대로.
		for ( int i=0; i<=n; i++ ) {
			Arrays.fill(data[i],INF);
		}

		for ( int[] r : results ) {
			data[r[0]][r[1]] = 1;
		}
		
		// 거쳐가는 노드
		for ( int i=1; i<=n; i++ ) {

			// 출발 노드
			for ( int j=1; j<=n; j++ ) {
				// 도착 노드
				for ( int k=1; k<=n; k++ ) {
					if( data[j][i]+data[i][k] < data[j][k]) {
						data[j][k] = data[j][i]+data[i][k]; 
					}
				}
			}
		}
		
		for ( int i=1; i<=n; i++ ) {
			boolean possible = true;
			for ( int j=1; j<=n; j++ ) {
				if( (i !=j ) && ( data[i][j] == INF && data[j][i] == INF ) ) {
					possible = false;
					break;
				}
			}
			if( possible ) answer++;
		}

		return answer;
	}
	
}
