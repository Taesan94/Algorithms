package BOJ.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1149_rere {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        int[][] color = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            color[i][0] = Integer.valueOf(st.nextToken());
            color[i][1] = Integer.valueOf(st.nextToken());
            color[i][2] = Integer.valueOf(st.nextToken());
        }

        // 각 색깔은 선택했을 때,
        // 다음 row에서 현재위치의 최솟값을 찾자.

        int[][] dp = new int[N][3];

        dp[0] = color[0];
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + color[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + color[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + color[i][2];
        }
        Arrays.sort(dp[N - 1]);
        System.out.println(dp[N - 1][0]);
    }
}
