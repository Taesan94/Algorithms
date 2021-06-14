package BOJ.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem4256 {

    static int N;
    static int[] PreOreder, InOrder;

    static void postorder(int s, int e, int root) {

        for (int i = s; i < e; i++) {
            if (PreOreder[root] == InOrder[i]) {
                postorder(s, i, root + 1); // 좌
                postorder(i + 1, e, root + i - s + 1); // 우
                System.out.print(PreOreder[root] + " "); // 중
            }
        }
    }
    static void set_input(BufferedReader br) throws Exception {

        N = Integer.valueOf(br.readLine());

        PreOreder = new int[N];
        InOrder = new int[N];

        StringTokenizer pre_input = new StringTokenizer(br.readLine());
        StringTokenizer in_input = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            PreOreder[i] = Integer.valueOf(pre_input.nextToken());
            InOrder[i] = Integer.valueOf(in_input.nextToken());
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.valueOf(br.readLine());

        for (int i = 0; i < tc; i++) {
            set_input(br);
            postorder(0, N, 0);
            System.out.println();
        }

    }
}
