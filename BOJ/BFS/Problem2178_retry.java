package BOJ.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem2178_retry {
	
	static int[] X = {0,0,1,-1};
	static int[] Y = {1,-1,0,-0};
	
	static int INF = 10001;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String[] nm = scan.nextLine().split(" ");
		
		int n = Integer.valueOf(nm[0]);
		int m = Integer.valueOf(nm[1]);
		
		int[][] miro = new int[n+1][m+1];
		int[][] distance = new int[n+1][m+1];
		int[][] visits = new int[n+1][m+1];
		
		for ( int i=1; i<=n; i++ ) {
			String row = scan.nextLine();
			for( int j=1; j<=m; j++ ) {
				miro[i][j] = row.charAt(j-1)-'0';
			}
		}
		
		for ( int i=0; i<=n; i++ )
			Arrays.fill(distance[i], INF);
		distance[1][1] = 1;
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.add(new int[] {1,1});
		while(!q.isEmpty()) {
			
			int[] current = q.poll();
			int x = current[0];
			int y = current[1];
			
			for ( int i=0; i<4; i++) {
				int nextX = x+X[i];
				int nextY = y+Y[i];
				
				if (nextX <= n && nextY <= m && visits[nextX][nextY] == 0 && miro[nextX][nextY] == 1) {
					q.add(new int[]{nextX, nextY});
					visits[nextX][nextY] = 1;
					distance[nextX][nextY] = Math.min(distance[nextX][nextY], distance[x][y] + 1);
				}
			}
		}
		System.out.println(distance[n][m]);
	}
}
