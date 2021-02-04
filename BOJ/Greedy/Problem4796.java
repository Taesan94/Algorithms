package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Problem4796 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.valueOf(br.readLine());
		
		Integer[] nums = new Integer[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.valueOf(br.readLine());
		}
		Arrays.sort(nums, Collections.reverseOrder());
		
		int max = nums[0];
		for (int i = 1; i < N; i++) {
			max = Math.max(max, nums[i] * (i + 1));
		}
		System.out.println(max);
	}

}
