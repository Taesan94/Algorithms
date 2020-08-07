package Programmers.BackJoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1932 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.valueOf(br.readLine());
		
		int[][] graph = new int[n + 1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int j = 1;
			while(st.hasMoreTokens()) {
				graph[i][j++] = Integer.valueOf(st.nextToken());
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				graph[i][j] = Math.max(graph[i][j] + graph[i - 1][j - 1], graph[i][j] + graph[i -1][j]);
			}
		}
		int[] result = graph[n];
		Arrays.sort(result);
		System.out.println(result[n]);
	}

	private static void show(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}

}
