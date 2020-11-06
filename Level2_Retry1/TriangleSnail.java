package Programmers.Level2_Retry1;

import java.util.Arrays;

public class TriangleSnail {

	public static void main(String[] args) {
		
		// System.out.println("n : 4 => " + Arrays.toString(solution(4)));
		System.out.println("n : 5 => " + Arrays.toString(solution(5)));
		// System.out.println("n : 6 => " + Arrays.toString(solution(6)));
		
	}

	static int[][] Box;
	static int N, RotateCnt = 1, Col = 1, Row = 1;
	static int V = 1;
	public static int[] solution(int n) {

		Box = new int[n + 1][n + 1];
		N = n;
		
		callRotate();
		
		return getAnswer(n);
	}
	
	static int[] getAnswer(int n) {
		
		int size = 0;
		for (int i = 1; i <= n; i++) {
			size += i;
		}
		
		int[] answer = new int[size];
		
		int seq = 0;
		for (int[] b: Box) {
			for (int num : b) {
				if (num != 0) {
					answer[seq++] = num;
				}
			}
		}
		return answer;
	}
	
	
	static void print() {
		for (int[] b : Box) {
			System.out.println(Arrays.toString(b));
		}
	}
	
	static boolean isFinish() {
		if (N == 0)
			return true;
		return false;
	}
	
	static void callRotate() {
		increaseX();
	}
	// 1. 아래로 => x증가 
	static void increaseX() {
		
		for (int i = 0; i < N; i++) {
			Box[Row++][Col] = V++;			
		}
		Row--;
		Col++;
		N--;
		if(!isFinish()) increaseY();
	}
	// 2. 우측으로 => y증가
	static void increaseY() {
		
		for (int i = 0; i < N; i++) {
			Box[Row][Col++] = V++;
		}
		Col--;
		Row--;
		N--;
		if(!isFinish()) decreaseX();
	}
	// 3. 위로 => x감소
	static void decreaseX() {
		
		int cnt = N;
		
		for (int i = 0; i < N; i++) {
			Box[Row--][Col] = V++;
		}
		RotateCnt++;
		Col = RotateCnt;
		Row += 2;
		N--;
		if(!isFinish()) increaseX();
	}


}
