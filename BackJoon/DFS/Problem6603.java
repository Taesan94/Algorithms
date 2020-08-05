package Programmers.BackJoon.DFS;

import java.util.Arrays;
import java.util.Scanner;

public class Problem6603 {
	
	static StringBuilder sb = new StringBuilder();
	static String[] nums;
	static int k;
	static int cnt = 0;
	static int start;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		while(true) {
			String[] input = scan.nextLine().split(" ");
			k = Integer.valueOf(input[0]);
			
			if(k == 0)
				break;

			start = 0;
			nums = new String[k];
			
			for (int i = 1; i < k + 1; i++) {
				nums[i - 1] = input[i];
			}
			
			for (int i = 0; i <= (k - 6); i++) {
				cnt = 1;
				dfs(i, nums[i] + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

	private static void dfs(int start, String str) {
		if (cnt == 6) {
			sb.append(str + "\n");
		}else {
			for (int i = start + 1; i < k; i++) {
				cnt++;
				dfs(i, str + nums[i] + " ");
			}
		}
		cnt--;
	}

	private static void show(int[][] arr) {
		for(int i = 0 ; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
}
