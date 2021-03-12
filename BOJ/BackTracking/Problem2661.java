package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem2661 {

    static int N;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());

        StringBuilder sb = new StringBuilder("");
        solution(sb);
    }

    static boolean isGood(String s) {
        int len = s.length() / 2;

        for (int i = 1; i <= len; i++) {
            String end = s.substring(s.length() - i);
            String other = s.substring(s.length() - i * 2, s.length() - i);
            if (end.equals(other))
                return false;
        }
        return true;
    }

    static void solution(StringBuilder sb) {

        if (sb.length() == N) {
            System.out.println(sb.toString());
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {
            if (isGood(sb.toString() + i)) {
                solution(new StringBuilder(sb).append(i));
            }
        }
    }
}
