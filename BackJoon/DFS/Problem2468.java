package Programmers.BackJoon.DFS;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Problem2468 {

	static int max = 1;
	static int n;
	static int[][] map;
	static int[] X = {0, 0, 1, -1};
	static int[] Y = {1, -1, 0, 0};

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		n = scan.nextInt();
		scan.nextLine();

		map = new int [n][n];
		Set<Integer> heights = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			String[] input = scan.nextLine().split(" ");
			for (int j = 0; j < n; j++) {
				int value = Integer.valueOf(input[j]);
				map[i][j] = value;
				heights.add(value);
			}
		}

		Iterator itr = heights.iterator();
		// 모든 높이에서 안전영역의 수를 구한다.
		while (itr.hasNext()) {
			int h = (int)itr.next();
			if (h <= 100)
				findResult(h);
		}
		System.out.println(max);

	}

	private static void findResult(int h) {

		int[][] visited = new int[n][n];
		int safeArea = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] > h && visited[i][j] == 0) {
					// bfs(i, j, h, visited);
					dfs(i, j, h, visited);
					safeArea++;
				}
			}
		}
		max = Math.max(max, safeArea);
	}

	private static void bfs(int i, int j, int h, int[][] visited) {

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i, j});

		while(!q.isEmpty()) {

			int[] pos = q.poll();
			int x = pos[0];
			int y = pos[1];

			if (visited[x][y] == 1)
				continue;
			visited[x][y] = 1;
			for (int k = 0; k < 4; k++) {
				int nextX = x + X[k];
				int nextY = y + Y[k];

				if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < n) {
					if (map[nextX][nextY] > h && visited[nextX][nextY] == 0) {
						q.add(new int[] {nextX, nextY});
					}
				}
			}
		}
	}
	
	private static void dfs(int i, int j, int h, int[][] visited) {
		
		if (visited[i][j] == 1 || map[i][j] <= h)
			return;
		
		visited[i][j] = 1;
		
		for (int k = 0; k < 4; k++) {
			int nextX = i + X[k];
			int nextY = j + Y[k];

			if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < n) {
				dfs(nextX, nextY, h, visited);
			}
		}
	}

	private static void show(int[][] arr) {
		for(int i = 0 ; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
}
