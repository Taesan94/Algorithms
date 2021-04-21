package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem9207 {

    static int N, ROW = 5, COL = 9;

    static int[] X = {0 ,0, 1, -1};
    static int[] Y = {1, -1, 0, 0};

    static int Pin, Move;

    static void print(int[][] map) {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.printf("%c",map[i][j]);
            }
            System.out.println();
        }

    }

    static void find(int[][] map, int move, int pin) {

        if (pin == Pin)
            Move = Math.min(Move, move);
        if (pin < Pin) {
            Pin = pin;
            Move = move;
        }
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {

                if (map[i][j] == 'o') {
                    for (int k = 0; k < 4; k++) {

                        int nX = i + X[k] * 2;
                        int nY = j + Y[k] * 2;

                        if (nX >= 0 && nX < ROW && nY >= 0 && nY < COL) {

                            if (map[nX][nY] == '.' && map[i + X[k]][j + Y[k]] == 'o') {
                                // visit
                                map[i][j] = '.';
                                map[i + X[k]][j + Y[k]] = '.';
                                map[nX][nY] = 'o';
                                find(map, move + 1, pin - 1);
                                // back
                                map[i][j] = 'o';
                                map[i + X[k]][j + Y[k]] = 'o';
                                map[nX][nY] = '.';
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < N; i++) {
            String s = "";

            int[][] map = new int[ROW][COL];
            int pin = 0;
            for (int j = 0; j < ROW; j++) {
                s = br.readLine();
                for (int k = 0; k < COL; k++) {
                    map[j][k] = s.charAt(k);
                    if (map[j][k] == 'o')
                        pin++;
                }
            }
            Pin = pin;
            Move = 0;
            find(map, 0, pin);
            sb.append(Pin).append(' ').append(Move);
            if (i != N - 1) {
                br.readLine();
                sb.append('\n');
            }
        }
        System.out.print(sb.toString());
    }
}
