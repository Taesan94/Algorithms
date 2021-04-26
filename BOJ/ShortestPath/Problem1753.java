package BOJ.ShortestPath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1753 {

    static int INF = 200001;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.valueOf(st.nextToken());
        int e = Integer.valueOf(st.nextToken());
        int start = Integer.valueOf(br.readLine());

        List<Vertex>[] graph = new List[v + 1];

        for (int i = 1; i <= v; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.valueOf(st.nextToken());
            int to = Integer.valueOf(st.nextToken());
            int value = Integer.valueOf(st.nextToken());

            graph[from].add(new Vertex(to, value));
        }

        int[] distance = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            distance[i] = INF;
        }
        distance[start] = 0;

        PriorityQueue<Vertex> q = new PriorityQueue<>();

        q.add(new Vertex(start, 0));
        boolean[] visited = new boolean[v + 1];

        // 인접한, 정점을 방문..
        while (!q.isEmpty()) {
            int vertex = q.poll().to;

            if (visited[vertex])
                continue;
            visited[vertex] = true;

            List<Vertex> adj = graph[vertex];
            for (Vertex next : adj) {
                if (!visited[next.to]) {
                    distance[next.to] = Math.min(distance[vertex] + next.value, distance[next.to]);
                    q.add(new Vertex(next.to, distance[next.to]));
                }
            }
        }

        StringBuilder sb = new StringBuilder("");
        for (int i = 1; i <= v; i++) {
            if (distance[i] == INF)
                sb.append("INF");
            else
                sb.append(distance[i]);
            sb.append('\n');
        }
        System.out.print(sb.toString());


    }

    static class Vertex implements Comparable<Vertex> {

        int to;
        int value;

        public Vertex(int to, int value) {
            this.to = to;
            this.value = value;
        }

        public int compareTo(Vertex o) {
            return this.value - o.value;
        }
    }

}
