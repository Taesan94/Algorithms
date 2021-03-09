package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1759_retry {

    static int L, C;
    static char[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder("");

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.valueOf(st.nextToken());
        C = Integer.valueOf(st.nextToken());
        arr = new char[C];
        visited = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        StringBuilder s = new StringBuilder("");
        solution(0, 0, s);
        System.out.println(sb.toString());
    }

    static boolean is_moeum(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }

    static void solution(int start, int cnt, StringBuilder s) {

        if (cnt == L) {
            int mo = 0;
            int ja = 0;
            for (int i = 0; i < L; i++) {
                if (is_moeum(s.charAt(i)))
                    mo++;
                else
                    ja++;
            }
            if (mo >= 1 && ja >= 2)
                sb.append(s).append("\n");
            return ;
        }

        for (int i = start; i < C; i++) {
            if (!visited[i]) {
                visited[i] = true;
                StringBuilder s2 = new StringBuilder(s).append(arr[i]);
                solution(i + 1, cnt + 1, s2);
                visited[i] = false;
            }
        }
    }
}
