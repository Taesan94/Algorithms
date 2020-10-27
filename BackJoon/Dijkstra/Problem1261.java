package Programmers.BackJoon.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1261 {

	static int[][] miro;
	static int[] X = {0,0,1,-1};
	static int[] Y = {1,-1,0,0};
	static int M, N;
	static int result = 0;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.valueOf(st.nextToken());
		N = Integer.valueOf(st.nextToken());

		miro = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				miro[i][j] = line.charAt(j) - '0';
			}
		}
		bfs();
	}
	
	static void bfs() {
		
		boolean[][] visited = new boolean[N][M];
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(0, 0, 0));
		
		while (!pq.isEmpty()) {
			Pair p1 = pq.poll();
			
			if (visited[p1.x][p1.y])
				continue;
			
			if (p1.x == N - 1 && p1.y == M - 1) {
				System.out.println(p1.w);
				return ;
			}
			
			visited[p1.x][p1.y] = true;
			
			for (int i = 0; i < 4; i++) {
				
				int nX = p1.x + X[i];
				int nY = p1.y + Y[i];
				
				if (nX < 0 || nX >= N || nY < 0 || nY >= M)
					continue;
				
				if (!visited[nX][nY]) {
					pq.add(new Pair(nX, nY, p1.w + miro[nX][nY]));
				}
			}
		}
	}

	static class Pair implements Comparable<Pair> {

		int x;
		int y;
		int w;

		Pair(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
		@Override
		public int compareTo(Pair o) {
			return this.w - o.w;
		}
		public String toString() {
			return "[ x : " + x +",  y : " + y +", w : " + w +" ]";
		}
	}

}
