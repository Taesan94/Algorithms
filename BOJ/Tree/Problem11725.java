package BOJ.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem11725 {

	static boolean[] visited ;
	static int[] parents ;
	static List<Integer>[] tree;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		tree = new List[n + 1];
		parents = new int[n + 1];
		visited = new boolean[n + 1];
		
		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int v1 = Integer.valueOf(st.nextToken());
			int v2 = Integer.valueOf(st.nextToken());
			
			tree[v1].add(v2);
			tree[v2].add(v1);
		}
		
		
		dfs(1);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 2; i<=n; i++) {
			sb.append(parents[i]).append('\n');
		}
		System.out.println(sb);
	}
	
	static void bfs(int start) {
		
		Queue<Integer> q = new LinkedList<>();
		q.add(start);

		while(!q.isEmpty()) {
			int v = q.poll();
			
			if (visited[v]) {
				continue;
			}
			
			visited[v] = true;
			List<Integer> childs = tree[v];
			
			for (int i = 0; i < childs.size(); i++) {
				int c = childs.get(i);
				if (!visited[c]) {
					parents[c] = v;
					q.add(c);
				}
			}
		}
	}
	
	static void dfs(int v) {
		
		
		List<Integer> child = tree[v];
		
		for (int i = 0; i < child.size(); i++) {
			int next = child.get(i);
			
			if (parents[v] == next)
				continue;
			parents[next] = v;
			dfs(next);
		}
	}

}
