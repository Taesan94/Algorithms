package Programmers.BackJoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem2156 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.valueOf(br.readLine());

		int[] nums = new int[n + 1];
		int[] dp = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			nums[i] = Integer.valueOf(br.readLine());
		}
		
		dp[1] = nums[1];
		
		if (n > 1)
			dp[2] = nums[1] + nums[2];
		
		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + nums[i], dp[i - 3] + nums[i - 1] + nums[i]));
		}
		
		
		System.out.println(dp[n]);
		
		
		
		
	}

}
