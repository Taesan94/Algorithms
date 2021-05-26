package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2866 {

    static int answer = 0;
    static int c, r;
    static String[] strs;

    static void separate_str() {
        for (int i = 0; i < c; i++) {
            strs[i] = strs[i].substring(1, strs[i].length());
        }
    }

    static boolean find() {
        // 동일한 문자열 있는지 확인
        for (int i = 0; i < c; i++) {
            String s = strs[i];
            int idx = Arrays.binarySearch(strs, s);
            if (idx >= 0 && idx != i) {
                return true ;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.valueOf(st.nextToken());
        c = Integer.valueOf(st.nextToken());

        strs = new String[c];
        Arrays.fill(strs, "");
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                strs[j] += s.charAt(j);
            }
        }

        Arrays.sort(strs);
        // System.out.println(Arrays.toString(strs));

        while (true) {
            separate_str();

            if (find()) {
                System.out.println(answer);
                return;
            } else {
                answer++;
            }
        }
    }
}
