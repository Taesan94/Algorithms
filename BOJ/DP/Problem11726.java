package BOJ.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem11726 {

	static int[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.valueOf(br.readLine());
		dp = new int[n + 1];

		solution(n);
		System.out.println(dp[n]);
	}
	static int solution(int n) {
		System.out.println(n);
		if (n <= 2)
			return dp[n] = n;
		if (dp[n] != 0)
			return dp[n];
		return dp[n] = ( solution(n - 1) + solution(n - 2) ) % 10007;
	}
}
