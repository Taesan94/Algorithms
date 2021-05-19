package BOJ.Mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 크루스칼 알고리즘
public class Problem1922 {

    static int[] parents;

    static int getParent(int v) {
        int p = parents[v];
        if (p != v)
            return getParent(p);
        return p;
    }

    static void union(int from, int to) {
        int p1 = getParent(from);
        int p2 = getParent(to);

        int small = p1 < p2 ? p1 : p2;
        int big = p1 > p2 ? p1 : p2;
        // big의 부모는 small이다.
        parents[big] = getParent(small);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        int m = Integer.valueOf(br.readLine());
        parents = new int[n + 1];
        int answer = 0;

        // init
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        PriorityQueue<Vertex> pq = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int v1 = Integer.valueOf(st.nextToken());
            int v2 = Integer.valueOf(st.nextToken());
            int v3 = Integer.valueOf(st.nextToken());
            pq.add(new Vertex(v1, v2, v3));
       }

        while (!pq.isEmpty()) {
            Vertex curr = pq.poll();

            // 부모가 다른경우, 작은 정점 기준으로 부모 갱신.
            if (getParent(curr.from) != getParent(curr.to)) {
                union(curr.from, curr.to);
                answer += curr.value;
            }
            // 부모가 같다면 ? 안봐도 됨.
        }
        System.out.println(answer);
    }

    static class Vertex implements Comparable<Vertex> {
        int from;
        int to;
        int value;

        public Vertex(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }

        public int compareTo(Vertex o) {
            return this.value - o.value;
        }
    }
}
