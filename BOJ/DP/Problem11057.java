package BOJ.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem11057 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());

        if (n == 1){
            System.out.println(10);
            return ;
        }

        long[][] dp = new long[1001][10];

        // [n][start] => n일 때, 시작 숫자가 i일 때 가능한 경우의 숫자는 ?
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        long result = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i - 1][k] % 10007;
                }
                if (i == n)
                    result += dp[i][j] % 10007;
            }
        }
        System.out.println(result % 10007);

//        System.out.println("sum ### ");
//        System.out.println(Arrays.toString(prevsum));
//        print(n , dp);


    }

    static void print(int n , long[][] dp) {
        for (int i = 0; i <= n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }

    // 직접안품.. 유형에 익숙해지기..
    public static void p_10844() throws Exception {

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
