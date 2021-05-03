package BOJ.ShortestPath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1956 {

    static int INF = 40000001;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.valueOf(st.nextToken());
        int e = Integer.valueOf(st.nextToken());

        int[][] distance = new int[v + 1][v + 1];

        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                //if (i != j)
                    distance[i][j] = INF;
            }
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.valueOf(st.nextToken());
            int to = Integer.valueOf(st.nextToken());
            int value = Integer.valueOf(st.nextToken());

            distance[from][to] = value;
        }

        // k번 정점을 거쳐가는 경우 ?
        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                    for (int j = 1; j <= v; j++) { // i에서 j로 가는 경로,
                        distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                    }
            }
        }


        int result = INF;

        for (int k = 1; k <= v; k++) {
            result = Math.min(result, distance[k][k]);
        }

        if (result == INF)
            result = -1;
        System.out.println(result);
    }
}
