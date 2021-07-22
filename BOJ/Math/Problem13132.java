package BOJ.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem13132 {

    static double money = 100;

    static double getRemainMoney(int percent) {
        return money - (money * (percent * 0.01));
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int b = Integer.valueOf(st.nextToken());


    }
}
