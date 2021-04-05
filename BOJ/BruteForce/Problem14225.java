package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem14225 {

    static int INF = 2000000;
    static int[] nums;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.valueOf(br.readLine());
        nums = new int[n];
        visited = new boolean[INF + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.valueOf(st.nextToken());
            visited[nums[i]] = true;
        }
        permutation(0, 0);
        int result = get_min();
        System.out.println(result);
    }

    static int get_min() {
        for (int i = 1; i <= INF; i++) {
            if (!visited[i])
                return i;
        }
        return -1;
    }

    static void permutation(int start, int idx) {

        visited[idx] = true;

        for (int i = start; i < n; i++) {
            permutation(i + 1, idx + nums[i]);
        }
    }
}
