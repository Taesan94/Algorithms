package BOJ.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem10844 {

    // 직접안품.. 유형에 익숙해지기..
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        long[][] dp = new long[101][11];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][1];
            for (int j = 1; j < 10; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
            }
        }
        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[n][i];
        }

        System.out.println(result % 1000000000);
    }
}
