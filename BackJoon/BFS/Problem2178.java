package Programmers.BackJoon.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem2178 {
	
	static int[] arrX = { 1,-1,0,0 };
	static int[] arrY = { 0,0,1,-1 };
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String[] nm = scan.nextLine().split(" ");
		
		int n = Integer.valueOf(nm[0]);
		int m = Integer.valueOf(nm[1]);
		
		int[][] miro = new int[n+1][m+1];
		
		for ( int i=1; i<=n; i++ ) {
			String row = scan.nextLine();
			
			for( int j=1; j<=m; j++ ) {
				miro[i][j] = row.charAt(j-1)-'0';
			}
		}
		
		boolean[][] visit = new boolean[n+1][m+1];
		int[][] distance = new int[n+1][m+1];
		
		for( int[] d : distance ) {
			Arrays.fill(d, 10001);
		}
		
		distance[1][1] = 1;
		
		// 갈 수 있는 위치를 기록해간다.
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(1,1));
		
		while( !q.isEmpty() ) {
			
			Node pos = q.poll();
			
			if( !visit[pos.x][pos.y] ) {
				
				visit[pos.x][pos.y] = true;
				
				// 4방의 모든 대상을 추가해준다.
				for( int i=0; i<4; i++ ) {
					
					int nextX = pos.x+arrX[i];
					int nextY = pos.y+arrY[i];
					
					if( nextX > n || nextY > m ) continue;
 					
					if( !visit[nextX][nextY] && miro[nextX][nextY] == 1 ) {
						q.add(new Node(nextX,nextY));
						distance[nextX][nextY] = Math.min(distance[nextX][nextY], distance[pos.x][pos.y]+1);
					}
				}
			}
		}
		
		System.out.println(distance[n][m]);
		
	}
	
	static class Node {
		int x;
		int y;
		
		Node(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	
	

}
