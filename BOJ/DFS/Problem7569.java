package BOJ.DFS;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Problem7569 {

    static int M, N, H;
    static int[][][] Box;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.valueOf(st.nextToken());
        N = Integer.valueOf(st.nextToken());
        H = Integer.valueOf(st.nextToken());

        //  높이, 가로, 세로
        Box = new int[H + 1][N + 1][M + 1];

        Queue<Pair> q = new LinkedList<>();
        int remain = 0;
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= M; k++) {
                    Box[i][j][k] = Integer.valueOf(st.nextToken());
                    if (Box[i][j][k] == 1)
                        q.add(new Pair(i, j, k, 0));
                    if (Box[i][j][k] == 0)
                        remain++;
                }
            }
        }

        if (remain == 0) {
            System.out.println(0);
            return ;
        }

        boolean[][][] visited = new boolean[H + 1][N + 1][M + 1];
        // System.out.println("remain : " + remain);

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            if (visited[curr.h][curr.x][curr.y])
                continue;
            visited[curr.h][curr.x][curr.y] = true;
            if (Box[curr.h][curr.x][curr.y] == 0) {
                remain--;
                Box[curr.h][curr.x][curr.y] = 1;
            }
            // System.out.println(curr.toString());


            if (remain == 0) {
                System.out.println(curr.seq);
                return ;
            }

            int up = curr.h - 1;
            int down = curr.h + 1;
            int front = curr.x + 1;
            int back = curr.x - 1;
            int r = curr.y + 1;
            int l = curr.y - 1;

            if (up > 0 && up <= H && Box[up][curr.x][curr.y] == 0) {
                q.add(new Pair(up, curr.x, curr.y, curr.seq + 1));
            }
            if (down > 0 && down <= H && Box[down][curr.x][curr.y] == 0) {
                q.add(new Pair(down, curr.x, curr.y, curr.seq + 1));
            }
            if (front > 0 && front <= N && Box[curr.h][front][curr.y] == 0) {
                q.add(new Pair(curr.h, front, curr.y, curr.seq + 1));
            }
            if (back > 0 && back <= N && Box[curr.h][back][curr.y] == 0) {
                q.add(new Pair(curr.h, back, curr.y, curr.seq + 1));
            }
            if (r > 0 && r <= M && Box[curr.h][curr.x][r] == 0) {
                q.add(new Pair(curr.h, curr.x, r, curr.seq + 1));
            }
            if (l > 0 && l <= M && Box[curr.h][curr.x][l] == 0) {
                q.add(new Pair(curr.h, curr.x, l, curr.seq + 1));
            }
        }
        System.out.println(-1);
    }

    static class Pair {
        int h;
        int x;
        int y;
        int seq;

        public Pair(int h, int x, int y, int seq) {
            this.h = h;
            this.x = x;
            this.y = y;
            this.seq = seq;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "h=" + h +
                    ", x=" + x +
                    ", y=" + y +
                    ", seq=" + seq +
                    '}';
        }
    }
}
