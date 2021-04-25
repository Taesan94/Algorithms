package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2091 {

    static int X;
    static int[] Values = {1, 5, 10, 25};
    static int[] Cnts = new int[4];
    static int[] Result = new int[4];

    static boolean find(int sum, int curr) {

        if (sum == X) {
            return true;
        } else if (sum < X) {
            Result[curr]--;
            find(sum - Values[curr], curr);

        }
        return false;
    }


    static void print() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 4; i++) {
            sb.append(Result[i]);
            if (i != 3)
                sb.append(" ");
        }
        System.out.println(sb.toString());
        return ;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.valueOf(st.nextToken());

        for (int i = 0; i < 4; i++)
            Cnts[i] = Integer.valueOf(st.nextToken());

        if (Cnts[0] > 0 && Cnts[0] >= X) {
            Result = new int[]{X, 0, 0, 0};
        } else {
            //

        }

        print();




    }
}
