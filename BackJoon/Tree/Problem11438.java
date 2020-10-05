package Programmers.BackJoon.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Problem11438 {

	static int MAX = 17;
	static int[] depth;
	static int[][] parents;
	static List<List<Integer>> tree = new ArrayList<>();
	static int N, M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());
		
		 depth = new int[N + 1];
		 parents = new int[N + 1][MAX + 1];

		init();

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.valueOf(st.nextToken());
			int v2 = Integer.valueOf(st.nextToken());

			tree.get(v1).add(v2);
			tree.get(v2).add(v1);
		}
		
		dfs(1);
		
		for (int j = 0; j <= MAX; j++) {
			for (int i = 1; i <= N; i++) {
				if(parents[i][j] != -1) {
					parents[i][j + 1] = parents[parents[i][j]][j];
				}
			}
		}
		
		M = Integer.valueOf(br.readLine());

		for (int i = 0; i < M; i++) {
			findSameParent(br.readLine());
		}
	}

	static void init() {

		for (int i = 0; i <= N; i++) {
			tree.add(new ArrayList<>());
		}

		Arrays.fill(depth, -1);
		depth[1] = 0;

		for (int[] parent : parents) {
			Arrays.fill(parent, -1);
		}
	}


	static void dfs(int parent) {

		List<Integer> childs = tree.get(parent);

		for (int child : childs) {
			if (depth[child] == -1) {
				depth[child] = depth[parent] + 1;
				parents[child][0] = parent;
				dfs(child);
			}
		}
	}

	static void findSameParent(String input) {

		StringTokenizer st = new StringTokenizer(input);

		int low = Integer.valueOf(st.nextToken());
		int high = Integer.valueOf(st.nextToken());
		
		if (depth[low] < depth[high]) {
			int temp = high;
			high = low;
			low = temp;
		}
		
		int hDiff = depth[low] - depth[high];

		int i = 0;

		while (hDiff != 0) {
			if (hDiff % 2 != 0) {
				low = parents[low][i];
			}
			hDiff /= 2;
			i++;
		}
		
		if (low != high) {
			for (int j = MAX; j >= 0; j--) {
				if (parents[low][j] != -1 && parents[low][j] != parents[high][j]) {
					low = parents[low][j];
					high = parents[high][j];
				}
			}
			low = parents[low][0];
		}
		System.out.println(low);
	}

}
