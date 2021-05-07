package Programmers;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MoveRoot {

    static int MOD = 20170805;
    static int N, M, Ans = 0;

    // 우,
    static int[] X = {0, 1};
    static int[] Y = {1, 0};
    static int[][] CityMap;
    static boolean[][] Visited;

    static boolean isPossible(int x, int y) {
        if (x >= 0 && x < M && y >= 0 && y < N)
            return true;
        return false;
    }

    static void print() {
        for (boolean[] b : Visited) {
            for (int i = 0; i < b.length; i++) {
                if (b[i])
                    System.out.print("O");
                else
                    System.out.print("X");
            }
            System.out.println();
        }
    }


    static void backTracking(Pair curr) {

        if (curr.x == M - 1 && curr.y == N - 1) {
            Ans++;
            return;
        }

        for (int i = 0; i < 2; i++) {

            int nX = curr.x + X[i];
            int nY = curr.y + Y[i];

            if (isPossible(nX, nY)) {
                while (CityMap[nX][nY] == 2) {
                    nX += X[i];
                    nY += Y[i];
                    if (!isPossible(nX, nY) || Visited[nX][nY])
                        continue;
                }
                if (!Visited[nX][nY] && CityMap[nX][nY] == 0) {
                    Visited[curr.x][curr.y] = true;
                    // String newRoot = root + "[" + curr.x + ", " + curr.y + "] => ";
                    backTracking(new Pair(nX, nY));
                    Visited[curr.x][curr.y] = false;
                }
            }
        }

    }

    public static int solution(int m, int n, int[][] cityMap) {

        M = m;
        N = n;
        CityMap = cityMap;
        Visited = new boolean[m][n];
        // bfs를 통해, 이동 가능한 인접 도로로 이동한다.
        // 인접도로가 1이면 갈 수 없다.
        // 인접도로가 2면 현재 방향으로 한칸 더 이동해서 다시 체크한다.
        backTracking(new Pair(0, 0));
        return Ans % MOD;
    }

    public static void main(String[] args) {
        System.out.println("result : " + solution(3, 3, new int[][]{{0, 0, 0},{0, 0, 0},{0, 0, 0}}));
    }

    static class Pair {

        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "x : " + x + ", y : " + y;
        }
    }
}
