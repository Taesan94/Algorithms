package Programmers.Hackerrank;

import java.util.Arrays;

public class MaxArraySum {

	public static void main(String[] args) {

		int[] arr = {
				// 3, 5, -7, 8 ,10
				-2,1, 3, -4, 5

				// 3, 7, 4, 6 ,5
				// -1,-1,-1,-1,1
		};

		System.out.println("result : " + maxSubsetSum(arr));

	}
	static int maxSubsetSum(int[] arr) {
		int[] dp = new int[arr.length];

		if (arr.length <= 2)
			return 0;
		if (arr.length == 3)
			return arr[0] + arr[2];
		
		dp[0] = arr[0];
		dp[1] = arr[1];
		for (int i = 2; i < arr.length; i++) {
			dp[i] = Math.max(arr[i], Math.max(dp[i - 1], dp[i - 2] + arr[i]));
		}
		System.out.println(Arrays.toString(dp));
		Arrays.sort(dp);
		return dp[arr.length - 1];
	}

}
