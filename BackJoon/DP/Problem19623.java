package Programmers.BackJoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem19623 {

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
		System.out.println(Arrays.toString(info));

		// 결국 i번째회의를 했을때와 하지않았을 경우를 보면서 최대값 찾기.
		// 0은 봤을 떄, 1은 안 봤을 때
		int[][] dp = new int[N][2];
		// idx 번째회의까지 참여할 수 있는 최대인원 기록.
		dp[0][0] = info[0].peoples;
		dp[0][1] = 0;
		int max = dp[0][0];
		
		for (int i = 1; i < N; i++) {
			if (info[i].start >= info[i - 1].end) {
				dp[i][0] = max + info[i].peoples;
				dp[i][1] = dp[i][0];
			}
			
		}
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
