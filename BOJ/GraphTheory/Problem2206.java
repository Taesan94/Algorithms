package BOJ.GraphTheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem2206 {

    static int[] X = {0, 0, 1, -1};
    static int[] Y = {1, -1, 0, 0};
    static int[][] Map;
    static int N, M, Result = Integer.MAX_VALUE;

    static boolean move_possible(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < M) {
           return true;
        }
        return false;
    }

    static void bfs() {
        // q 에 넣고
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 1, 0));
        boolean[][][] visited  = new boolean[N][M][2];

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            if (visited[curr.x][curr.y][curr.breaked])
                continue;
            visited[curr.x][curr.y][curr.breaked] = true;

            if (curr.x == N - 1 && curr.y == M - 1) {
                Result = Math.min(curr.seq, Result);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nX = curr.x + X[i];
                int nY = curr.y + Y[i];

                if (move_possible(nX, nY)) {
                    if (Map[nX][nY] == 1) {
                        if (curr.breaked == 0)
                            q.add(new Pair(nX, nY,curr.seq + 1,1));
                    } else {
                        if (!visited[nX][nY][curr.breaked]) {
                            q.add(new Pair(nX, nY,curr.seq + 1, curr.breaked));
                        }
                    }
                }
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
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                Map[i][j] = s.charAt(j) - '0';
            }
        }
        bfs();
        if (Result == Integer.MAX_VALUE)
            Result = -1;
        System.out.println(Result);
    }

    static class Pair {
        int x;
        int y;
        int seq;
        int breaked;

        public Pair(int x, int y, int seq, int breaked) {
            this.x = x;
            this.y = y;
            this.seq = seq;
            this.breaked = breaked;
        }
    }

}
