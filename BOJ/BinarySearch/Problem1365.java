package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1365 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] connect = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            connect[i] = Integer.valueOf(st.nextToken());
        }


    }
}
