package Programmers.BackJoon.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 *  Lowest Common Ancestor 알고리즘
 *  부모 조상 알고리즘.
 *  두 정점의 공통부모중 가장 가까운 정점을 찾는다.
 * 
 */
public class Problem11437_LCA1 {

	// idx의 부모는 value 이다.
	static int[] parents;
	static List<List<Integer>> tree = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());

		// root 는 1이다.
		for (int i = 0; i <= n; i++) {
			tree.add(new ArrayList<>());
		}
		
		parents = new int[n + 1];

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.valueOf(st.nextToken());
			int v2 = Integer.valueOf(st.nextToken());

			tree.get(v1).add(v2);
			tree.get(v2).add(v1);
		}

		// root노드를 알아야 한다. root부터 부모노드를 기록해나간다.
		setParents(n);
		
		int m = Integer.valueOf(br.readLine());

		for (int i = 0; i < m; i++) {
			findSameParent(br.readLine());
		}
	}

	static void setParents(int n) {

		boolean[] visited = new boolean[n + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(1);

		while(!q.isEmpty()) {

			int parent = q.poll();

			if (visited[parent])
				continue;

			visited[parent] = true;

			List<Integer> childs = tree.get(parent);

			for (int i = 0; i < childs.size(); i++) {
				int child = childs.get(i);
				if (!visited[child]) {
					parents[child] = parent;
					q.add(child);
				}
			}
		}
	}
	
	static void findSameParent(String input) {
		
		StringTokenizer st = new StringTokenizer(input);

		int v1 = Integer.valueOf(st.nextToken());
		int v2 = Integer.valueOf(st.nextToken());

		int d1 = getDepth(v1);
		int d2 = getDepth(v2);

		// 두 정점중에서 깊이가 더 깊은 정점을 구분한다. v2(d2)에 더 깊은 정점을 보관한다.
		if (d2 < d1) { // d2가 더 낮다면, 즉 더 위에있다면
			int temp = v1; // v1과 v2를 swap한다.
			v1 = v2;
			v2 = temp;
			temp = d1; // 역시 v1의 d와 v2의 depth도 같이 swap한다.
			d1 = d2;
			d2 = temp;
		}
		
		// 동일한 부모를 만날때까지
		while (v1 != v2) {
			// 두 정점의 깊이가 같아졌다면, 같이바꾸고
			if (d1 == d2) {
				v1 = parents[v1];
				v2 = parents[v2];
			} else { // 그렇지 않다면, 더 낮은 곶에있는 v2(d2)를 한칸씩 높여간다.
				v2 = parents[v2];
				d2--;
			}
		}
		System.out.println(v1);
	}
	
	static int getDepth(int v) {

		int depth = 0;

		// root의 부모는 초기 값인 0이다.
		// 현재 노드부터 root까지의 거리를 구한다.
		while (parents[v] != 0) {
			depth++;
			v = parents[v];
		}
		return depth;
	}
}
