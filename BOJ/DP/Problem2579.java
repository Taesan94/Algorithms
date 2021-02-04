package BOJ.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2579 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.valueOf(br.readLine());

		int[] steps = new int[n];
		int[] dp = new int[n];

		for(int i = 0; i < n; i++) {
			steps[i] = Integer.valueOf(br.readLine());
		}
		
		if (n <= 0) {
			System.out.println(0);
			return ;
		}
		
		if (n > 0)
			dp[0] = steps[0];
		
		if (n > 1)
			dp[1] = steps[0] + steps[1];
		
		if (n > 2)
			dp[2] = Math.max(steps[0] + steps[2] , steps[1] + steps[2]);

		for (int i = 3; i < n; i++) {
			dp[i] = Math.max(steps[i] + steps[i -1] + dp[i -3], steps[i] + dp[i - 2]);
		}
		

		System.out.println(dp[n - 1]);
	}

	private static void show(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}

}
