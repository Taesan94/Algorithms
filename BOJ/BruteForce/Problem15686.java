package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Problem15686 {

    static int N, M;
    static List<Pair> houses = new ArrayList<>();
    static List<Pair> chickens = new ArrayList<>();
    static boolean[] visited;
    static int[] Pos;
    static int Min = Integer.MAX_VALUE;

    static int calc(Pair p1, Pair p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    static int getDistance() {

        // 집에서 가까운 치킨거리 찾고, 더해주기
        int sum = 0;
        for (int i = 0; i < houses.size(); i++) {
            Pair house = houses.get(i);
            int min = Integer.MAX_VALUE;
                for (int j = 0; j < M; j++) {
                    Pair chicken = chickens.get(Pos[j]);
                    min = Math.min(min, calc(house, chicken));
            }
            sum += min;
        }
        return sum;
    }

    static void getCombination(int start, int seq) {
       // System.out.println("start : " + start);

        if (seq == M) {
            // System.out.println(Arrays.toString(Pos));
            // System.out.println(Arrays.toString(Pos));
            Min = Math.min(Min, getDistance());
            return ;
        }

        for (int i = start; i < chickens.size(); i++) {
            if (!visited[i]) {
                Pos[seq] = i;
                visited[i] = true;
                getCombination(i + 1, seq + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        Pos = new int[M];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int v = Integer.valueOf(st.nextToken());
                    if (v == 1)
                        houses.add(new Pair(i, j));
                    else if (v == 2)
                        chickens.add(new Pair(i, j));
            }
        }
        visited = new boolean[chickens.size()];
        // 치킨 집의 m개 조합을 찾기.
        getCombination(0, 0);
        System.out.println(Min);

    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
