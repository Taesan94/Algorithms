package BOJ.FloydWarshall;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11404 {

	static int N, M;
	static int INF = 100000001;
	static int[][] distances;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.valueOf(br.readLine());
		M = Integer.valueOf(br.readLine());

		distances = new int[N + 1][N + 1];

		for (int[] dis : distances) {
			Arrays.fill(dis, INF);
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int from = Integer.valueOf(st.nextToken());
			int to = Integer.valueOf(st.nextToken());
			int v = Integer.valueOf(st.nextToken());
			
			distances[from][to] = Math.min(distances[from][to],v);
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j =1; j <= N; j++) {
					if (i != j && (distances[i][k] + distances[k][j] < distances[i][j]))
						distances[i][j] = distances[i][k] + distances[k][j];
				}
			}
		}
		
		StringBuilder sb = new StringBuilder("");
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int d = distances[i][j];
				if (d == INF)
					sb.append(0);
				else
					sb.append(d);
				if (j != N)
					sb.append(" ");
			}
			if (i != N)
				sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
}
