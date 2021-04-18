package Programmers;

import java.util.*;

/*
 OOM문제 발생. 채점시 Test Case 7, 8 번에러.

 dfs2, 3은 같은코드인데 2는 맞고 3은틀림 -> 채점서버문제 같음.
 dfs1은 최초
      static void dfs(int p, int v, boolean[] visited);
  으로 정의 함.
  인자값에 visited가 포함되있어서 oom에서 잡히는것 같음.

  visited를 전역변수로 변경 -> 그래도 8번 런타임에러.
  visited를 static으로 변경 -> 성공
 */

public class AllZeroMake {

    public static void main(String[] args) {

        int[] a = {100, -25, -25, -25, -25};

        int[][] edges = {
                {0, 1}, {3, 4}, {2, 3}, {0, 3}
        };

        System.out.println("Result : " + solution(a, edges));

        Result = 0;
        int[] b = {-1000, 1000};
        int[][] edges2 = {
                {0,1}
        };
        System.out.println("Result : " + solution(b, edges2));

        Result = 0;
        int[] c = {3, -103, 100};
        int[][] edges3 = {
                {0, 1}, {1, 2}
        };
        System.out.println("Result : " + solution(c, edges3));


        Result = 0;
        int[] d = {1,2,3,4,5,6,-6,-5,-4,-3,-2,-1};
        int[][] edges4 = {
                {0, 1}, {1, 2}, {2,3}, {3,4} , {4,5}, {5,6}, {6,7}, {7,8}, {8,9},{9,10}, {10,11}
        };
        System.out.println("Result : " + solution(d, edges4));
    }

    static List<Integer>[] list;
    static double Result = 0;
    static long[] long_a;

    static long dfs2(long[] a, int now, int par){
        long res = 0;
        for(int i=0; i < list[now].size(); i++){
            int next=list[now].get(i);
            if(next != par){
                res += dfs2(a, next, now);
            }
        }
        a[par] += a[now];
        return res + Math.abs(a[now]);
    }

    static void dfs(int p, int v, boolean[] visited) {

        if (visited[v])
            return ;
        visited[v] = true;

        for (int adj : list[v]) {
            if (!visited[adj]) {
                dfs(v, adj, visited);
            }
        }
        long_a[p] += long_a[v];
        Result += Math.abs(long_a[v]);
    }

    public static long solution(int[] a, int[][] edges) {

        list = new List[a.length];
        long_a = new long[a.length];

        for (int i = 0; i < a.length; i++) {
            list[i] = new ArrayList<>();
            long_a[i] = a[i];
        }

        for (int[] edge : edges) {
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[a.length];

        long[] a2 = new long[a.length];
        for (int i = 0; i < a.length; i++)
            a2[i] = long_a[i];
        dfs(0, 0, visited);

        long r2 = dfs2(a2,0, 0);
        System.out.println("dfs2 : " + r2);
        return (long)Result;
    }
}
