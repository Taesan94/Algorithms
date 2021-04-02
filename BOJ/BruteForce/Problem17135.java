package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Problem17135 {

    static int N, M, D, EnemyCnt = 0 , Cnt = 0, Result = 0;
    static int[][] Map;

    static void check_possible(int i, int j, boolean[] positions) {

        for (int k = 0; k < M; k++) {
            int distance = Math.abs(N - i) + Math.abs(k - j);
            if (distance <= D) {
                if (!positions[k]) {
                    // System.out.printf("[%d, %d] ==> archor [ %d ] kill\n", i , j, k);
                    positions[k] = true;
                    Result++;
                    Map[i][j] = 0;
                    break;
                }
            } else {
                break;
            }
        }
    }

    static void kill_enemy(boolean[] positions) {

        // D거리안의 적들을 모두 죽인다.
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < M; j++) {
                if (Map[i][j] == 1) {
                    check_possible(i, j, positions);
                }
            }
        }
    }

    static void down_enemy() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (Map[i][j] == 1) {
                    Map[i][j] = 0;
                    if (i + 1 < N) {
                        Map[i + 1][j] = 1;
                    }
                }
            }
        }
    }

    static void print() {
        System.out.println("#########");
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(Map[i]));
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        D = Integer.valueOf(st.nextToken());

        Map = new int[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Map[i][j] = Integer.valueOf(st.nextToken());
                if (Map[i][j] == 1)
                    EnemyCnt++;
            }
        }


        System.out.println(Cnt);
    }

    static void temp(int seq, boolean[] positions) {

        if (seq == 3) {
            kill_enemy(positions);
            down_enemy();
            return ;
        }

        for (int i = 0; i < M; i++) {
            if (!positions[i]) {
                positions[i] = true;
                temp(seq + 1, positions);
                positions[i] = false;
            }
        }


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
