package Programmers.BackJoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem19622 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		Meeting[] info;
		
		info = new Meeting[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.valueOf(st.nextToken());
			int end = Integer.valueOf(st.nextToken());
			int peoples = Integer.valueOf(st.nextToken());
			info[i] = new Meeting(start, end, peoples);
		}
		Arrays.sort(info);
		
		int[] dp = new int[N];
		// idx 번째회의까지 참여할 수 있는 최대인원 기록.
		dp[0] = info[0].peoples;
		int max = 0;
		if (N >= 1)
			max = dp[0];
		if (N >= 2) {
			dp[1] = info[1].peoples;
		}
		// i번째에 계산 될 max값을 한칸씩 ++하면서 갱신해 나간다.
		for (int i = 2; i < N; i++) {
			dp[i] = info[i].peoples + max;
			max = Math.max(max, dp[i - 1]);
		}
		max = Math.max(max, dp[N - 1]);
		System.out.println(max);
	}
	
	static class Meeting implements Comparable<Meeting>{
		int start;
		int end;
		int peoples;

		public Meeting(int start, int end, int peoples) {
			this.start = start;
			this.end = end;
			this.peoples = peoples;
		}
		
		@Override
		public int compareTo(Meeting o) {
			int result = this.start - o.start;
			if (result == 0)
				result = this.end - o.end;
			if (result == 0)
				result = o.peoples - this.peoples;
			return result;
		}

		@Override
		public String toString() {
			return "Meeting [start=" + start + ", end=" + end + ", peoples=" + peoples + "]\n";
		}
	}

}
