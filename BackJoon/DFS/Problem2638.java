package Programmers.BackJoon.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2638 {

	static int N, M, Cheese = 0, Cnt = 0;
	static int Map[][];
	
	static int[] X = {1, -1, 0, 0};
	static int[] Y = {0, 0, 1, -1};
	static boolean[][] Visited;
	
	public static void main(String[] args)  throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		Map = new int[N][M];
		Visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				Map[i][j] = Integer.valueOf(st.nextToken());
				if (Map[i][j] == 1)
					Cheese++;
				else
					Map[i][j] = -1;
			}
		}
		
		while (Cheese != 0) {
			Visited = new boolean[N][M];
			externalChck(0, 0);
			removeChese();
			Cnt++;
		}
		
		System.out.println(Cnt);
	}
	
	static boolean airChck(int x, int y) {
		
		int cnt = 0;
		
		for (int i = 0; i < 4; i++) {
			
			int nX = x + X[i];
			int nY = y + Y[i];
			
			if (nX < 0 || nX >= N || nY < 0 || nY >= M)
				continue;
			
			if (Map[nX][nY] == 0)
				cnt++;
		}
		
		if (cnt >= 2)
			return true;
		return false;
	}
	
	static void removeChese() {
		
		boolean[][] possible = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 치즈면 4방에 외부공기가 몇개 있는지 확인.
				if (Map[i][j] == 1 && airChck(i, j)) {
						possible[i][j] = true;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (possible[i][j]) {
					Map[i][j] = 0;
					Cheese--;
				}
			}
		}
		
	}
	
	static void externalChck(int x, int y) {
		
		if (Visited[x][y])
			return ;
		
		Visited[x][y] = true;
		Map[x][y] = 0;
		
		for (int i = 0; i < 4; i++) {
			
			int nX = x + X[i];
			int nY = y + Y[i];
			
			if (nX < 0 || nX >= N || nY < 0 || nY >= M || Visited[nX][nY])
				continue;
			
			if (Map[nX][nY] != 1) {
				externalChck(nX, nY);
			}
		}
	}
	
	
	static void print(int[][] arr) {
		System.out.println("## print ##");
		for (int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
	}
	

}
