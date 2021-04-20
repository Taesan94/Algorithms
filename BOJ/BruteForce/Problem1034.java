package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1034 {

    static int N, M;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        int k = Integer.valueOf(br.readLine());

        int answer = 0;
        for (int i = 0; i < N; i++) {
            String s = arr[i];

            int cnt = 0;
            for (int j = 0; j < M; j++) {
                if (s.charAt(j) == '0')
                    cnt++;
            }

            int row = 0;
            if (cnt <= k && (cnt % 2 == k % 2)) {
                for (int r = 0; r < N; r++) {
                    if (arr[i].equals(arr[r]))
                        row++;
                }
                answer = Math.max(row, answer);
            }
        }
        System.out.println(answer);
    }
}
