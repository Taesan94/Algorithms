package Programmers.BackJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1806 {

	static int[] nums;
	static int[] sums;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.valueOf(st.nextToken());
		int S = Integer.valueOf(st.nextToken());
		nums = new int[N];
		sums = new int[N];

		st = new StringTokenizer(br.readLine());

		int i = 0;
		while (st.hasMoreTokens()) {
			int num = Integer.valueOf(st.nextToken());
			if (num >= S) {
				System.out.println(1);
				return;
			}
			nums[i++] = num;
		}

		int min = Integer.MAX_VALUE;
		int s = 0;
		int e = 0;
		int sum = 0;

		while (s < N) {
			sum += nums[e];
			if (sum >= S) {
				min = Math.min(min, e - s + 1);
				s++;
				e = s;
				sum = 0;
			} else {
				e++;

				if (e == N) {
					s++;
					e = s;
					sum = 0;
				}
			}
		}
		min = (min == Integer.MAX_VALUE) ? 0 : min;
		System.out.println(min);
	}

}
