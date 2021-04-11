package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2666 {

    static int N, Cnt;
    static int[] Doors, Order;
    static int[] Open = new int[2];


    static void move_door(int seq, int sum) {

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.valueOf(br.readLine());
        Doors = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 1 = open;
        int o1 = Integer.valueOf(st.nextToken());
        int o2 = Integer.valueOf(st.nextToken());
        Open[0] = o1;
        Open[1] = o2;

        Cnt = Integer.valueOf(br.readLine());
        Order = new int[Cnt];

        for (int i = 0; i < Cnt; i++) {
            Order[i] = Integer.valueOf(br.readLine());
        }
        // Order의 문을 열 수 있는 모든 경우의 수를 보면 된다.
        for (int i = 0; i < Cnt; i++) {
            // i번째 문을열 때,
            // 왼쪽에서 열었을 때,
            // 오른쪽에서 열었을 때
        }
    }
}
