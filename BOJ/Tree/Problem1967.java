package BOJ.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1967 {

    static int N, Max = 0, Max_N = 1;
    static List<Node>[] Tree;
    static boolean[] Visited;

    static void dfs(int v, int size) {

        if (size > Max) {
            Max = size;
            Max_N = v;
            // System.out.println("Node : " + Max_N +", Max : " + Max);
        }

        if (Visited[v])
            return ;
        Visited[v] = true;

        for (Node adj : Tree[v]) {
            if (!Visited[adj.child])
                dfs(adj.child, size + adj.v);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        Tree = new List[N + 1];
        Visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++)
            Tree[i] = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int parent = Integer.valueOf(st.nextToken());
            int child = Integer.valueOf(st.nextToken());
            int value = Integer.valueOf(st.nextToken());

            Tree[parent].add(new Node(child, value));
            Tree[child].add(new Node(parent, value));
        }
        dfs(1, 0);

        Visited = new boolean[N + 1];
        //System.out.println("==============[ "+ Max_N +" ]==============");

        dfs(Max_N, 0);

        System.out.println(Max);
    }

    static class Node {
        int child;
        int v;

        public Node(int child, int v) {
            this.child = child;
            this.v = v;
        }
    }
}
