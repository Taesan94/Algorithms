package Programmers.BackJoon.Implements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem16234 {

	static int N, L, R, Cnt, Sum;
	static int[][] Map, Temp;
	static boolean[][] Visited;

	static int[] X = {0, 0, 1, -1};
	static int[] Y = {1, -1, 0, 0};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.valueOf(st.nextToken());
		L = Integer.valueOf(st.nextToken());
		R = Integer.valueOf(st.nextToken());
		Map = new int[N][N];
		Temp = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				Map[i][j] = Integer.valueOf(st.nextToken());
			}
		}

		int result = 0;

		while (move() == 1) {
			result++;
		}
		System.out.println(result);
	}

	static void changeMap(int avg, boolean[][] v) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (v[i][j]) {
					Temp[i][j] = avg;
					Visited[i][j] = true;
				}
			}
		}
	}

	static void copyArr(int[][] org, int[][] dst) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dst[i][j] = org[i][j];
			}
		}
	}

	static int move() {

		int visitCnt = 0;
		Visited = new boolean[N][N];

		// System.out.println("###");
		// print(Map);

		copyArr(Map, Temp);
		// 0,0 을 기준으로 연결된 모든 정점을 방문한다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				Cnt = 0;
				Sum = 0;
				if (!Visited[i][j]) {
					boolean[][] v = bfs(new Pair(i, j));
					if (Cnt > 1) {
						// System.out.println("Sum : " + Sum +", Cnt : " + Cnt);
						visitCnt++;
						changeMap((Sum / Cnt), v);
						Cnt = 0;
						Sum = 0;
						// Visited = new boolean[N][N]; 
					}
				}
			}
		}
		copyArr(Temp, Map);
		if (visitCnt == 0) 
			return 0;
		return 1;
	}

	static void print(int[][] arr) {
		for (int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
	}
	static boolean[][] bfs(Pair start) {

		Queue<Pair> q = new LinkedList<>();
		q.add(start);
		
		boolean[][] visited = new boolean[N][N];

		while (!q.isEmpty()) {
			Pair p = q.poll();

			if (visited[p.x][p.y])
				continue;
			visited[p.x][p.y] = true;
			Cnt++;
			Sum += Map[p.x][p.y];
			for (int i = 0; i < 4; i++) {
				int nX = p.x + X[i];
				int nY = p.y + Y[i];

				if (nX < 0 || nX >= N || nY < 0 || nY >= N || Visited[nX][nY])
					continue;
				int diff = Math.abs(Map[nX][nY] - Map[p.x][p.y]);
				if (diff >= L && diff <= R) {
					q.add(new Pair(nX, nY));
				}
			}
		}
		return visited;
	}

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
