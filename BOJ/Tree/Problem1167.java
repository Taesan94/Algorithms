package BOJ.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1167 {

    static int V;
    static int max = 0, maxIdx = 1;
    static List<Vertex>[] Tree;
    static boolean[] visited;

    static void dfs(int v, int distance) {

        if (distance > max) {
            max = distance;
            maxIdx = v;
        }

        if (visited[v])
            return ;
        visited[v] = true;

        for (Vertex adj : Tree[v]) {
            if (!visited[adj.v])
                dfs(adj.v, distance + adj.w);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        V = Integer.valueOf(br.readLine());
        Tree = new List[V + 1];

        for (int i = 1; i <= V; i++)
            Tree[i] = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int curr = Integer.valueOf(st.nextToken());

            while (true) {
                int adj = Integer.valueOf(st.nextToken());
                if (adj == -1)
                    break ;
                int w = Integer.valueOf(st.nextToken());
                // System.out.printf("curr : %d, adj : %d, w : %d\n", curr, adj, w);
                Tree[curr].add(new Vertex(adj, w));
                Tree[adj].add(new Vertex(curr, w));
            }
        }

        visited = new boolean[V + 1];
        dfs(1, 0);

        visited = new boolean[V + 1];
        max = 0;
        dfs(maxIdx, 0);
        System.out.println(max);
    }

    static class Vertex {
        int v;
        int w;

        public Vertex(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
