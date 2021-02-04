package BOJ.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2458 {

	static int N, M;
	static List<Integer>[] smaller; // idx보다 작은(위에 있는) 노드 기록
	static List<Integer>[] bigger; // idx보다 큰(아래에 있는) 노드 기록
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());

		smaller = new List[N + 1];
		bigger = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			smaller[i] = new ArrayList<>();
			bigger[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			smaller[b].add(a);
			bigger[a].add(b);
		}
		
		int result = 0;
		// 1~ N까지 가버린다.
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			dfs(i, smaller);
			checkChilds(i);
			// System.out.println(i +" ==> " + Arrays.toString(visited));
			if (isPossible()) {
				// System.out.println("possible : " + i);
				result++;
			}
		}
		// printGraph();
		System.out.println(result);
	}
	
	static void checkChilds(int v) {
		List<Integer> childs = bigger[v];
		for (int i = 0; i < childs.size(); i++) {
			dfs(childs.get(i), bigger);
		}
	}
	
	static boolean isPossible() {
		for (int i = 1; i <= N; i++) {
			if (!visited[i])
				return false;
		}
		return true;
	}
	
	static void dfs(int v, List<Integer>[] data) {
		
		if (visited[v])
			return ;
		visited[v] = true;
		
		List<Integer> parents = data[v];
		for (int i = 0; i < parents.size(); i++) {
			dfs(parents.get(i), data);
		}
		return ;
	}
	
	static void printGraph() {
		for (int i = 1; i <= N; i++)
			System.out.println(smaller[i].toString());
	}

}
