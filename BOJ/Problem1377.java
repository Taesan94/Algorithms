package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1377 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<Pair> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(new Pair(i, Integer.valueOf(br.readLine())));
        }

        Collections.sort(list);

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, list.get(i).idx - i);
        }
        result++;
        System.out.println(result);
    }

    // 최초, quick sort직접 구현했는데 3%에서 실패함.
    // stable 하지 않은 정렬이라, stable하게 처리되도록 변경
    static class Pair implements Comparable<Pair> {

        int idx; // 최초 index가 저장 됨.
        int num;

        public Pair(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }

        public int compareTo(Pair o) {
            int result = this.num - o.num;
            if (result == 0)
                result = this.idx - o.idx;
            return result;
        }
    }
}
