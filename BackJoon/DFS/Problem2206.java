package Programmers.BackJoon.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem2206 {

	static int N, M, Result;
	static int[][] Map;
	static int[] X = {1, -1, 0, 0};
	static int[] Y = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		Result =  Integer.MAX_VALUE;

		Map = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			for (int j = 1; j <= M; j++) {
				Map[i][j] = s.charAt(j - 1) - '0';
			}
		}

		bfs();
		if (Result == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(Result);


	}

	static void bfs() {

		// x, y 좌표에 돌을 뿌시고 왔을 때 방문여부 (0)
		// x, y 좌표에 돌을 안뿌시고 왔을 때 방문여부 (1)
		boolean[][][] visited = new boolean[N + 1][M + 1][2];

		Queue<Pair> pairs = new LinkedList<>();
		pairs.add(new Pair(1, 1, 1, 0));

		while (!pairs.isEmpty()) {
			Pair p = pairs.poll();

			if (p.x == N && p.y == M) {
				Result = p.seq;
				return ;
			}

			if (visited[p.x][p.y][p.destroy])
				continue;
			visited[p.x][p.y][p.destroy] = true;

			for (int i = 0; i < 4; i++) {
				int nX = p.x + X[i];
				int nY = p.y + Y[i];

				if (nX < 1 || nY < 1 || nX > N || nY > M)
					continue;

				if (Map[nX][nY] == 1) { // 벽인경우
					if (p.destroy == 0 && !visited[nX][nY][1])
						pairs.add(new Pair(nX, nY, p.seq + 1, 1));
				} else {
					if (!visited[nX][nY][p.destroy])
						pairs.add(new Pair(nX, nY, p.seq + 1, p.destroy));
				}
			}
		}
	}

	static void print(int[][] arr) {
		for (int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
	}

	static class Pair {
		int x;
		int y;
		int seq;
		int destroy; // 

		public Pair(int x, int y, int seq, int destroy) {
			this.x = x;
			this.y = y;
			this.seq = seq;
			this.destroy = destroy;
		}
	}

}
