package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem17471 {

    static int N;
    static int[][] Map;
    static int[] Value;
    static int Result = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Value = new int[N + 1];
        Map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Value[i] = Integer.valueOf(st.nextToken());
        }


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.valueOf(st.nextToken());

            for (int j = 0; j < cnt; j++) {
                int v = Integer.valueOf(st.nextToken());
                Map[i][v] = 1;
                Map[v][i] = 1;
            }
        }

        boolean[] visited = new boolean[N + 1];
        // 두개의 구역으로 나눈다.
        permutation(1,0, visited);

        if (Result == Integer.MAX_VALUE)
            Result = -1;
        System.out.println(Result);
    }

    static boolean bfs(int v, boolean[] check) {

        boolean[] visited = new boolean[N + 1];

        Queue<Integer> q = new LinkedList<>();
        q.add(v);

        while (!q.isEmpty()) {

            int curr = q.poll();

            if (visited[curr])
                continue ;
            visited[curr] = true;

            int[] adj = Map[curr];
            for (int i = 1; i <= N; i++) {
                if (adj[i] == 1 && !visited[i] && check[i]) {
                    q.add(i);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (check[i]) {
                if (!visited[i])
                    return false;
            }
        }
        return true;
    }

    static int get_start_idx(boolean[] visited) {
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                return i;
            }
        }
        return -1;
    }

    static boolean is_separate(boolean[] visited) {

       int start = get_start_idx(visited);

       if (start == -1)
           return false;
       if (!bfs(start, visited))
           return false;
       boolean[] reverse = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            reverse[i] = !visited[i];
        }
        start = get_start_idx(reverse);
        if (start == -1)
            return false;
        if (!bfs(start, reverse))
            return false;
        return true;
    }

    static void permutation(int start, int seq, boolean[] visited) {
        // System.out.println(Arrays.toString(visited));

        if (seq > 0 && is_separate(visited)) {

            int v1 = 0;
            int v2 = 0;

            for (int i = 1; i <= N; i++) {
                if (visited[i])
                    v1 += Value[i];
                else
                    v2 += Value[i];
            }
            Result = Math.min(Result, Math.abs(v1 - v2));
        }

        for (int i = start; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(i, seq + 1, visited);
                visited[i] = false;
            }
        }

    }
}
