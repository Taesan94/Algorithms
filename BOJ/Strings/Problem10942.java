package BOJ.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10942 {

	static boolean[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.valueOf(br.readLine());
		dp = new boolean[N + 1][N + 1];
		int[] nums = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++)
			nums[i] = Integer.valueOf(st.nextToken());

		makeDp(N, nums);
		
		int M = Integer.valueOf(br.readLine());

		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.valueOf(st.nextToken());
			int e = Integer.valueOf(st.nextToken());
			if (dp[s][e])
				sb.append("1\n");
			else
				sb.append("0\n");
		}
		System.out.println(sb);
	}
	
	static void makeDp(int n, int[] nums) {
		
		// 1
		for (int i = 1; i <= n; i++)
			dp[i][i] = true;
		
		// 2
		for (int i = 1; i < n; i++) {
			if (nums[i] == nums[i + 1])
				dp[i][i + 1] = true;
		}
		
		// 3이상 시작 = 끝이면서, 시작 + 1 끝 - 1이 펠린드롬이면 가능 !
		for (int i = 2; i < n; i++) {
			for (int j = 1; j <= n - i; j++) {
				if (nums[j] == nums[j + i] && dp[j + 1][j + i - 1])
					dp[j][j + i] = true;
			}
		}
	}

}
