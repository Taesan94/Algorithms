package Programmers.BackJoon.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem1920 {

	static int[] arr;
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int n = Integer.valueOf(scan.nextLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(scan.nextLine());

		int i = 0;
		while(st.hasMoreTokens()) {
			arr[i++] = Integer.valueOf(st.nextToken());
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));

		int m = Integer.valueOf(scan.nextLine());
		st = new StringTokenizer(scan.nextLine());

		while(st.hasMoreTokens()) {
			System.out.println(binarySearch(0, n - 1, Integer.valueOf(st.nextToken())));
		}

	}

	static int binarySearch(int start, int end,  int num) {

		while (start <= end) {
			
			// 중간지점 부터.. 
			int mid = (start + end) / 2;
			int value = arr[mid];
			
			// System.out.printf("start : %d, end : %d , num : %d, value : %d , mid : %d\n" , start, end , num, value, mid);
			
			if (num < value) {
				end = mid - 1;
			} else if (num > value) {
				start = mid + 1;
			} else if (num == value) {
				return 1;
			}
		}

		return 0;
	}

}
