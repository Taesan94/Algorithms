package Programmers.BackJoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem12865_retry {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		int k = Integer.valueOf(st.nextToken());
		
		int[] w = new int[n + 1];
		int[] v = new int[n + 1];
		
		for (int i = 0; i < n; i++) {
			 st = new StringTokenizer(br.readLine());
			w[i + 1] = Integer.valueOf(st.nextToken());
			v[i + 1] = Integer.valueOf(st.nextToken());
		}

		// i 번째 물건을 넣었을 때, 가치의 최대 값 구하기.
		int[][] dp = new int[n + 1][k + 1];
		
		// dp[i][j - 1],  dp[i - 1][j] 중 최대값. 
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (j >= w[i]) {
					dp[i][j] =Math.max(dp[i - 1][j], v[i] + dp[i - 1][j - w[i]]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[n][k]);
	}

}
