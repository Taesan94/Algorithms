package Programmers.BackJoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1149_retry {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.valueOf(br.readLine());
		
		int[][] arr = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.valueOf(st.nextToken());
			arr[i][1] = Integer.valueOf(st.nextToken());
			arr[i][2] = Integer.valueOf(st.nextToken());
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				int min = 1000001;
				for (int k = 0; k < 3; k++) {
					if (j != k)
						min = Math.min(min, arr[i][j] + arr[i - 1][k]);
				}
				arr[i][j] = min;
			}
		}
		int[] result = arr[N - 1];
		Arrays.sort(result);
		System.out.println(result[0]);
	}

}
