package BOJ.TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem1484 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.valueOf(br.readLine());

        double l = 1;
        double r = 2;
        boolean visited = false;

        StringBuilder sb = new StringBuilder("");
        while (l != r) {
            double w = Math.pow(r, 2) - Math.pow(l, 2);

            if (w < G) {
                r++;
            } else if (w > G) {
                l++;
            } else if (w == G) {
                visited = true;
                sb.append((long)r).append("\n");
                l++;
                r++;
            }
        }
        if (!visited)
            System.out.println(-1);
        else
            System.out.print(sb.toString());
    }
}
