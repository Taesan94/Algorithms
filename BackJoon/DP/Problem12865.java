package Programmers.BackJoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem12865 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		int k = Integer.valueOf(st.nextToken());
		
		int[] w = new int[n + 1];
		int[] v = new int[n + 1];
		// i번째 물건을 담았을 때, j크기의 가방의 최대 가치는 ??
		int[][] dp = new int[n + 1][k + 1];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			w[i + 1] = Integer.valueOf(st.nextToken());
			v[i + 1] = Integer.valueOf(st.nextToken());
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				// i 번째 물건의 크기가, j보다  작거나 같을 때만 담을 수 있다.
				if (w[i] <= j) {
					// 이전 물품을 담았을 때 저장된 j크기 배낭의 max 값과
					// [현재 가치 + 이전  물품을 담았을 때 [j - 현재무개]만큼 더한 경우를 비교한다.
					// ex) j == 7이고, 3번째 물품의 크기가 3이다 라고하면, 2번째 물품의 크기4의 max값과 비교.
					dp[i][j] = Math.max(dp[i - 1][j], v[i] + dp[i - 1][j - w[i]]);
				} else { 
					// 담을 수 없을 때는 i - 1번째 물건을 담았을 때의 최대값을 가져온다.
					// 즉, 무게가 j인 상태에서, i번째 물건을 넣기 전 상태.
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		// 결국, 마지막 물품을 j크기에 담았을 때의 최대가치가 저장된다.
		System.out.println(dp[n][k]);
	}	
}
