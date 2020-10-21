package Programmers.BackJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2531 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.valueOf(st.nextToken()); // 테이블에 놓인 접시의 수
		int d = Integer.valueOf(st.nextToken()); // 초밥의 가짓수
		int k = Integer.valueOf(st.nextToken()); // 연속해서 먹어야하는 접시의 수
		int c = Integer.valueOf(st.nextToken()); // 쿠폰 번호

		int[] sushis = new int[n + 1];

		for (int i = 0; i < n; i++) {
			sushis[i] = Integer.valueOf(br.readLine());
		}

		int cnt = 0;
		int[] visited = new int[d + 1];

		for (int i = 0; i < k; i++) {
			if (visited[sushis[i]] == 0)
				cnt++;
			visited[sushis[i]]++;
		}
		
		int result = cnt;

		for (int i = 1; i < n; i++) {
			
			if (cnt >= result) {
				if (visited[c] == 0)
					result = cnt + 1;
				else
					result = cnt;
			}
			
			visited[sushis[i - 1]]--;
			if (visited[sushis[i - 1]] == 0)
				cnt--;
			if (visited[sushis[(i + k - 1) % n]] == 0)
				cnt++;
			visited[sushis[(i + k - 1) % n]]++;

		}
		System.out.println(result);
	}
}
