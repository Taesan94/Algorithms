package Programmers.BackJoon.Strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem13275 {

	static boolean[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int n = s.length();
		dp = new boolean[n][n];
		System.out.println(makeDp(n, s.toCharArray()));
	}
	
	static int makeDp(int n, char[] arr) {
		
		int max = 1;
		
		// 1
		for (int i = 0; i < n; i++)
			dp[i][i] = true;
		
		// 2
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				max = 2;
				dp[i][i + 1] = true;
			}
		}
		
		// 3이상 시작 = 끝이면서, 시작 + 1 끝 - 1이 펠린드롬이면 가능 !
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				if (arr[j] == arr[j + i] && dp[j + 1][j + i - 1]) {
					max = i + 1;
					dp[j][j + i] = true;
				}
			}
		}
		return max;
	}

}
