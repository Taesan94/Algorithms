package BOJ.GraphTheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem16236 {

    static int N, Result = Integer.MAX_VALUE;
    static int[][] Map;
    static Shark s;
    static int[] X = {0, 0, 1, -1};
    static int[] Y = {1, -1, 0, 0};

    static boolean move_possible(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < N)
            return true;
        return false;
    }

    static void bfs() {
        Queue<Shark> q = new LinkedList<>();
        q.add(s);

        while (!q.isEmpty()) {
            Shark curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nX = curr.x + X[i];
                int nY = curr.y + Y[i];

                if (move_possible(nX, nY)) {
                    if (Map[nX][nY] == 0 || Map[nX][nY] == curr.size)
                        q.add(new Shark(nX, nY, curr.size, curr.eat, curr.remain, curr.seq + 1));
                    if (Map[nX][nY] < curr.size) {

                    }
                }
            }



        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.valueOf(br.readLine());

        Map = new int[N][N];
        int fish = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Map[i][j] = Integer.valueOf(st.nextToken());
                if (Map[i][j] == 9)
                    s = new Shark(i, j);
                else if (Map[i][j] >= 1 && Map[i][j] <= 6)
                    fish++;
            }
        }
        s.remain = fish;
        s.seq = 0;
        if (fish == 0)
            Result = 0;

        bfs();

        System.out.println(Result);

        // 상어 기준으로, 가장 가까운 위치의 물고기로 이동. -> 먹을 수 있는 크기여야 함
        // 같은 거리라면 좌측상단 기준으로 먼저 처리.
        // 해당 루트를 이동할 수 있어야 함.

        // 탐색하다가, 물고기를 만났을 때




    }

    static class Shark {
        int x;
        int y;
        int size;
        int eat;
        int remain;
        int seq;

        public Shark(int x, int y) {
            this.x = x;
            this.y = y;
            this.size = 2;
        }

        public Shark(int x, int y, int size, int eat, int remain, int seq) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.eat = eat;
            this.remain = remain;
            this.seq = seq;
        }
    }
}
