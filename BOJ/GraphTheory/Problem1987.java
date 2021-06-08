package BOJ.GraphTheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1987 {

    static int R, C, Result = 0;
    static int[][] Map;
    static int[] X = { 0, 0, 1, -1 };
    static int[] Y = { 1, -1, 0, 0 };
    static boolean[] Visited = new boolean[26];

    static void dfs(int x, int y, int seq) {

        Result = Math.max(Result, seq);

        for (int i = 0; i < 4; i++) {
            int nX = x + X[i];
            int nY = y + Y[i];

            if (nX >= 0 && nX < R && nY >= 0 && nY < C) {
                if (!Visited[Map[nX][nY]]) {
                    Visited[Map[nX][nY]] = true;
                    dfs(nX, nY, seq + 1);
                    Visited[Map[nX][nY]] = false;
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.valueOf(st.nextToken());
        C = Integer.valueOf(st.nextToken());

        Map = new int[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                Map[i][j] = s.charAt(j) - 'A';
            }
        }
        Visited[Map[0][0]] = true;
        dfs(0, 0, 1);
        System.out.println(Result);
    }

}
