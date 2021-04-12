package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem1747 {

    static long N;

    static boolean is_prime(long num) {

        long max = (long)Math.sqrt(num);
        long cnt = (max - 2 + 1) / 2;
        for (int i = 0; i <= cnt; i++) {
            if ((num % (i + 2) == 0) || (num % (max - i) == 0))
                return false;
        }
        return true;
    }

    static boolean is_pd(long num) {

        String s = String.valueOf(num);

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.valueOf(br.readLine());

        if (N > 3) {
            while (true) {
                if (is_prime(N) && is_pd(N))
                    break ;
                N++;
            }
        }
        if (N == 1)
            N = 2;
        System.out.println(N);
    }
}
