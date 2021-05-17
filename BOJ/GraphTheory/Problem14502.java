package BOJ.GraphTheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Problem14502 {

    static int N, M;
    static List<Pair> zeros = new ArrayList<>();
    static int[][] Map;
    static boolean[] Visited;
    static boolean[][] Visited2;
    static int[] Pos = new int[3];
    static int Result = 0;
    static int[] X = {0, 0, 1, -1};
    static int[] Y = {1, -1, 0, 0};

    static void bfs(Pair p, int[][] map) {

        Queue<Pair> q = new LinkedList<>();
        q.add(p);

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            if (Visited2[cur.x][cur.y])
                continue;
            Visited2[cur.x][cur.y] = true;

            for (int i = 0; i < 4; i++) {
                int nX = cur.x + X[i];
                int nY = cur.y + Y[i];

                if (nX >= 0 && nX < N && nY >= 0 && nY < M) {
                    if (!Visited2[nX][nY] && map[nX][nY] == 0) {
                        map[nX][nY] = 1;
                        q.add(new Pair(nX, nY));
                    }
                }
            }
        }
    }

    static int  getSafeArea(int[][] map) {
        int cnt = 0;

        Visited2 = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    bfs(new Pair(i, j), map);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0)
                    cnt++;
            }
        }

        return cnt;
    }

    static int[][] copyArr() {
        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = Map[i][j];
            }
        }

        for (int i = 0; i < 3; i++) {
            Pair p = zeros.get(Pos[i]);
            map[p.x][p.y] = 1;
        }
        return map;
    }

    static void findComb(int start, int seq) {

        if (seq == 3) {
            int[][] copyMap = copyArr();
            Result = Math.max(Result, getSafeArea(copyMap));
            return ;
        }

        for (int i = start; i < zeros.size(); i++) {
            if (!Visited[i]) {
                Visited[i] = true;
                Pos[seq] = i;
                findComb(i + 1, seq + 1);
                Visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());

        Map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Map[i][j] = Integer.valueOf(st.nextToken());
                if (Map[i][j] == 0)
                    zeros.add(new Pair(i, j));
            }
        }
        Visited = new boolean[zeros.size()];
        findComb(0, 0);
        System.out.println(Result);
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
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
