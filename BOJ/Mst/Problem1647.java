package BOJ.Mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1647 {

    static int[] parents;

    static int getParent(int v) {
        int p = parents[v];

        if (p != v)
            return getParent(p);
        return p;
    }

    static void union(int v1, int v2) {
        int p1 = getParent(v1);
        int p2 = getParent(v2);

        int min = p1 < p2 ? p1 : p2;
        int max = p1 > p2 ? p1 : p2;

        parents[max] = min;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        PriorityQueue<Vertex> pq = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.valueOf(st.nextToken());
            int v2 = Integer.valueOf(st.nextToken());
            int v3 = Integer.valueOf(st.nextToken());

            pq.add(new Vertex(v1, v2, v3));
        }

        int answer = 0;
        int last = 0;
        while (!pq.isEmpty()) {
            Vertex curr = pq.poll();

            // 작은 노드번호를 부모로, 연결시키는 과정.
            if (getParent(curr.from) != getParent(curr.to)) {
                last = curr.value;
                answer += curr.value;
                // System.out.printf("%d <-> %d => cost : %d\n",getParent(curr.from), getParent(curr.to), curr.value);
                union(curr.from, curr.to);
                // System.out.println(Arrays.toString(parents));
            }
        }
        // System.out.printf("3의 부모 : %d , 2의 부모 : %d\n", getParent(3), getParent(2));
        System.out.println(answer - last);
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
