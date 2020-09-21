package Programmers.BackJoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem1912 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		int[] prevSum = new int[n];
		
		String[] nums = br.readLine().split(" ");
		
		int numsZero = Integer.valueOf(nums[0]);
		int max = numsZero;
		prevSum[0] = numsZero;
		
		for (int i = 1; i < nums.length; i++) {
			int num = Integer.valueOf(nums[i]);
			prevSum[i] = Math.max(prevSum[i - 1] + num, num);
			max = Math.max(max, prevSum[i]);
		}
		System.out.println(max);
	}
}
