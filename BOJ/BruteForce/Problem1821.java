package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1821 {

    static int N, F;
    static int[][] Map;
    static int[] Result;
    static boolean[] visited;

    static boolean find(int seq) {

        if (seq == N) {
            int[] arr = Map[0];

            for (int i = 1; i < N; i++) {
                for (int j = 0; j < N - i; j++) {
                    Map[i][j] = Map[i - 1][j] + Map[i - 1][j + 1];
                }
            }
            if (Map[N - 1][0] == F) {
                Result = arr;
                return true;
            }
            return false;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                Map[0][seq] = i + 1;
                if (find(seq + 1))
                    return true;
                visited[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        F = Integer.valueOf(st.nextToken());

        visited = new boolean[N];
        Map = new int[N][N];
        Result = new int[N];

        find(0);
        for (int i = 0; i < N; i++) {
            System.out.print(Result[i]);
            if (i != N - 1)
                System.out.print(" ");
        }
    }
}
