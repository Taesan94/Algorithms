package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2141 {

    static int N;

    static Village[] villages;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());

        villages = new Village[N];

        long total = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pos = Integer.valueOf(st.nextToken());
            int cnt = Integer.valueOf(st.nextToken());
            total += cnt;
            villages[i] = new Village(pos, cnt);
        }

        Arrays.sort(villages);

        long sum = 0;

        long limit = total / 2;
        if (total % 2 != 0)
            limit++;
        // 최소가 되려면, 집의 인원을 차례대로 더하다가, 전체 인원의 반 이상이 되는 순간이다.
        for (Village v : villages) {
            sum += v.cnt;
            /*
                (limit가 딱 반을 만들려면 홀,짝수일때 구분하기 때문에 3번식으로 가능)
                1. total / 2 안됨.
                2. (total / 2) + 1 안됨.
                3. (total + 1) / 2 됨.
            */
            if (sum >= limit) {
                System.out.println(v.pos);
                break;
            }
        }
    }

    static class Village implements Comparable<Village> {

        int pos;
        int cnt;

        public Village(int pos, int cnt) {
            this.pos = pos;
            this.cnt = cnt;
        }

        public int compareTo(Village o) {
            int result = this.pos - o.pos;
            if (result == 0)
                result = this.cnt - o.cnt;
            return result;
        }

        @Override
        public String toString() {
            return "Village{" +
                    "pos=" + pos +
                    ", cnt=" + cnt +
                    '}';
        }
    }
}
