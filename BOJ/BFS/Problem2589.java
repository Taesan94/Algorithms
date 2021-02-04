package BOJ.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem2589 {
	
	static int N, M;
	static char[][] Map;
	static int[][] Distance;
	static List<List<Pair>> Island = new ArrayList<>();
	
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		
		Map = new char[N][M];
		Distance = new int[N][M];
		for (int i = 0 ; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				Map[i][j] = s.charAt(j);
			}
		}
		for (int i = 0; i < N; i++) {
			
			for (int j = 0; j < M; j++) {
				if (Map[i][j] == 'L')
					Island.add(new ArrayList<>());
					Island.get(0);
					bfs(i, j);
					isLand++;
			}
		}
		
		System.out.println(Island.size());
		
		// 돌아갔는지를 어떻게 알지.. ?
	}
	
	static void print(char[][] arr) {
		for (char[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
	}
	
	static int isLand = 0;
	static int[] X = {1, -1, 0, 0};
	static int[] Y = {0, 0, 1, -1};
	
	static void bfs(int x, int y) {
		
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		boolean[][] visited = new boolean[N][M];
		
		while (!q.isEmpty()) {
			Pair p = q.poll();
			
			if (visited[p.x][p.y])
				continue;
			else {
				visited[p.x][p.y] = true; 
				Map[p.x][p.y] = (char)isLand;
				Island.get(isLand).add(p);
			}
			
			for (int i = 0 ; i < 4; i++) {
				int nX = p.x + X[i];
				int nY = p.y + Y[i];
				
				if (nX < 0 || nY < 0 || nX >= N || nY >= M || visited[nX][nY] || Map[nX][nY] != 'L')
					continue;
				q.add(new Pair(nX, nY));
			}	
		}
	}
	
	
	int[][] distance; // 정점[i 에서][j로 가는 최단거리] 가 기록된다.
	int INF = Integer.MAX_VALUE; // 초기 값으로 i -> j로가는 최단거리는 Max다! 라고 설정해주어야 한다. 

	private int[][] start(int n, List<Pair> connect, int inf) {
		distance = new int[n + 1][n + 1];
		INF = inf;

		// 초기 값 SET
		for (int i = 0; i <= n; i++) {
			Arrays.fill(distance[i], INF);
		}

		// 초기 거리 SET
		for (Pair p : connect) {
			distance[p.x][p.y] = 1;
		}

		floydWarshall(n);
		return distance;
	}

	// n은 정점의 갯수이다. 1~n까지의 정점이 있다고 가정한다.
	private void floydWarshall(int n) {

		for (int k = 1; k <= n; k++ ) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) { // i에서 j로가는 경로 vs i에서 k를거쳐서 j로가는 경로중 작은 값으로 채워주기
					if (distance[i][k] + distance[k][j] < distance[i][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
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

		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
		
	}

}
