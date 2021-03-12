package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/*
    시간초과 나는 코드임...
 */
public class Problem9663_retry {

    static int N, Result = 0;
    static int[][] Map;
    static boolean[][] Visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.valueOf(br.readLine());
        Map = new int[N][N];
        Visited = new boolean[N][N];

        solution(0, 0);
        System.out.println(Result);

    }

    static boolean isPossible(int i, int j) {
        int x, y;

        x = i;
        y = j - 1;
        // left
        while (y >= 0) {
            if (Visited[x][y--])
                return false;
        }

        x = i - 1;
        y = j;
        // up
        while (x >= 0) {
            if (Visited[x--][y])
                return false;
        }

        // left up
        x = i - 1;
        y = j - 1;
        while (x >= 0 && y >= 0) {
            if (Visited[x--][y--])
                return false;
        }
        // right up
        x = i - 1;
        y = j + 1;
        while (x >= 0 && y < N) {
            if (Visited[x--][y++])
                return false;
        }
        return true;
    }

    static void print() {
        System.out.println("######## print #########");
        for (boolean[] b : Visited) {
            System.out.println(Arrays.toString(b));
        }
    }

    static void solution(int value, int cnt) {

        if (cnt == N) {
            // print();
            Result++;
            return ;
        }

        int x = value / N;
        int y = value % N;
        // System.out.printf("x : %d, y : %d\n", x, y);


        for (int i = x; i < N; i++) {
            while (y < N) {
                if (isPossible(i, y)) {
                    Visited[i][y] = true;
                    // System.out.printf("[%d][%d] : put ... next : %d\n", i, j, i + j + 1);
                    solution(i * N + y + 1, cnt + 1);
                    Visited[i][y] = false;
                }
                y++;
            }
            y = 0;
        }
    }


    // 이게 정상적인 코드
    static int answer = 0;
    static int n;
    static int[] row;

    public static void main2(String[] args) {

        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        row = new int[n];

        // 0행 n열에 퀸을 놓았을 때, 만들 수 있는 모든 경우의 수를 센다.
        for (int i = 0; i < n; i++) {
            // 0행 i열에 퀸 배치
            row[0] = i;
            // 다음 행부터 놓을 수 있는 열에 퀸을 놓아간다.
            dfs(1);
        }
        System.out.println(answer);
    }

    private static void dfs(int r) {

        if (r == n) {
            answer++;
            return ;
        }

        // 퀸을 놓을 수 있는 열을 찾는다.
        for( int i = 0; i < n; i++) {
            row[r] = i;
            // 놓을 수 있다면, 다음행에 퀸을 채우러 간다.
            if(isPossible(r))
                dfs(r + 1);
            else
                row[r] = 0;
        }
    }
    // 해당 행에 놓을 수 있는 퀸을 찾는다.
    private static boolean isPossible(int r) {

        for (int i = 0; i < r; i++) {
            // 같은 열에 퀸이 존재해서는 안된다. 한 행씩 채워나가고 있기 때문에 행의 중복은 발생하지 않는다.
            if (row[i] == row[r])
                return false;
            // 현재 행 이전의 체스들이 대각선에(V)에 존재해서는 안된다.
            if (Math.abs(row[i] - row[r]) == Math.abs(i - r))
                return false;
        }
        return true;
    }

}
