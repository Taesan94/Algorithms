package BOJ.PrefixSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem15724 {

    static int N, M;
    static int[][] Map, Rowsum;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());

        Map = new int[N + 1][M + 1];
        Rowsum = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                Map[i][j] = Integer.valueOf(st.nextToken());
                Rowsum[i][j] = Rowsum[i][j -1] + Map[i][j];
            }
        }

        int k = Integer.valueOf(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(getSum(new StringTokenizer(br.readLine())));
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    static int getSum(StringTokenizer st) {
        int sum = 0;
        int x1, y1, x2, y2;

        x1 = Integer.valueOf(st.nextToken());
        y1 = Integer.valueOf(st.nextToken());
        x2 = Integer.valueOf(st.nextToken());
        y2 = Integer.valueOf(st.nextToken());

        for (int i = x1; i <= x2; i++) {
            sum += (Rowsum[i][y2] - Rowsum[i][y1 - 1]);
        }
        return sum;
    }
}
