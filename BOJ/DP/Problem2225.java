package BOJ.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2225 {
	/*
	 * https://data-make.tistory.com/423 참고..
	 */
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.valueOf(st.nextToken());
		int K = Integer.valueOf(st.nextToken());
		int[][] dp = new int[201][201];
		
		for (int i = 1; i <= K; i++)
			dp[0][i] = 1;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <=K; j++) {
				// 
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000;
			}
		}
		System.out.println(dp[N][K]);
	}
	

}
