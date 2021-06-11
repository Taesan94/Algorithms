package BOJ.GraphTheory;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem10026 {

    static int N;
    static char[][] Map;
    // 0 = R, 1 = G, 2 = B
    static int[] Color;
    static int[] X = {0, 0, 1, -1};
    static int[] Y = {1, -1, 0, 0};

    static boolean move_possible(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < N)
            return true;
        return false;
    }

    static void bfs(int x, int y, boolean[][] visited) {
        Queue<Pair> q = new LinkedList<>();

        char c = Map[x][y];

        if (c == 'R') {
            Color[0]++;
        } else if (c == 'G') {
            Color[1]++;
        } else {
            Color[2]++;
        }

        q.add(new Pair(x, y));
        while (!q.isEmpty()) {
            Pair curr = q.poll();

            if (visited[curr.x][curr.y])
                continue;
            visited[curr.x][curr.y] = true;
            for (int i = 0; i < 4; i++) {
                int nX = curr.x + X[i];
                int nY = curr.y + Y[i];

                if (move_possible(nX, nY)) {
                    if (Map[nX][nY] == c && !visited[nX][nY]) {
                        q.add(new Pair(nX, nY));
                    }
                }
            }
        }
    }

    static void  find() {
        Color = new int[3];
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, visited);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());

        Map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                Map[i][j] = s.charAt(j);
            }
        }

        find();
        int normal = Color[0] + Color[1] + Color[2];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Map[i][j] == 'G')
                    Map[i][j] = 'R';
                }
        }
        find();
        int un_normal = Color[0] + Color[2];
        System.out.println(normal + " " + un_normal);
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
