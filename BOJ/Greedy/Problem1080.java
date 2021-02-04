package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1080 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		
		int[][] A = new int[n][m];
		int[][] B = new int[n][m];
		
		setArr(A, br);
		setArr(B, br);
		
		int cnt = 0;
		for (int i = 0; i < n - 2; i++) {
			for (int j = 0; j < m - 2; j++) {
				if (A[i][j] != B[i][j]) {
					cnt++;
					toggle(A, i, j);
				}
			}
		}
		if (isSame(A, B))
			System.out.println(cnt);
		else
			System.out.println(-1);
		
	}
	
	static void toggle(int[][] A, int i, int j) {
		for (int s = i; s < i + 3; s++) {
			for (int s2 = j; s2 < j + 3; s2++) {
				A[s][s2] = A[s][s2] == 0 ? 1 : 0;
			}
		}
	}
	
	static boolean isSame(int[][] A, int[][] B) {
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				if (A[i][j] != B[i][j])
					return false;
			}
		}
		return true;
	}
	
	static void print(int[][] arr) {
		for (int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
	}
	
	static void setArr(int[][] arr, BufferedReader br) throws Exception {
		for (int i = 0; i < arr.length; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
	}

}
