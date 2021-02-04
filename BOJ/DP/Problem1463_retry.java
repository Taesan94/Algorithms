package BOJ.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem1463_retry {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		solution_dp(n);
		
	}
	
	void solution_self(int n) {
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(n, 0));
		
		while (!q.isEmpty()) {
			
			Info info = q.poll();
			
			if (info.num == 1) {
				System.out.println(info.seq);
				break ;
			}
			if (info.num % 3 == 0)
				q.add(new Info(info.num / 3 , info.seq + 1));
			if (info.num % 2 == 0)
				q.add(new Info(info.num / 2 , info.seq + 1));
			if (info.num - 1 >= 1)
				q.add(new Info(info.num - 1 , info.seq + 1));
		}
	}
	
	static void solution_dp(int n) {
		
		// 숫자i를 1로 만드는 최소횟수.
		int[] dp = new int[n + 1];
		
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + 1;
			if (i % 2 == 0)
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			if (i % 3 == 0)
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
		}
		System.out.println(dp[n]);
	}
	
	static class Info {
		
		int num;
		int seq;
		
		Info (int num , int seq) {
			this.num = num;
			this.seq = seq;
		}
	}

}
