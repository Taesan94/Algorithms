package BOJ.PrefixSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10986 {

    static int N, M;

    /*
        https://donggod.tistory.com/77 참조
     */

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int nmg = 0;
        long[] nmgCnts = new long[M + 1];

        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Integer.valueOf(st.nextToken());
            nmg = (int)(sum % M); // 처음 ~ 현재 위치까지의 합을 M으로 나눈 나머지를 저장.
            nmgCnts[nmg]++;
        }
        long answer = nmgCnts[0];
        for (int i = 0; i < M; i++) {
            if (nmgCnts[i] >= 2) {
                answer += nmgCnts[i] * (nmgCnts[i] - 1) / 2;
            }
        }
        System.out.println(answer);
    }
}
