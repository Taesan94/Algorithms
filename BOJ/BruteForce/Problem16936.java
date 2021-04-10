package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Problem16936 {

    static int N;
    static long[] nums;
    static long[] Result;
    static Map<Long, Integer> map = new HashMap<>();

    static void is_possible(long n, int seq) {

        Result[seq] = n;
        if (seq == N - 1) {
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < N; i++) {
                sb.append(Result[i]);
                if (i != N - 1)
                    sb.append(" ");
            }
            System.out.println(sb.toString());
            return ;
        }
        if (n % 3 == 0) {
            long num = n / 3;
            int cnt = map.getOrDefault(num, 0);
            if (cnt > 0) {
                map.put(num, cnt - 1);
                is_possible(n / 3, seq + 1);
                map.put(num, cnt);
            }
        }
        int cnt = map.getOrDefault((n * 2), 0);
        if (cnt > 0) {
            long num = n * 2;
            map.put(num, cnt - 1);
            is_possible(n * 2, seq + 1);
            map.put(num, cnt);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        nums = new long[N];
        Result = new long[N];

        for (int i = 0; i < N; i++) {
            long num = Long.valueOf(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
            nums[i] = num;
        }

        for (int i = 0; i < N; i++) {
            is_possible(nums[i], 0);
        }
    }
}
