package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Problem17141 {

    static int N, M, Empty = 0, Result = Integer.MAX_VALUE;
    static int[][] Map, CopyMap;
    static List<Pair> Possible = new ArrayList<>();
    static boolean[][] Visited;
    static int[] X = {0, 0, 1, -1};
    static int[] Y = {1, -1, 0, 0};

    static void pos_print(int[] pos) {
        for (int i = 0; i < pos.length; i++) {
            System.out.println(Possible.get(pos[i]));
        }
    }

    static void print() {
        System.out.println("### ");
        for(int[] a : CopyMap) {
            System.out.println(Arrays.toString(a));
        }
    }

    static boolean all_infection() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (CopyMap[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    static void infection(int[] pos) {

        int cnt = 0;
        Queue<Pair> curr = new LinkedList<>();

        for (int i = 0; i < pos.length; i++) {
            curr.add(Possible.get(pos[i]));
        }
        // System.out.println(curr.toString());
        while (!curr.isEmpty()) {
            Pair p = curr.poll();
            if (Visited[p.x][p.y])
                continue;
            Visited[p.x][p.y] = true;

            for (int i = 0; i < 4; i++) {
                int nX = p.x + X[i];
                int nY = p.y + Y[i];
                if (nX > 0 && nY > 0 && nX <= N && nY <= N) {
                    if (!Visited[nX][nY] && CopyMap[nX][nY] == 0) {
                        CopyMap[nX][nY] = 1;
                        curr.add(new Pair(nX, nY, p.cnt + 1));
                        cnt = Math.max(cnt, p.cnt + 1);
                    }
                }
            }
        }
        if (all_infection())
            Result = Math.min(Result, cnt);
    }

    static void copyMap(int[] pos) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int v = Map[i][j];
                if (v == -2)
                    v = 0;
                CopyMap[i][j] = v;
            }
        }
        for (int i : pos) {
            Pair p = Possible.get(i);
            CopyMap[p.x][p.y] = 2;
        }
    }

    static void combination(int start, int seq, int[] pos, boolean[] visited) {
        if (seq == M) {
            int empty = Empty;
            Visited = new boolean[N + 1][N + 1];
            copyMap(pos);
            infection(pos);
            return ;
        }
        for (int i = start; i < Possible.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                pos[seq] = i;
                combination(i + 1, seq + 1, pos, visited);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        Map = new int[N + 1][N + 1];
        CopyMap = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int v = Integer.valueOf(st.nextToken()) * -1;
                if (v == -2)
                    Possible.add(new Pair(i, j, 0));
                Map[i][j] = v;
            }
        }
        if (Possible.size() == 0) {
            if (all_infection())
                System.out.println(0);
            System.out.println(-1);
            return ;
        }
        // Possible 에서 M개를 뽑는 모든 조합을 찾는다.
        int[] pos = new int[M];
        boolean[] visited = new boolean[Possible.size()];
        combination(0, 0, pos, visited);
        if (Result == Integer.MAX_VALUE)
            Result = -1;
        System.out.println(Result);

        // 바이러스를 퍼뜨려 본다.

        // 모든 빈공간을 채울 수 있을 때 최소시간을 찾는다.

    }

    static class Pair {
        int x;
        int y;
        int cnt;

        public Pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
