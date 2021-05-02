package BOJ.ShortestPath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11404 {

    static int N, M, INF = 10000001;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.valueOf(br.readLine());
        M = Integer.valueOf(br.readLine());

        // 정점 i에서 시작해서 j로가는데 걸리는 비용
        int[][] distance = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j)
                    distance[i][j] = INF;
            }
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int from = Integer.valueOf(st.nextToken());
            int to = Integer.valueOf(st.nextToken());
            int value = Integer.valueOf(st.nextToken());

            distance[from][to] = Math.min(distance[from][to], value);
        }

        // 1회전을 했을 때, 1번 정점에서 다른정점으로가는 모든 거리를 구해야 한다. 처음에 i에서 j를거쳐 k로가는 거리로구하다.. 순서가 꼬여서 틀림.. ㅠ
        // j에서 k로 가는 최단거리.
        // 바로가거나, i를 거쳐가거나.
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    for (int k = 1; k <= N; k++) {
                        if (i != k && j != k) {
                            distance[j][k] = Math.min(distance[j][k], distance[j][i] + distance[i][k]);
                            // System.out.printf("%d -> %d 로 %d를 거쳐서 가는 경우 최소 = %d\n", i, k, j , distance[i][k]);
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder("");

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (distance[i][j] == INF)
                    distance[i][j] = 0;
                sb.append(distance[i][j]);
                if (j != N)
                    sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());


    }


}
