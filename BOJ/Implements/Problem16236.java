package BOJ.Implements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem16236 {

	static int N, SharkSize, EatCnt, Result, MAX;
	static Pair Shark;
	static int[][] Map;
	static int[] X = {0, 0, 1, -1};
	static int[] Y = {1, -1, 0, 0};

	public static void main(String[] args) throws Exception {
		Result = 0;
		MAX = 10000;
		SharkSize = 2;
		EatCnt = 0;
		set_input();

		while (bfs()) {
			if (EatCnt == SharkSize) {
				SharkSize++;
				EatCnt = 0;
			}
		}
		System.out.println(Result);
	}

	static boolean bfs() {

		int[][] distance = new int[N + 1][N + 1];
		int minX = 21;
		int minY = 21;
		int minDistance = MAX;

		Queue<Pair> q = new LinkedList<>();

		q.add(Shark);
		while (!q.isEmpty()) {

			Pair p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nX = p.x + X[i];
				int nY = p.y + Y[i];
				if (nX < 1 || nX > N || nY < 1 || nY > N)
					continue;
				if (distance[nX][nY] != 0 || Map[nX][nY] > SharkSize)
					continue;
				distance[nX][nY] = distance[p.x][p.y] + 1;
				
				q.add(new Pair(nX, nY));

				if (Map[nX][nY] < SharkSize && Map[nX][nY] > 0) {
					if (distance[nX][nY] < minDistance) {
						minX = nX;
						minY = nY;
						minDistance = distance[nX][nY];
					}
					else if (distance[nX][nY] == minDistance) {
						if ((nX < minX) || ((nX == minX) && (nY < minY))) {
							minX = nX;
							minY = nY;
						}
					}
				}
			}
		}
		if (minDistance != MAX) {
			EatCnt++;
			Result += minDistance;
			Map[minX][minY] = 0;
			Shark = new Pair(minX, minY);
			return true;
		}
		return false;
	}
	static void set_input() throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.valueOf(br.readLine());
		Map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int n = Integer.valueOf(st.nextToken());
				if (n == 9) {
					Shark = new Pair(i, j);
					n = 0;
				}
				Map[i][j] = n;
			}
		}
	}

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

}
