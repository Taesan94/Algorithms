package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2116 {

    static int[][] dice;
    static int n;
    static int[][] info = {
            {},
        {0, 2, 4, 3, 5, 6}, // A
        {0, 5, 3, 6, 1, 4}, // B
        {0, 2, 4, 6, 1, 5},// C
        {0, 3, 5, 6, 1, 2}, // D
        {0, 4, 2, 6, 1, 3}, // E
        {0, 2, 4, 5, 3, 1} // F
    };

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        n = Integer.valueOf(br.readLine());
        dice = new int[n + 1][7];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 6; j++) {
                dice[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        // 첫번째 주사위를 기준으로 6면을 모두 확인.
        for (int i = 1; i <= 6; i++) {

            int sum = 0;
            int max = 0;

            // 1층 주사위 아래가 i일 때, 2층부터 n층까지 주사위 세우기.
            int[] result = new int[5];
            // System.out.println((char)((i - 1) + 'A') +"가 바닥일 때");

            for (int k = 1; k <= 4; k++) {
                max = Math.max(max, dice[1][info[i][k]]);
            }
            sum += max;
            int up = dice[1][info[i][5]];
            for (int j = 2; j <= n; j++) {

                int down = 0;
                for (int r = 1; r <= 6; r++) {
                    if (dice[j][r] == up) {
                        down = r;
                        break ;
                    }
                }
                // System.out.println("next : " + (char)((down - 1) + 'A') +"가 바닥일 때");
                // System.out.println("#2#" + (char)((down - 1) + 'A') +"가 바닥일 때");
                max = dice[j][info[down][1]];
                for (int k = 2; k <= 4; k++) {
                    max = Math.max(max, dice[j][info[down][k]]);
                }
                sum += max;
                up = dice[j][info[down][5]];
            }
            // result의 최대 값 찾기.
            answer = Math.max(sum, answer);
        }

        System.out.println(answer);
    }
}
