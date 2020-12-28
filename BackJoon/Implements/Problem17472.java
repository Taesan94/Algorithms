package Programmers.BackJoon.Implements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem17472 {

	static int N, M;
	static int[][] Map;
	static boolean[][] Visited;
	static int[] Parents;
	static int[] X = {1, 0, -1, 0};
	static int[] Y = {0, 1, 0, -1};

	static PriorityQueue<Pair> isLands;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		Map = new int[N][M];


		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++ ) {
				Map[i][j] = Integer.valueOf(st.nextToken()) == 1 ? 7 : 0;
			}
		}

		Visited = new boolean[N][M];
		int seq = 1;

		// 구역 나누기.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++ ) {
				if (!Visited[i][j] && Map[i][j] == 7)
				{
					Map[i][j] = seq;
					dfs(i, j, seq);
					seq++;
				}
			}
		}
		Parents = new int[seq];
		for (int i = 1; i < seq; i++) {
			Parents[i] = i;
		}
		isLands = new PriorityQueue<>();
		// 연결 가능한 정점간의 간선정보 기록하기.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++ ) {
				if (Map[i][j] != 0) {
					int from = Map[i][j];
					checkRow(i, j, from);
					checkCol(i, j, from);
				}
			}
		}
		print(Map);
//		System.out.println(" edges ## ");
		System.out.println(isLands.toString());
		int min = kruskal();
		for (int i = 2; i < seq; i++) {
			if (Parents[i] == i) {
				System.out.println(-1);
				return ;
			}
		}
		System.out.println(min);
	}
	public static int getParent(int v) {
		if (Parents[v] == v)
			return v;
		return getParent(Parents[v]);
	}
	public static void union(int big, int small) {

		big = getParent(big);
		small = getParent(small);

		if (small > big) {
			int temp = small;
			small = big;
			big = temp;
		}
		Parents[big] = small; // big의 부모는 small이다. 
	}

	static int kruskal() {

		int sum = 0;

		while (!isLands.isEmpty()) {

			Pair p = isLands.poll();
			if (getParent(p.from) != getParent(p.to)) {
				// System.out.println(p.from +" 에서 " +p.to+" 로 가는 비용은 : " + p.v);
				sum+=p.v;
				union(p.from, p.to);
			}
		}
		return sum;
	}

	static void checkRow(int i, int j, int from) {
		for (int k = j + 1; k < M; k++) {
			if (Map[i][k] == from)
				return ;
			else if (Map[i][k] == 0)
				continue;
			else {
				int len = k - j - 1;
				if (len >= 2) {
					isLands.add(new Pair(from, Map[i][k], len));
				}
				return ;
			}
		}
	}

	static void checkCol(int i, int j, int from) {
		for (int k = i + 1; k < N; k++) {
			if (Map[k][j] == from)
				return ;
			else if (Map[k][j] == 0)
				continue;
			else {
				int len = k - i - 1;
				if (len >= 2) {
					isLands.add(new Pair(from, Map[k][j], len));
				}
				return ;
			}
		}
	}

	static void dfs(int i, int j, int seq) {
		Visited[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int nextI = i + X[k];
			int nextJ = j + Y[k];
			if (nextI < N && nextJ < M && nextI >= 0 && nextJ >= 0) { 
				if (Map[nextI][nextJ] == 7 && !Visited[nextI][nextJ]) {
					Map[nextI][nextJ] = seq;
					dfs(nextI, nextJ, seq);
				}
			}
		}
	}

	static class Pair implements Comparable<Pair> {
		int from;
		int to;
		int v;

		public Pair(int from, int to, int v) {
			super();
			this.from = from;
			this.to = to;
			this.v = v;
		}
		@Override
		public int compareTo(Pair o) {
			return this.v - o.v;
		}
		@Override
		public String toString() {
			return "Pair [from=" + from + ", to=" + to + ", v=" + v + "]\n";
		}

	}

	static void print(int[][] arr) {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}

	static void print2(int[][] arr, int seq) {
		for (int i = 0; i < seq; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}

}
