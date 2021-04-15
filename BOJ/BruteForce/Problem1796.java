package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1796 {

    static String S;
    static int[][] StartEnd;
    static int Result = Integer.MAX_VALUE;

    static void find_distance(char alpha, int curr, int sum) {
        // System.out.printf("alpha : %c, curr : %d, sum : %d\n", alpha, curr, sum);
        if (alpha > 'z') {
            System.out.println("sum : " + sum);
            Result = Math.min(Result, sum);
            return ;
        }
        int min = StartEnd[alpha - 'a'][0];
        int max = StartEnd[alpha - 'a'][1];
        // System.out.printf("min : %d, max : %d\n", min , max);
        int distance = max - min;
        if (distance == 0) { // 문자가 하나 존재.
            find_distance((char)(alpha + 1), min, sum + Math.abs(curr - min));
        } else if (distance > 0) { // 두개 이상의 문자가 존재
            find_distance((char)(alpha + 1), min, sum + Math.abs(curr - max) + distance);
            find_distance((char)(alpha + 1), max, sum + Math.abs(curr - min) + distance);
        } else { // 없는 경우, 알파벳만 ++ 하기
            find_distance((char)(alpha + 1), curr, sum);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();

        StartEnd = new int[26][2];

        for (int i = 0; i < 26; i++) {
            StartEnd[i][0] = 1001;
            StartEnd[i][1] = -1;
        }
        for (int i = 0; i < S.length(); i++) {
            int idx = S.charAt(i) - 'a';
            StartEnd[idx][0] = Math.min(StartEnd[idx][0], i);
            StartEnd[idx][1] = Math.max(StartEnd[idx][1], i);
        }
        find_distance('a', 0, 0);
        System.out.println(Result + S.length());
    }
}
