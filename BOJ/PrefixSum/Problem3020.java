package BOJ.PrefixSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem3020 {

    static int N, H;
    static int[] up, down;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        H = Integer.valueOf(st.nextToken());

        int len = N / 2;

        int[] sum_up, sum_down;

        up = new int[H + 1];
        down = new int[H + 1];
        sum_up = new int[H + 1];
        sum_down = new int[H + 1];

        int seq = 1;

        for (int i = 1; i <= N; i++) {
            if (i % 2 == 0)
                up[Integer.valueOf(br.readLine())]++;
            else
                down[Integer.valueOf(br.readLine())]++;
        }

        for (int i = 1; i <= H; i++) {
            sum_up[i] = sum_up[i - 1] + up[i];
            sum_down[i] = sum_down[i - 1] + down[i];
        }

        System.out.println(Arrays.toString(sum_up));
        System.out.println(Arrays.toString(sum_down));

        int min = N;
        int cnt = 0;

        for (int i = 1; i <= H; i++) {
            int crush = 0; // 부딪히는 개수

            // 부딪히는 석순의 갯수 = 전체 석순의 갯수 - (i-1)이하인 석순의 갯수
            crush += sum_down[H] - sum_down[i - 1];
            // 부딪히는 종유석의 갯수 = 전체 종유석갯수 - (h-i)이하인 종유석의 갯수
            crush += sum_up[H] - sum_up[H - i];

            if (min > crush) {
                min = crush;
                cnt = 1;
            } else if (min == crush) {
                cnt++;
            }
        }
        System.out.println(min + " " + cnt);
    }
}
