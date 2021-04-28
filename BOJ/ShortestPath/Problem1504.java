package BOJ.ShortestPath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1504 {

    static int N, E;
    static int INF = 200000001;
    static List<Vertex>[] Graph;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        E = Integer.valueOf(st.nextToken());

        Graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            Graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.valueOf(st.nextToken());
            int v2 = Integer.valueOf(st.nextToken());
            int value = Integer.valueOf(st.nextToken());

            Graph[v1].add(new Vertex(v2, value));
            Graph[v2].add(new Vertex(v1, value));
        }

        st = new StringTokenizer(br.readLine());

        int pass1 = Integer.valueOf(st.nextToken());
        int pass2 = Integer.valueOf(st.nextToken());

        int r1 = dijkstra(1, pass1) + dijkstra(pass1, pass2) + dijkstra(pass2, N);
        int r2 = dijkstra(1, pass2) + dijkstra(pass2, pass1) + dijkstra(pass1, N);

        int result = Math.min(r1, r2);

        if (result == INF)
            result = -1;

        System.out.println(result);
    }

    static int dijkstra(int start, int end) {

        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.add(new Vertex(start, 0));
        int[] distance = new int[N + 1];
        for (int i = 1; i <= N; i++)
            distance[i] = INF;
        distance[start] = 0;

        boolean[] visited = new boolean[N + 1];

        while (!pq.isEmpty()) {

            Vertex curr = pq.poll();

            if (visited[curr.num])
                continue;
            visited[curr.num] = true;

            List<Vertex> adjs = Graph[curr.num];
            for (Vertex adj : adjs) {
                if (!visited[adj.num]) {
                    distance[adj.num] = Math.min(distance[curr.num] + adj.value, distance[adj.num]);
                    pq.add(new Vertex(adj.num, distance[adj.num]));
                }
             }
        }
        return distance[end];
    }

    static class Vertex implements Comparable<Vertex> {
        int num;
        int value;

        public Vertex(int num, int value) {
            this.num = num;
            this.value = value;
        }

        public int compareTo(Vertex o) {
            return this.value - o.value;
        }
    }
}
