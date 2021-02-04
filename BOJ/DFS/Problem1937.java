package BOJ.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1937 {

	static int[][] Visited;
	static int[][] Map;
	static int N;

	static int[] X = {0, 0, 1, -1};
	static int[] Y = {1, -1, 0, 0};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.valueOf(br.readLine());
		Map = new int[N][N];
		Visited = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				Map[i][j] = Integer.valueOf(st.nextToken());
			}
		}

		int max = 0;
		// 모든 좌표가 시작점일 때, 갈 수 있는 일수 K를 구해서 Max찾기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (Visited[i][j] == 0)
					max = Math.max(max, dfs(i, j));
			}
		}
		System.out.println(max);
	}

	static int dfs(int x, int y) {
		if (Visited[x][y] == 0) {
			Visited[x][y] = 1;
			for (int i = 0; i < 4; i++) {

				int nX = x + X[i];
				int nY = y + Y[i];

				if (nX < 0 || nX >= N || nY < 0 || nY >= N)
					continue;
				if (Map[nX][nY] > Map[x][y]) {
					Visited[x][y] = Math.max(Visited[x][y], dfs(nX, nY) + 1);
				}
			}
		}
		return Visited[x][y];
	}

}
