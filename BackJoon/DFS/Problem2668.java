package Programmers.BackJoon.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem2668 {

	static int N, Cnt;
	static int[] Board;
	static boolean[] Result;
	public static void main(String[] args)  throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.valueOf(br.readLine());
		Board = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			Board[i] = Integer.valueOf(br.readLine());
		}
		
		Result = new boolean[N + 1];
		Cnt = 0;
		// 각 숫자를 골랐을 때 최대 값 구하기.
		for (int i = 1; i <= N; i++) {
			boolean[] visited  = new boolean[N + 1];
			dfs(i, i, visited);
		}
		System.out.println(Cnt);
		for (int i = 1; i <= N; i++) {
			if (Result[i])
				System.out.println(i);
		}
	}
	
	static void checkResult(boolean[] visited) {
		for (int i = 1; i <= N; i++) {
			if (!Result[i] && visited[i]) {
				Result[i] = true;
				Cnt++;
			}
		}
	}
	
	static void dfs(int end, int idx, boolean[] visited) {
		if (visited[idx]) {
			if (idx == end)
				checkResult(visited);
			return;
		}
		visited[idx] = true;
		dfs(end, Board[idx], visited);
		return ;
	}
	
	static void print(int[][] arr) {
		for(int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
	}

}
