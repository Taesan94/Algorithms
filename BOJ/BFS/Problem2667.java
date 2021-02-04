package BOJ.BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Problem2667 {

	static int[] arrX = { 1,-1,0,0 };
	static int[] arrY = { 0,0,1,-1 };

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		scan.nextLine();

		int[][] map = new int[n+1][n+1];

		for ( int i=1; i<=n; i++ ) {
			String row = scan.nextLine();
			for( int j=1; j<=n; j++ ) {
				map[i][j] = row.charAt(j-1)-'0';
			}
		}

		boolean[][] visit = new boolean[n+1][n+1];

		int totalCnt = 0 ;
		List<Integer> resultCnt = new ArrayList<>();
		
		for( int i=1; i<=n; i++ ) {
			for( int j=1; j<=n; j++ ) {
				if( map[i][j]==1 && !visit[i][j] ) {

					totalCnt++;

					Queue<int[]> q = new LinkedList<>();
					q.add(new int[] {i,j});

					int cnt = 0 ;

					while( !q.isEmpty() ) {

						int[] pos = q.poll();

						if( !visit[pos[0]][pos[1]] ) {
							cnt++;
							visit[pos[0]][pos[1]] = true;
							
							for( int k=0 ; k < 4; k++ ) {

								int nextX = pos[0] + arrX[k];
								int nextY = pos[1] + arrY[k];

								if( nextX > n || nextY > n ) continue;

								if( map[nextX][nextY]==1 && !visit[nextX][nextY]) {
									q.add(new int[] {nextX,nextY});
								}
							}
						}
					}
					resultCnt.add(cnt);
				}
			}
		}
		
		System.out.println(totalCnt);
		
		Collections.sort(resultCnt);
		
		for( int i=0; i<totalCnt; i++ ) {
			System.out.println(resultCnt.get(i));
		}
		
	}

}
