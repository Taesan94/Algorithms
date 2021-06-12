package BOJ.GraphTheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1068 {

    static int N, Rm, Root, Result = 0;
    static List<Integer>[] Graph;
    static boolean[] Visited;

    static void dfs(int v) {
        if (Visited[v])
            return ;
        Visited[v] = true;

        List<Integer> adjs = Graph[v];

        if (adjs.isEmpty()) {
            // System.out.println("v : " + v);
            Result++;
            return ;
        }

        for (int adj : adjs) {
            if (!Visited[adj])
                dfs(adj);
        }
    }


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Rm = Integer.valueOf(br.readLine());
        Graph = new List[N];

        for (int i = 0; i < N; i++) {
            Graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            int parent = Integer.valueOf(st.nextToken());
            if (parent == -1) {
                Root = i;
            }
            else if (parent != Rm && i != Rm)
                Graph[parent].add(i);
        }

//        for (List<Integer> list : Graph)
//            System.out.println(list.toString());

        if (Rm == Root)
            System.out.println(0);
        else {
            Visited = new boolean[N];

            dfs(Root);
            System.out.println(Result);
        }
    }
}
