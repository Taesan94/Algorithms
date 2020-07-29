package Programmers.BackJoon.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Problem2667_retry {
	
	static int[] X = {0,0,1,-1};
	static int[] Y = {1,-1,0,0};
	
	static int N;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		int[][] map = new int[N+1][N+1];
		int[][] visits = new int[N+1][N+1];
		List<Integer> result = new ArrayList<Integer>();
		int cnt = 0;
		int totalCnt = 0;
		scan.nextLine();
		
		for ( int i = 1; i <= N; i++ ) {
			String line = scan.nextLine();
			for (int j=1; j<=line.length(); j++)
				map[i][j] = line.charAt(j-1) - '0';
		}
		 //show(map);
		// 1. 끈킬때까지 cnt 후 list에 저장
		
		for( int i=1; i <= N; i++) {
			for ( int j=1; j <= N; j++) {
				if(visits[i][j] == 0 && map[i][j] == 1) {
					visits[i][j] = 1;
					cnt = 0;
					cnt = bfs(map, visits, i, j);
					totalCnt++;
					result.add(cnt);
				}
			}
		}
		// 2. 오름차순 정렬 후, 출력
		System.out.println(totalCnt);
		Collections.sort(result);
		for( int i = 0; i < result.size(); i++ )
			System.out.println(result.get(i));
	}
	
	private static int bfs(int[][] map, int[][] visits, int i, int j) {
		
		Queue<int[]> q = new LinkedList<>();
		
		int cnt = 1 ;
		
		q.add(new int[] {i,j});
		while(!q.isEmpty()) {
			
			int[] current = q.poll();
			int x = current[0];
			int y = current[1];
			
			for( int k=0; k<4; k++) {
				int nextX = x + X[k];
				int nextY = y + Y[k];
				
				if (nextX <= N && nextY <= N && visits[nextX][nextY] == 0 && map[nextX][nextY] == 1) {
					visits[nextX][nextY] = 1;
					cnt++;
					q.add(new int[] {nextX, nextY});
				}
			}
		}
		return cnt;
	}
	
	private static void show(int[][] map) {
		for(int i=0; i<map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}

}
