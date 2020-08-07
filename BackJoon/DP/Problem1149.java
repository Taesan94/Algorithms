package Programmers.BackJoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1149 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		int[][] mins = new int[n][3];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			mins[i][0] = Integer.valueOf(st.nextToken());
			mins[i][1] = Integer.valueOf(st.nextToken());
			mins[i][2] = Integer.valueOf(st.nextToken());
		}
		
		// 1행부터, 각 열에 최솟값을 구해나간다.
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				int min = 1000001;
				for (int k = 0; k < 3; k++) {
					if (j != k)
						min = Math.min(min, mins[i - 1][k] + mins[i][j]);
				}
				mins[i][j] = min;
			}
		}
		
		int[] result = mins[n - 1];
		Arrays.sort(result);
		System.out.println(result[0]);
	}
	
	private static void show(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}

}
