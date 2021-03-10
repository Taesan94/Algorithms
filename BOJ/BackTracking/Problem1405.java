package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1405 {

    static int N;
    static int MAX = 14 * 2 + 1;
    static double[] values = new double[4];
    static boolean[][] visited;
    static double result = 0.0;

    // e, w, s, n
    static int[] posX = {1, -1, 0, 0};
    static int[] posY = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        visited = new boolean[MAX][MAX];

        for (int i = 0; i < 4; i++)
            values[i] = Integer.valueOf(st.nextToken()) * 0.01;
        solution(14, 14, 0, 1.0);
        System.out.printf("%.10f", result);
    }

    static void solution(int x, int y, int cnt, double value) {

        if (cnt == N) {
            result += value;
            return ;
        }

        if (!visited[x][y]) {
            visited[x][y] = true;

            for (int i = 0; i < 4; i++) {

                int nX = x + posX[i];
                int nY = y + posY[i];

                if (nX < 0 || nY < 0 || nX >= MAX || nY >= MAX)
                    continue;
                if (!visited[nX][nY]) {
                    solution(nX, nY, cnt + 1, value * values[i]);
                    visited[nX][nY] = false;
                }
            }
        }
    }
}
