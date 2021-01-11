package Programmers.BackJoon.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1987 {

	static int R, C;
	static char[][] Map;
	static boolean[] Check;
	static boolean[][] Visited;
	static int Max;
	
	static int[] X = {1, -1, 0, 0};
	static int[] Y = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.valueOf(st.nextToken());
		C = Integer.valueOf(st.nextToken());
		
		Map = new char[R][C];
		Visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			 String input = br.readLine();
			for (int j = 0; j < C; j++) {
				Map[i][j] = input.charAt(j);
			}
		}
		Check = new boolean[91];
		Max = 1;
		Visited[0][0] = true;
		Check[Map[0][0]] = true;
		dfs(0, 0, 1);
		
		System.out.println(Max);
	}
	
	static void dfs(int r, int c, int cnt) {

		for (int i = 0; i < 4; i++) {
			
			int nR = r + X[i];
			int nC = c + Y[i];
			if (nR < 0 || nC < 0 || nR >= R || nC >= C)
				continue;
			if (Visited[nR][nC] || Check[Map[nR][nC]]) {
				continue;
			}
			Visited[nR][nC] = true;
			Check[Map[nR][nC]] = true;
			dfs(nR, nC, cnt + 1);
			Check[Map[nR][nC]] = false;
			Visited[nR][nC] = false;
		}
		Max = Math.max(Max, cnt);
	}

}
