package Programmers.BackJoon.Implements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem14500 {

	static int N, M, Max;
	static int[][] Board;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		Board = new int[N][M];
		Max = -1;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				Board[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		line();
		square();
		nien_zigzeg_fuck();
		System.out.println(Max);
	}

	static void line() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if ((j + 3) < M)
					Max = Math.max(Max, (Board[i][j] + Board[i][j + 1] + Board[i][j + 2] + Board[i][j + 3]));
				else
					break ;
			}
		}
		for (int i = 0; i < N; i++) {
			if (i + 3 >= N)
				break ;
			for (int j = 0; j < M; j++) {
				Max = Math.max(Max, Board[i][j] + Board[i + 1][j] + Board[i + 2][j] + Board[i + 3][j]);
			}
		}
	}
	
	static void square() {
		
		for (int i = 0; i < N; i++) {
				if (i + 1 >= N)
					break ;
			for (int j = 0; j < M; j++) {
				if (j + 1 >= M)
					break ;
				Max = Math.max(Max, Board[i][j] + Board[i + 1][j] + Board[i][j + 1] + Board[i + 1][j + 1]);
			}
		}
	}
	
	static void nien_zigzeg_fuck() {
		for (int i = 0; i < N; i++) {
			if ((i + 2) >= N)
				break ;
			for (int j = 0; j < M; j++) {
				if ((j + 1) >= M)
					break ;
				Max = Math.max(Max, Board[i][j] + Board[i + 1][j] + Board[i + 2][j] + Board[i][j + 1]);
				Max = Math.max(Max, Board[i][j] + Board[i + 1][j] + Board[i + 2][j] + Board[i + 2][j + 1]);
				
				Max = Math.max(Max, Board[i][j] + Board[i][j + 1] + Board[i + 1][j + 1] + Board[i + 2][j + 1]);
				Max = Math.max(Max, Board[i + 2][j] + Board[i][j + 1] + Board[i + 1][j + 1] + Board[i + 2][j + 1]);
				
				Max = Math.max(Max, Board[i][j] + Board[i + 1][j] + Board[i + 1][j + 1] + Board[i + 2][j + 1]);
				Max = Math.max(Max, Board[i][j + 1] + Board[i + 1][j] + Board[i + 1][j + 1] + Board[i + 2][j]);
				
				Max = Math.max(Max, Board[i + 1][j] + Board[i][j + 1] + Board[i + 1][j + 1] + Board[i + 2][j + 1]);
				Max = Math.max(Max, Board[i][j] + Board[i + 1][j] + Board[i + 2][j] + Board[i + 1][j + 1]);
			}
		}
		
		for (int i = 0; i < N; i++) {
			if ((i + 1) >= N)
				break ;
			for (int j = 0; j < M; j++) {
				if ((j + 2) >= M)
					break ;
				Max = Math.max(Max, Board[i][j] + Board[i][j + 1] + Board[i][j + 2] + Board[i + 1][j]); 
				Max = Math.max(Max, Board[i][j] + Board[i][j + 1] + Board[i][j + 2] + Board[i + 1][j + 2]);
				
				Max = Math.max(Max, Board[i + 1][j] + Board[i + 1][j + 1] + Board[i + 1][j + 2] + Board[i][j + 2]);
				Max = Math.max(Max, Board[i + 1][j] + Board[i + 1][j + 1] + Board[i + 1][j + 2] + Board[i][j]);
				
				
				Max = Math.max(Max, Board[i][j] + Board[i][j + 1] + Board[i + 1][j + 1] + Board[i + 1][j + 2]);
				Max = Math.max(Max, Board[i][j + 1] + Board[i][j + 2] + Board[i + 1][j] + Board[i + 1][j + 1]);
				Max = Math.max(Max, (Board[i][j] + Board[i][j + 1] + Board[i][j + 2] + Board[i + 1][j + 1]));
				Max = Math.max(Max, (Board[i + 1][j] + Board[i + 1][j + 1] + Board[i + 1][j + 2] + Board[i][j + 1]));
			}
		}
	}

	static void print(int[][] arr) {
		for(int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
	}

}
