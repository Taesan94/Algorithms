package BOJ.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11055 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 가장 큰 수열 + 1
        int n = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.valueOf(st.nextToken());
        }

        // 이전 숫자까지 올 수 있는 최대 수의 합을 저장.
        int[] dp = new int[n];
        int result = -1;
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + nums[i]);
                }
            }
            result = Math.max(dp[i], result);
        }
        System.out.println(result);
    }
}
