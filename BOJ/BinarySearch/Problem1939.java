package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1939 {

    static int N, M;
    static List<Pair>[] list;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        list = new List[N + 1];

        for (int i = 0; i <= N; i++){
            list[i] = new ArrayList<>();
        }

        int from, to, w;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            from = Integer.valueOf(st.nextToken());
            to = Integer.valueOf(st.nextToken());
            w = Integer.valueOf(st.nextToken());

            list[from].add(new Pair(from, to, w));
            list[to].add(new Pair(to, from, w));
        }

        st = new StringTokenizer(br.readLine());
        from = Integer.valueOf(st.nextToken());
        to = Integer.valueOf(st.nextToken());

        List<Pair> toEnd = list[to];
        Collections.sort(toEnd);

        int l = 0;
        int r = toEnd.get(0).w;

        int result = 0;

        while (l <= r) {

            int mid = (l + r) / 2;
            // System.out.println("mid : " + mid);

            if (isPossible(from, to, mid)) {
                // System.out.printf("left : %d, right : %d, mid : %d\n", l, r, mid);
                l = mid + 1;
                result = Math.max(result, mid);
            }
            else
                r = mid - 1;
        }
        System.out.println(result);
    }

    static boolean isPossible(int from, int to, int mid) {

        Queue<Integer> q = new LinkedList<>();
        q.add(from);
        boolean[] visited = new boolean[N + 1];

        while (!q.isEmpty()) {
            int v1 = q.poll();

            if (visited[v1])
                continue;
            visited[v1] = true;

            List<Pair> next = list[v1];
            for (int j = 0; j < next.size(); j++) {
                // mid보다 작은 수가 존재한다면, 해당 값은 정답이 될 수 없음.
                if (next.get(j).w < mid || visited[next.get(j).to])
                    continue;
                if (next.get(j).to == to)
                    return true;
                q.add(next.get(j).to);
            }
        }
        return false;
    }

    static class Pair implements Comparable<Pair> {
        int from;
        int to;
        int w;

        public Pair(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Pair o) {
            return o.w - this.w;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "from=" + from +
                    ", to=" + to +
                    ", w=" + w +
                    '}';
        }
    }

}
