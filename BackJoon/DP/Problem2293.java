package Programmers.BackJoon.DP;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem2293 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		StringTokenizer st = new StringTokenizer(scan.nextLine());
		
		int n = Integer.valueOf(st.nextToken());
		int k = Integer.valueOf(st.nextToken());
		
		int[] coins = new int[n + 1];
		int[] dp = new int[k + 1];
		
		dp[0] = 1;
		for (int i = 1; i <= n; i ++) {
			coins[i] = Integer.valueOf(scan.nextLine());
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = coins[i]; j <= k; j++) { // j원을 만드는데 필요한 경우의 수 + coins[i]의 값이 되니깐....
				//System.out.println("j : " + j +", coins[" + i +"] : " + coins[i]);
				System.out.println("dp["+j+"]"+ " = " + "dp[" + j + "] + " + "dp[" + (j - coins[i]) + "];" );
				dp[j] += dp[j - coins[i]];
				
			}
		}
		System.out.println(dp[k]);
	}

}
