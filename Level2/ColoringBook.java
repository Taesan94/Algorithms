package Programmers.Level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ColoringBook {

	// 좌,우,상,하
	private static int[] intX = { -1,1,0,0 };
	private static int[] intY = { 0,0,1,-1 };
	// 방문 체크여부.
	private static boolean[][] visits ;

	static int mM = 0;
	static int nN = 0;

	public static void main(String[] args) {

		int[][] picture= {
				{1, 1, 1, 0}, 
				{1, 2, 2, 0}, 
				{1, 0, 0, 1}, 
				{0, 0, 0, 1}, 
				{0, 0, 0, 3}, 
				{0, 0, 0, 3}
		};
		
		int m = 6;
		int n = 4;

		int[] answer = solution( m,n,picture );

		System.out.println(Arrays.toString(answer));


	}//main

	public static int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		visits = new boolean[m][n];

		mM = m;
		nN = n;

		// 모든그림을 다본다.
		for ( int i = 0 ; i < m ; i ++ ) {
			for ( int j = 0; j < n ; j++ ) {
				if( !visits[i][j] && picture[i][j] != 0 ) {
					visits[i][j] = true; 
					int cnt = check( i , j , picture );
					if ( cnt > maxSizeOfOneArea ) maxSizeOfOneArea = cnt;
					numberOfArea++;
				}
			}
		}

		int[] answer = new int[2];

		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;

		return answer;
	}

	private static int check( int x , int y , int[][] picture ) {

		int cnt = 0;

		Queue<Node> q = new LinkedList<Node>();

		q.add(new Node(x,y));

		while ( !q.isEmpty()) {

			Node node = q.poll();

			cnt++;

			// 좌,우,상,하 같은거 있는지 확인
			for ( int i = 0; i < 4; i++ ) {

				int nextX = node.x + intX[i];
				int nextY = node.y + intY[i];

				// 처리안되는경우
				if ( nextX < 0 || nextX > mM-1 || nextY < 0 || nextY > nN-1 ) continue;

				//방문하지않았다면
				if ( !visits[nextX][nextY] && picture[node.x][node.y] == picture[nextX][nextY] ) {
					visits[nextX][nextY] = true;
					q.add(new Node(nextX,nextY));
				}
			}
		}

		return cnt;
	}

	private static class Node {

		int x = 0 ;
		int y = 0 ;

		Node(int x , int y ){
			this.x=x;
			this.y=y;
		}
	}

}//class
