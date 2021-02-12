package BOJ.PrefixSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem13398 {

    static int N, Result;
    static int[] Num;
    public static void main(String[] args) throws Exception {

        // 현재 수 + 이전합과, 현재의 수를 비교.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());

        Num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            Num[i] = Integer.valueOf(st.nextToken());

        int[] lSum = new int[N + 1];
        int[] rSum = new int[N + 1];

        lSum[0] = Num[0];
        rSum[N - 1] = Num[N - 1];

        for (int i = 1; i < N; i++) {
            lSum[i] = Math.max(lSum[i - 1] + Num[i], Num[i]);
            Result = Math.max(Result, lSum[i]);
        }

        for (int i = N - 2; i >= 0; i--) {
            rSum[i] = Math.max(rSum[i + 1] + Num[i], Num[i]);
        }

        for (int i = 1; i < N - 1; i++) {
            Result = Math.max(Result, lSum[i - 1] + rSum[i + 1]);
        }
        System.out.println(Result);
    }

}
