package Programmers.BackJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem7453 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		int[][] arr = new int[4][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				arr[j][i] = Integer.valueOf(st.nextToken());
			}
		}
		
		int[] oneTwo = new int[n * n];
		int[] threeFour = new int[n * n];
		
		int idx = 0;

		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++) {
				oneTwo[idx] = arr[0][i] + arr[1][j];
				threeFour[idx] = arr[2][i] + arr[3][j];
				idx++;
			}
		}
		Arrays.sort(threeFour);
		long result = 0;
		for (int num : oneTwo) {
			int upper = upperBound(threeFour, -num);			
			int lower = lowerBound(threeFour, -num);
			result += upper - lower;
		}
		System.out.println(result);
		
	}
	
	static int upperBound(int[] arr, int num) {
		int l = 0;
		int r = arr.length;
		
		while (l < r) {
			int mid = (l + r) / 2;
			if (arr[mid] <= num) {
				l = mid + 1;
			} else
				r = mid;
		}
		return r;		
	}	
	static int lowerBound(int[] arr, int num) {
		
		int l = 0;
		int r = arr.length;
		
		while (l < r) {
			int mid = (l + r) / 2;
			if (arr[mid] >= num)
				r = mid;
			else
				l = mid + 1;
		}
		return r;
	}

}
