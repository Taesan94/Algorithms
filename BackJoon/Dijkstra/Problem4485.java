package Programmers.BackJoon.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem4485 {

	static int[][] miro;
	static int[] X = {0,0,1,-1};
	static int[] Y = {1,-1,0,0};
	static int M, N;
	static int result = 0;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.valueOf(br.readLine());
		int seq = 1;
		while (N != 0) {
			miro = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					miro[i][j] = Integer.valueOf(st.nextToken());
				}
			}
			System.out.println("Problem " + seq++ + ": " + bfs());
			N = Integer.valueOf(br.readLine());
		}
	}
	
	static int bfs() {
		
		boolean[][] visited = new boolean[N][N];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(0, 0, miro[0][0]));
		
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			
			if (p.x == N - 1 && p.y == N - 1)
				return p.w;
			
			if (visited[p.x][p.y])
				continue;
			visited[p.x][p.y] = true;
			
			for (int i = 0; i < 4; i++) {
				int nX = p.x + X[i];
				int nY = p.y + Y[i];
				
				if (nX >= 0 && nX < N && nY >= 0 && nY < N && !visited[nX][nY])
					pq.add(new Pair(nX, nY, p.w + miro[nX][nY]));
			}
		}
		
		return -1;
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
	}

}
