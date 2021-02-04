package BOJ.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem19621 {

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
		int result = 0;
		if (N == 1)
			result = dp[0];
		if (N >= 2) {
			dp[1] = info[1].peoples;
			result = Math.max(dp[0], dp[1]);
		}
		// 3번째 회의부터는, [ 현재 인원 + N - 2번째의 최대 인원 ] 중 Max를 구할 수 있다.  
		for (int i = 2; i < N; i++) {
			// System.out.println(Arrays.toString(dp));
			for (int j = i - 2; j >= 0; j--) {
				dp[i] = Math.max(dp[j] + info[i].peoples, dp[i]);
			}
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
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
