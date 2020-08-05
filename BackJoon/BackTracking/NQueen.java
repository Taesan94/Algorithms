package Programmers.BackJoon.BackTracking;

import java.util.Scanner;

public class NQueen {
	
	static int answer = 0;
	static int n;
	static int[] row;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		row = new int[n];
		
		// 0행 n열에 퀸을 놓았을 때, 만들 수 있는 모든 경우의 수를 센다.
		for (int i = 0; i < n; i++) {
			// 0행 i열에 퀸 배치
			row[0] = i;
			// 다음 행부터 놓을 수 있는 열에 퀸을 놓아간다.
			dfs(1);
		}
		System.out.println(answer);
	}
	
	private static void dfs(int r) {
		
		if (r == n) {
			answer++;
			return ;
		}
		
		// 퀸을 놓을 수 있는 열을 찾는다.
		for( int i = 0; i < n; i++) {
			row[r] = i;
			// 놓을 수 있다면, 다음행에 퀸을 채우러 간다.
			if(isPossible(r))
				dfs(r + 1);
			else
				row[r] = 0;
		}
	}
	// 해당 행에 놓을 수 있는 퀸을 찾는다.
	private static boolean isPossible(int r) {
		
		for (int i = 0; i < r; i++) {
			// 같은 열에 퀸이 존재해서는 안된다. 한 행씩 채워나가고 있기 때문에 행의 중복은 발생하지 않는다.
			if (row[i] == row[r])
				return false;
			// 현재 행 이전의 체스들이 대각선에(V)에 존재해서는 안된다.
			if (Math.abs(row[i] - row[r]) == Math.abs(i - r))
				return false;
		}
		return true;
	}

}
