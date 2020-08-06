package Programmers.Level3;

public class Problem1 {

	public static void main(String[] args) {

		int n = 4;
		int result = solution(n);
		System.out.println("result : " + result);

	}

	static int[] row;
	static int N;
	static int answer;

	public static int solution(int n) {

		int[][] map = new int[n][n];
		row = new int[n]; // index는 row를 , value 는 col을 의미한다.
		N = n;

		// 행을 기준으로 퀸을 놓아간다, 같은 행, 열에 존재하면 안돼기 때문에 1행의 모든열에 놓았을 때 가능한
		// 조합이 있을 때 answer을 증가시킨다.

		for (int i = 0; i < n; i++) {
			row[0] = i; // 0행의 i번째 열에 퀸을 놓았을 때
			//1행부터 퀸을 놓을 수 있는 자리를 찾아간다.
			dfs(1);

		}
		return answer;
	}
	// 1행부터 모든 놓을 수 있는 위치에 퀸을 놓아준다.    
	private static void dfs(int r) {

		if (r == N) {
			answer++;
			return ;
		}

		for (int i = 0; i < N; i++) {
			row[r] = i;
			if (isPossible(r)) // 해당행에 퀸을 놓을 수 있는 자리가 있다면 순차적으로 놓아간다.
				dfs(r + 1);
			else
				row[r] = 0;
		}
	}

	// 해당 행에 놓을 수 있는지.
	private static boolean isPossible(int r) {
		for (int i = 0; i < r; i++) {

			if (row[i] == row[r]) // 같은 열에 있는 경우
				return false;

			if (Math.abs(row[i] - row[r]) == Math.abs(i - r))// 이전에 대각선에 놓여있는 경우
				return false;
		}
		return true;
	}

}
