package BOJ.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem1038 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        long result = (n == 0) ? 0 : -1;
        int cnt = 0;
        Queue<Long> q = new LinkedList<>();

        // 내림수의 가장 마지막수는 9876543210 이다.
        for (int i = 1; i < 10; i++) {
            q.add(Long.valueOf(i));
        }

        while (!q.isEmpty()) {

            long num = q.poll();
            cnt++;

            if (cnt == n) {
                result = num;
                break ;
            }
            long last = num % 10;

            for (int i = 0; i < last; i++) {
                q.add(num * 10 + i);
            }
        }
        System.out.println(result);
    }
}
