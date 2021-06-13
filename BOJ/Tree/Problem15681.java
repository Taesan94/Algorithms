package BOJ.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Problem15681 {

    static int N, R, Q;
    static List<Integer>[] Graph, Tree;
    static int[] Size;

    // 서브트리 갯수 세기
    static void count_subtree(int node) {
        Size[node] = 1;

        for (int adj : Tree[node]) {
            count_subtree(adj);
            Size[node] += Size[adj];
        }
    }

    // 트리 구성하기.
    static void make_tree(int node, int p) {

        for (int adj : Graph[node]) {
            // 부모와 연결 된 노드는 제외 시킴.
            if (adj != p) {
                Tree[node].add(adj);
                make_tree(adj, node);
            }
        }

    }

    static void set_input(BufferedReader br) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        R = Integer.valueOf(st.nextToken());
        Q = Integer.valueOf(st.nextToken());

        Graph = new List[N + 1];
        Tree = new List[N + 1];
        Size = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            Tree[i] = new ArrayList<>();
            Graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.valueOf(st.nextToken());
            int v = Integer.valueOf(st.nextToken());

            Graph[u].add(v);
            Graph[v].add(u);
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer   sb = new StringBuffer("");

        // 1. 입력 및 양방향 그래프 생성.
        set_input(br);
        // 2. 트리 만들기
        make_tree(R, -1);
        // 3. 서브 트리 갯수 세기
        count_subtree(R);

        System.out.println(Arrays.toString(Size));

        for (int i = 0; i < Q; i++) {
           sb.append(Size[Integer.valueOf(br.readLine())]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
