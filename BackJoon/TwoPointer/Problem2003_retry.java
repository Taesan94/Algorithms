package Programmers.BackJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2003_retry {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		int[] nums = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.valueOf(st.nextToken());
		}

		int result = 0;

		int l = 0;
		int r = 0;
		int s = 0;

		while (true) {

			if (s >= M) {
				s -= nums[l++];
			} else if (r == N)
				break; // 마지막 s == M 조건을 한번더 보기 위해 종료조건을 여기다 포함시킨다.
			else 
				s += nums[r++];
			if (s == M)
				result++;
		}
		System.out.println(result);

	}

}
