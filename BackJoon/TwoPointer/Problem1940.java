package Programmers.BackJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1940 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.valueOf(br.readLine());
		int m = Integer.valueOf(br.readLine());
		int[] nums = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.valueOf(st.nextToken());
		}

		Arrays.sort(nums);

		System.out.println(Arrays.toString(nums));
		int result = 0;
		int l = 0;
		int r = n - 1;

		while (l < r) {
			int sum = nums[l] + nums[r];
			if (sum > m) {
				r--;
			}
			else if (sum == m) {
				l++;
				r--;
				result++;
			}
			else
				l++;
		}
		System.out.println(result);
	}

}
