package BOJ.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1761_LCA {

	static int MAX = 16; // 최대 깊이
	static int N, M;

	static List<Node>[] tree;
	static int[][] parents;
	static int[] depth;
	static int[] distance; // root에서 정점 n으로 가는데 걸리는 거리
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());

		distance = new int[N + 1];
		parents = new int[N + 1][MAX + 1];
		depth = new int[N + 1];
		tree = new List[N + 1];
		
		for (int i = 0; i <= N; i++) {
			tree[i] = new ArrayList<>();
			Arrays.fill(parents[i], -1);
			depth[i] = -1;
		}
		
		depth[1] = 0;
		
		StringTokenizer st;
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int v1 = Integer.valueOf(st.nextToken());
			int v2 = Integer.valueOf(st.nextToken());
			int value = Integer.valueOf(st.nextToken());
			
			tree[v1].add(new Node(v2, value));
			tree[v2].add(new Node(v1, value));
		}
		
		dfs(1, 0);
		fillParents();

		M = Integer.valueOf(br.readLine());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.valueOf(st.nextToken());
			int v2 = Integer.valueOf(st.nextToken());
			lca(v1, v2);
		}
	}
	
	static void fillParents() {
		
		for (int j = 0; j <= MAX; j++) {
			for (int i = 1; i <= N; i++) {
				if(parents[i][j] != -1) {
					parents[i][j + 1] = parents[parents[i][j]][j];
				}
			}
		}
		
	}
	
	static void lca(int v1, int v2) {
		
		int orgV1 = v1;
		int orgV2 = v2;
		
		if (depth[v1] < depth[v2]) {
			int temp = v1;
			v1 = v2;
			v2 = temp;
		}
		
		int hDiff = depth[v1] - depth[v2];
		
		int i = 0;
		while (hDiff != 0) {
			if (hDiff % 2 != 0) {
				v1 = parents[v1][i];
			}
			hDiff /= 2;
			i++;
		}
		
		int lcaV = v1;
		
		if (v1 != v2) {
			for (int j = MAX; j >= 0; j--) {
				if (parents[v1][j] != -1 && parents[v1][j] != parents[v2][j]) {
					v1 = parents[v1][j];
					v2 = parents[v2][j];
				}
			}
			lcaV = parents[v1][0];
		}
		System.out.println(distance[orgV1] + distance[orgV2] - distance[lcaV] * 2);
	}
	
	static void dfs(int parent, int working) {
		
		List<Node> childs = tree[parent];
		
		for (Node node : childs) {
			int child = node.child;
			if (depth[child] == -1) {
				depth[child] = depth[parent] + 1;
				parents[child][0] = parent;
				distance[child] = working + node.value;
				dfs(child, distance[child]);
			}
		}
	}
	
	static class Node {
		
		int child;
		int value;
		
		Node (int child, int value){
			this.child = child;
			this.value = value;
		}
	}

}
