package Programmers.BackJoon.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem11437 {

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

		setParents(n);
		
		int m = Integer.valueOf(br.readLine());

		for (int i = 0; i < m; i++) {
			findSameParent(br.readLine());
		}
	}

	static void setParents(int n) {

		boolean[] visited = new boolean[n + 1];
		// 1의 자식들 기록.
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

		if (d2 < d1) {
			int temp = v1;
			v1 = v2;
			v2 = temp;
			temp = d1;
			d1 = d2;
			d2 = temp;
		}

		while (v1 != v2) {
			if (d1 == d2) {
				v1 = parents[v1];
				v2 = parents[v2];
			} else {
				v2 = parents[v2];
				d2--;
			}
		}
		System.out.println(v1);
	}
	
	static int getDepth(int v) {

		int depth = 0;

		while (parents[v] != 0) {
			depth++;
			v = parents[v];
		}
		return depth;
	}
}
