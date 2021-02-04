package BOJ.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem7576 {

	static int[] arrX = { 0,0,1,-1 };
	static int[] arrY = { 1,-1,0,0 };

	public static void main( String[] args ) {

		Scanner scan = new Scanner(System.in);

		String[] nm = scan.nextLine().split(" ");
		int n = Integer.valueOf(nm[0]);
		int m = Integer.valueOf(nm[1]);

		int[][] box = new int[m+1][n+1];

		Queue<int[]> goodTomato = new LinkedList<>();

		int badTomato = 0 ;

		for ( int i=1; i<=m; i++ ) {
			String[] row = scan.nextLine().split(" ");
			for ( int j=1; j<=n; j++ ) {

				int value = Integer.valueOf(row[j-1]);

				if( value == 1 ) goodTomato.add(new int[] {i,j});
				else if ( value==0 ) badTomato++;

				box[i][j] = value;
			}
		}

		if( badTomato == n*m || badTomato == 0 ) System.out.println(0);
		
		else {

			Arrays.fill(box[0], -1);

			for( int i=1; i<=m; i++) {
				box[i][0] = -1;
			}

			for( int[] b : box ) {
				System.out.println(Arrays.toString(b));
			}

			boolean[][] visit = new boolean[m+1][n+1];
			boolean[][] badVisit = new boolean[m+1][n+1];

			Queue<int[]> goodTomato2 = new LinkedList<>();

			int cnt = 0 ;
			
			while( !goodTomato.isEmpty() ) {

				cnt++;

				goodTomato2.addAll(goodTomato);
				goodTomato.clear();

				// bad토마토가 0이되어야 한다.
				while( !goodTomato2.isEmpty() ) {

					int[] pos = goodTomato2.poll();

					if( !visit[pos[0]][pos[1]] ) {

						visit[pos[0]][pos[1]] = true;

						for( int i=0; i<4; i++ ) {

							int nextX = pos[0] + arrX[i];
							int nextY = pos[1] + arrY[i];

							if( nextX > m || nextY > n ) continue;

							if( box[nextX][nextY]==0 && !badVisit[nextX][nextY]) {
								badVisit[nextX][nextY] = true;
								goodTomato.add(new int[] { nextX, nextY } );
								badTomato--;
							}
						}
					}
				}
				
				if( badTomato==0 ) break;
			}

			if( badTomato != 0 ) System.out.println(-1);
			else System.out.println(cnt);
		}
	}



}
