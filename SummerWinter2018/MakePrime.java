package Programmers.SummerWinter2018;

import java.util.Arrays;

public class MakePrime {

	public static void main(String[] args) {

		int[] nums = {1, 2, 3, 4};
		int[] nums2 = {1,2,7,6,4};

		System.out.println(solution(nums));
		System.out.println(solution(nums2));

	}

	static boolean[] visited;
	static int answer = 0;
	public static int solution(int[] nums) {
		visited = new boolean[nums.length];
		comb(nums, 0, 0, 0);
		return answer;
	}

	static boolean checkPrime(int sum) {
		boolean answer = true;
		for (int i = 2; i <= sum / 2; i++) {
			if (sum % i == 0)
				return false;
		}
		return answer;
	}

	static void comb(int[] nums, int seq, int sum, int start) {

		if (seq == 3) {
			if (checkPrime(sum)) {
				System.out.println(Arrays.toString(visited));
				answer++;
			}
			return ;
		}

		for (int i = start; i < nums.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				comb(nums, seq + 1, sum + nums[i], i + 1);
				visited[i] = false;
			}
		}
	}

}
