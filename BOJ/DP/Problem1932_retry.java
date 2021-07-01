package BOJ.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1932_retry {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());

        int[][] triangle = new int[n + 2][n + 2];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int j = 1;
            while (st.hasMoreTokens()) {
                triangle[i][j++] = Integer.valueOf(st.nextToken());
            }
        }

        int dp[][] = new int[n + 2][n + 2];

        dp[1][1] = triangle[1][1];

        int end = 2;
        for (int i = 2; i <= n; i++) {
            int j = 1;
            while (j <= end) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
                j++;
            }
            end++;
        }

        int[] last = dp[n];
        Arrays.sort(last);

        System.out.println(last[n + 1]);
    }
}
