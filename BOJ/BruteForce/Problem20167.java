package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem20167 {

    static int N, K, Result = 0;
    static int[] Feeds;

    static void find(int seq, int sum, int energy) {

        if (sum >= K) {
            //System.out.printf("seq : %d, sum : %d, energy : %d\n",seq, sum, energy);
            energy += sum - K;
            sum = 0;
        }

        if (seq > N) {
            // System.out.printf("sum : %d, energy : %d\n", sum , energy);
            Result = Math.max(Result, energy);
            return ;
        }

       // System.out.printf("sum : %d, Feeds[%d] : %d\n", sum , seq, Feeds[seq]);
        // 먹었을 때
        find(seq + 1,sum + Feeds[seq], energy);
        // 안먹었을 때
        find(seq + 1,0, energy);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);
        N = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(st.nextToken());
        Feeds = new int[N + 1];

        s = br.readLine();
        st = new StringTokenizer(s);
        for (int i = 1; i <= N; i++) {
            Feeds[i] = Integer.valueOf(st.nextToken());
        }
        find(1, 0, 0);
        System.out.println(Result);
        br.close();
    }
}
