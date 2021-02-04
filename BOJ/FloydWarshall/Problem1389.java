package BOJ.FloydWarshall;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1389 {
	static int N, M;
	static int INF = 500001;
	static int[][] distances;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());

		distances = new int[N + 1][N + 1];
		for (int[] dis : distances) {
			Arrays.fill(dis, INF);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int f1 = Integer.valueOf(st.nextToken());
			int f2 = Integer.valueOf(st.nextToken());
			distances[f1][f2] = 1;
			distances[f2][f1] = 1;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i != j && (distances[i][k] + distances[k][j] < distances[i][j]))
						distances[i][j] = distances[i][k] + distances[k][j];
				}
			}
		}
		
		int[] sums = new int[N + 1];
		sums[0] = INF;
		int min = INF;
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int num : distances[i]) {
				if (num != INF)
					sum += num;
			}
			if (sum != 0) {
				sums[i] = sum;
				min = Math.min(min, sum);
			}
			else
				sums[i] = INF;
		}
		
		for (int i = 1; i <= N; i++) {
			if (min == sums[i]) {
				System.out.println(i);
				break ;
			}
		}
	}

}
