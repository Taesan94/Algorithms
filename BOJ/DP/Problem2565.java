package BOJ.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2565 {

    static int MAX = 501;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());

        int[][] arr = new int[MAX][MAX];

        int max = -1;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.valueOf(st.nextToken());
            int to = Integer.valueOf(st.nextToken());

            arr[from][to] = 1;
            arr[to][from] = 1;
            max = Math.max(max, Math.max(from, to));
        }

        // working





    }
}
