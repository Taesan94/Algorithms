package BOJ.Mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1197 {

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

        int min = (p1 < p2) ? p1 : p2;
        int max = (p1 > p2) ? p1 : p2;

        // idx의 부모는 value이다. 가장 최상위 부모로 변경.
        parents[max] = getParent(min);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.valueOf(st.nextToken());
        int e = Integer.valueOf(st.nextToken());

        parents = new int[v + 1];

        for (int i = 1; i <= v; i++)
            parents[i] = i;

        PriorityQueue<Vertex> pq = new PriorityQueue<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.valueOf(st.nextToken());
            int v2 = Integer.valueOf(st.nextToken());
            int v3 = Integer.valueOf(st.nextToken());
            pq.add(new Vertex(v1, v2, v3));
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            Vertex curr = pq.poll();

            if (getParent(curr.from) != getParent(curr.to)) {
                answer += curr.value;
                union(curr.from, curr.to);
            }
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
