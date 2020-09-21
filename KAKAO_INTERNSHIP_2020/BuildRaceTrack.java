package Programmers.KAKAO_INTERNSHIP_2020;

import java.util.LinkedList;
import java.util.Queue;

public class BuildRaceTrack {

	public static void main(String[] args) {

		int[][] board = {
				 // {0, 0, 0},{0, 0, 0},{0, 0, 0}
				 {0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}
				// {0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}
				// {0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}

		};

		System.out.println("result : " + solution(board));

	}

	static int N;

	// 동, 서, 남, 북
	static int[] posX = {0, 0, 1, -1};
	static int[] posY = {1, -1, 0, 0};
	static int[][] boardSt;
	static int answer = Integer.MAX_VALUE;

	public static int solution(int[][] board) {

		boardSt = board;
		N = board.length;

		// 기록.
		// 현재 위치를 기준으로 갈 수 있는 방향은 모두 넣어줌.
		// 현재 보고있는 방향이 아니라면, 직각인 경우이다.
		// 모두 기록하면서.. 끝났을 때 최소 값찾기.
		// 시작위치는 남, 동 2방향만 가능하다.
		boardSt[0][0] = 1;
		bfs(new Root(0, 0, -1, 0));

		return answer;
	}

	static void bfs(Root start) {
		
		Queue<Root> q = new LinkedList<Root>();
		q.add(start);
		
		while (!q.isEmpty()) {
			Root r = q.poll();
			
			if (r.x == N - 1 && r.y == N - 1) {
				answer = Math.min(answer, r.value);
				continue;
			}

			for (int i = 0; i < 4; i++) {

				int nX = r.x + posX[i];
				int nY = r.y + posY[i];

				if (nX >= 0 && nX < N && nY >= 0 && nY < N && boardSt[nX][nY] != 1) {
					
					int value2 = r.value + 100;

					if (i != r.look && r.look != -1) { // 같은 방향이 아니라면.
						value2 += 500;
					}

					if (boardSt[nX][nY] == 0 || value2 <= boardSt[nX][nY]) {
						boardSt[nX][nY] = value2;
						q.add(new Root(nX, nY, i, value2));
					}
				}
			}
		}
	}

	static class Root {

		int x;
		int y;
		int look;
		int	value;

		Root(int x, int y, int look, int value){
			this.x = x;
			this.y = y;
			this.look = look;
			this.value = value;
		}

		public String toString() {
			return "x : " + x + ", y : " + y +", look : " + look;
		}

	}

}
