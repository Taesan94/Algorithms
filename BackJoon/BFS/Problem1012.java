package Programmers.BackJoon.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem1012 {
	
	static int[] X = {0,0,1,-1};
	static int[] Y = {1,-1,0,0};
	

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int cnt = Integer.valueOf(scan.nextLine());
		
		for (int i=0; i<cnt; i++) {
			
			String[] input = scan.nextLine().split(" ");
			
			int col = Integer.valueOf(input[0]);
			int row = Integer.valueOf(input[1]);
			int n = Integer.valueOf(input[2]);
			int[][] map = new int[row][col];
			int[][] visits = new int[row][col];
			
			for( int j=0; j < n; j++ ) {
				String[] input2 = scan.nextLine().split(" ");
				int a = Integer.valueOf(input2[0]);
				int b = Integer.valueOf(input2[1]);
				map[b][a] = 1;
			}
			
			int result = 0;
			for( int r=0; r < row; r++ ) {
				for ( int c=0; c < col; c++ ) {
					if(map[r][c] == 1 && visits[r][c] == 0) {
						find(map, visits, r, c);
						result++;
					}
				}
			}
			System.out.println(result);
		}
	}
	
	private static void find(int[][] map, int[][] visits, int i, int j) {
		
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {i,j});
		
		while(!q.isEmpty()) {
			
			int[] cur = q.poll();
			
			int x = cur[0];
			int y = cur[1];
			
			if(visits[x][y] == 1)
				continue;
			
			visits[x][y] = 1;
			
			for (int k=0; k < 4; k++) {
				int nextX = x + X[k];
				int nextY = y + Y[k];
				
				if (nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map[0].length)
					continue;
				
				if (map[nextX][nextY] == 1 && visits[nextX][nextY] == 0)
					q.add(new int[] {nextX, nextY});
			}
		}
	}
	
	private static void show(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}

}
