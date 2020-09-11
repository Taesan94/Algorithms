package Programmers.KAKAO_BLIND_2020;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MoveBlock_retury {

	public static void main(String[] args) {

		int[][] board = {
				{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}
		};	
		System.out.println("result : " + solution(board));
	}

	// 상,하,좌,우
	static int[] x = {0,0,1,-1};
	static int[] y = {1,-1,0,0};

	// 가로이면,

	// 왼쪽 바퀴고정에 ,
	// 오른쪽바퀴가 왼쪽의 x -1 x + 1

	// 오른쪽 바퀴 고정에
	// 왼쪽 바퀴가 오른쪽의 x -1 x + 1

	// 세로이면,

	// 위쪽 바퀴 고정에 ,
	// 아래쪽 바퀴가 위쪽의 y -1 y + 1

	// 아래쪽 바퀴 고정에 ,
	// 위쪽 바퀴가 아래쪽 바퀴의 y -1 y +1

	static int N;
	static int[][] board2;
	static boolean[][][][] visited; 

	public static int solution(int[][] board) {
		int answer = 0;

		N = board.length;
		
		visited = new boolean[N + 2][N + 2][N + 2][N + 2];
		board2 = new int[N + 2][N + 2];

		for (int i = 0; i < N; i ++) {
			for (int j = 0; j < N; j ++) {
				board2[i + 1][j + 1] = board[i][j];
			}
		}
		
		for (int i = 0; i < N + 2; i++) {
			board2[i][0] = -1;
			board2[i][N + 1] = -1;
		}
		
		Arrays.fill(board2[0], -1);
		Arrays.fill(board2[N + 1], -1);
		

		Robot r = new Robot(new int[] {1, 1} , new int[] {1, 2});
		Queue<Robot> q = new LinkedList<>();
		Queue<Robot> q2 = new LinkedList<>();

		q.add(r);
		while (!q.isEmpty()) {

			Robot wk = q.poll();
			
			int[] p1 = wk.p1;
			int[] p2 = wk.p2;
			
			if ((p1[0] == N && p1[1] == N) || (p2[0] == N && p2[1] == N))
				return answer;
			
			for (int i = 0; i < 4; i++) {
				
				int[] nextP1 = new int[] {p1[0] + x[i], p1[1] + y[i]};
				int[] nextP2 = new int[] {p2[0] + x[i], p2[1] + y[i]};
				
				if (isPossible2(nextP1, nextP2)) {
					q2.add(new Robot(nextP1, nextP2));
				}
			}
			
			// 가로로 있을 때 가능한 좌표 보기
			if (Math.abs(p1[1] - p2[1]) == 1) {
				// p1 기준으로 위 
				if (board2[p2[0] - 1][p2[1]] == 0 && isPossible2(p1, new int[] {p1[0] -  1, p1[1]})) {
					q2.add(new Robot(p1, new int[] {p1[0] - 1 , p1[1]}));
				}
				// p1 기준 아래
				if (board2[p2[0] + 1][p2[1]] == 0 && isPossible2(p1, new int[] {p1[0] +  1, p1[1]})) {
					q2.add(new Robot(p1, new int[] {p1[0] + 1 , p1[1]}));
				}
				
				// p2 기준으로 위 
				if (board2[p1[0] - 1][p1[1]] == 0 && isPossible2(new int[] {p2[0] - 1 , p2[1]}, p2)) {
					q2.add(new Robot(new int[] {p2[0] - 1 , p2[1]}, p2));
				}
				// p2 기준 아래
				if (board2[p1[0] + 1][p1[1]] == 0 && isPossible2(new int[] {p2[0] + 1 , p2[1]}, p2)) {
					q2.add(new Robot(new int[] {p2[0] + 1 , p2[1]}, p2));
				}
			}
			
			// 세로로 있을 때 가능한 좌표 보기
			if (Math.abs(p1[0] - p2[0]) == 1) {
				
				// p1 기준으로 왼쪽 
				if (board2[p2[0]][p2[1] - 1] == 0 && isPossible2(p1, new int[] {p1[0] , p1[1] - 1})) {
					q2.add(new Robot(p1, new int[] {p1[0] , p1[1] - 1}));
				}
				
				// p1 기준 오른쪽
				if (board2[p2[0]][p2[1] + 1] == 0 && isPossible2(p1, new int[] {p1[0] , p1[1] + 1})) {
					q2.add(new Robot(p1, new int[] {p1[0] , p1[1] + 1}));
				}
				
				// p2 기준으로 왼쪽 
				if (board2[p1[0]][p1[1] - 1] == 0 && isPossible2(new int[] {p2[0] , p2[1] - 1}, p2)) {
					q2.add(new Robot(new int[] {p2[0] , p2[1] - 1}, p2));
				}
				
				// p2 기준 오른쪽
				if (board2[p1[0]][p1[1] + 1] == 0 && isPossible2(new int[] {p2[0] , p2[1] + 1}, p2)) {
					q2.add(new Robot(new int[] {p2[0] , p2[1] + 1}, p2));
				}
			}

			if (q.isEmpty() && !q2.isEmpty()) {
				System.out.println(q.toString());
				q.addAll(q2);
				q2.clear();
				answer++;
			}
		}
		return answer;
	}
	
	static boolean isPossible2(int[] p1, int[] p2) {

		if (visited[p1[0]][p1[1]][p2[0]][p2[1]] || visited[p2[0]][p2[1]][p1[0]][p1[1]] ) {
			return false;
		}
		
		if (board2[p1[0]][p1[1]] == 0 && board2[p2[0]][p2[1]] == 0) {
			visited[p1[0]][p1[1]][p2[0]][p2[1]] = true;
			visited[p2[0]][p2[1]][p1[0]][p1[1]] = true;
			return true;
		}
		return false;
	}
	

	static class Robot {

		int[] p1;
		int[] p2;

		Robot(int[] p1, int[] p2){
			this.p1 = p1;
			this.p2 = p2;
		}

		public String toString() {
			return Arrays.toString(p1)+", " + Arrays.toString(p2) + "\n";
		}
	}

}
