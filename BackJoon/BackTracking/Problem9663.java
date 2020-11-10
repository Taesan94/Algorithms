package Programmers.BackJoon.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem9663 {

	static int result = 0;
	static int N;
	static int[][] board;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.valueOf(br.readLine());

		board = new int[N][N];
		backTracking(0, 0);
		
		System.out.println(result);
	}

	private static boolean isPossible(int i, int j) {
		// left
		int l = j - 1;
		while (l >= 0) {
			if (board[i][l--] == 1)
				return false;
		}

		// right
		int r = j + 1;
		while (r < N) {
			if (board[i][r++] == 1)
				return false;
		}
		
		// up
		int u = i - 1;
		while (u >= 0) {
			if (board[u--][j] == 1)
				return false;
		}
		
		// leftUp
		u = i - 1;
		int ll = j - 1;
		while (u >= 0 && ll >= 0) {
			if (board[u--][ll--] == 1)
				return false;
		}

		// rightUp
		u = i - 1;
		int rr = j + 1;
		while (u >= 0 && rr < N) {
			if (board[u--][rr++] == 1)
				return false;
		}
		return true;
	}
	
	private static void print() {
		System.out.println("############################");
		for(int[] b: board) {
			System.out.println(Arrays.toString(b));
		}
		System.out.println("############################");
	}
	
	
	private static void backTracking(int start, int cnt) {
		
		if (cnt == N) {
			// print();
			result++;
			return;
		}
		
		int i = start / N;
		int j = start % N;

		while (i < N) {
			while (j < N) {
				start++;
				// System.out.println("i : " + i +" , j : " + j);
				if (isPossible(i, j)) {
					board[i][j] = 1;
					//System.out.printf("i : %d, j : %d 일 때 cnt는 : %d 이다. 다음으로 [ %d, %d ] 좌표를 보겠다. \n", i, j, cnt, (start / N), (start % N));
					// print();
					backTracking(start, cnt + 1);
					board[i][j] = 0;
				}
				j++;
			}
			i++;
			j = 0;
		}
		

	}
}
