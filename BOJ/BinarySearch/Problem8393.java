package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Problem8393 {

    static int N, M, L, Max;

    static List<Pair> animals = new ArrayList<>();
    static int[] sends;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.valueOf(st.nextToken());
        N = Integer.valueOf(st.nextToken());
        L = Integer.valueOf(st.nextToken());

        sends = new int[M];
        Max = -1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            sends[i] = Integer.valueOf(st.nextToken());
        }

        Arrays.sort(sends);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(st.nextToken());
            int y = Integer.valueOf(st.nextToken());
            animals.add(new Pair(x, y));
        }

        Collections.sort(animals);

        // 동물을 기준으로, 가능한 사대의 개수를 센다.
        int result = 0;

        for (int i = 0; i < animals.size(); i++) {

            Pair animal = animals.get(i);

            int l = 0;
            int r = M - 1;
            while (l <= r) {
                // 해당 사대로 현재위치의 동물을 잡는 거리가 몇인지 찾는다.
                int mid = (l + r) / 2;
                int len = Math.abs(animal.x - sends[mid]) + animal.y;
                if (len <= L) {
                    result++;
                    break ;
                }
                if (animal.x < sends[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }
        System.out.println(result);
    }

    static class Pair implements Comparable<Pair> {

        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Pair o) {
            return this.x - o.x;
        }
    }

    
}
