package Programmers.BackJoon.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11047 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		int goal = Integer.valueOf(st.nextToken());
		
		int[] coins = new int[n];
		
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.valueOf(br.readLine());
		}
		
		int answer = 0;

		// 먼저, 큰 값부터 몫이 1이상인 값을 먼저 찾는다.
		int i = coins.length - 1;
		while (i >= 0) {
			if (goal / coins[i] > 0) {
				int value = goal / coins[i];
				answer += value;
				goal = goal - (value * coins[i]);
				if (goal == 0)
					break;
			}
			i--;
		}
		System.out.println(answer);
		
	}
}
