package Programmers.BackJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2470 {

	static int n1 = 0;
	static int n2 = 0;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.valueOf(br.readLine());
		int[] nums = new int[N];
		int idx = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			nums[idx++] = Integer.valueOf(st.nextToken());
		}
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		solution(nums, N);
		System.out.println(n1 +" " + n2);
	}
	
	static void solution(int[] nums, int n) {
		
		int left = 0;
		int right = nums.length - 1;
		int min = 2000000000;
		
		while (left < right) {
			
			int diff = nums[left] + nums[right];
			
			if (Math.abs(diff) < min) {
				n1 = nums[left];
				n2 = nums[right];
				min = Math.abs(diff);
			}
			
			if (diff > 0)
				right--;
			else
				left++;
		}
	}

}
