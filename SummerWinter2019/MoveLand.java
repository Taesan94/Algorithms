package Programmers.SummerWinter2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MoveLand {

	public static void main(String[] args) {

		int[][] land = {
//				{10, 11, 10, 11}, {2, 21, 20, 10}, {1, 20, 21, 11}, {2, 1, 2, 1}
				{4, 10, 15, 20},
				{20, 15, 20, 15},
				{4, 10, 15, 20},
				{20, 15, 20, 15}
//				{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}
				
		};

		int height = 3;

		System.out.println("result : " + solution(land, height));

	}


	static int[] posX = {0, 0, 1, -1};
	static int[] posY = {1, -1, 0, 0};

	static int N, H;
	static boolean[][] visited;
	static int[][] landStat;
	public static int solution(int[][] land, int height) {
		int answer = 0;

		N = land.length;
		H = height;
		visited = new boolean[N][N];
		landStat = land;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// bfs 끊길때까지 방문
				if (!visited[i][j]) {
					List<Pair> visit = bfs(new Pair(i, j));
					int min = connectMin(visit,new Pair(i, j));
					answer += min;
				}
			}
		}
		return answer;
	}
	
	static void check(List<Pair> visit) {
		for (int i = 0; i < visit.size(); i++) {
			Pair p = visit.get(i);
			visited[p.x][p.y] = true;
		}
	}

	static int connectMin(List<Pair> visit, Pair start) {
		
		int min = 10001;
		
		if (start.x == 0 && start.y == 0) {
			check(visit);
			return 0;
		}
		
		for (int i = 0; i < visit.size(); i++) {
			
			Pair p = visit.get(i);
			
			
			for (int j = 0; j < 4; j++) {
				
				int nextX = p.x + posX[j];
				int nextY = p.y + posY[j];
				
				if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
					if (visited[nextX][nextY]) {
						min = Math.min(min, Math.abs(landStat[p.x][p.y] - landStat[nextX][nextY]));
					}
				}
			}
		}
		
		check(visit);
		
		return min;
	}

	static List<Pair> bfs(Pair start){

		int min = 10001;

		Queue<Pair> q = new LinkedList<>();
		List<Pair> visit = new ArrayList<>();
		boolean[][] visitChk = new boolean[N][N];
		
		q.add(start);

		while(!q.isEmpty()) {

			Pair p = q.poll();

			if (visitChk[p.x][p.y])
				continue;

			visitChk[p.x][p.y] = true;
			visit.add(new Pair(p.x, p.y));

			for (int i = 0; i < 4; i++) {

				int nextX = p.x + posX[i];
				int nextY = p.y + posY[i];

				if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
					if (!visited[nextX][nextY] && !visitChk[nextX][nextY] && Math.abs(landStat[p.x][p.y] - landStat[nextX][nextY]) <= H) {
						q.add(new Pair(nextX, nextY));
					}
				}
			}
		}

		return visit;
	}

	static void print(boolean[][] arr) {
		for (boolean[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
	}

	static class Pair {

		int x;
		int y;

		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return "x : " + x +", y : " + y;
		}
	}

}
