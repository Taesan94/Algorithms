package Programmers.BackJoon.FloydWarshall;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11403 {

	static int N;
	static int INF = 10001;
	static int[][] distances;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.valueOf(br.readLine());

		distances = new int[N][N];

		for (int[] dis : distances) {
			Arrays.fill(dis, INF);
		}
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				if (Integer.valueOf(st.nextToken()) == 1)
					distances[i][j] = 1;
			}
		}

		// 플로이드 와샬
		// 특정 정점 A에서 B로가는경우와, C를 거쳐서가는 경우를 비교한다.
		for(int i = 0; i < N; i++) { // 거쳐가는 정점
			for (int j = 0; j < N; j++) { // 시작 정점
				for (int k = 0; k < N; k++) { // 도착 정점
					if (distances[j][i] + distances[i][k] < distances[j][k]) {
						distances[j][k] = distances[j][i] + distances[i][k];
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (distances[i][j] != INF)
					sb.append(1 );
				else
					sb.append(0);
				if (j != N-1)
					sb.append(" ");
			}
			if (i != N - 1)
				sb.append("\n");
		}
		System.out.println(sb.toString());

	}

}
