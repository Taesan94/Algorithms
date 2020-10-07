package Programmers.BackJoon.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProblemTest {

	public static void main(String[] args) {

		int[][] edges = {
				{0, 1},{0, 2},{0, 3},{1, 4},{1, 5},{2, 6},{3, 7},{3, 8},
				{3, 9},{4, 10},{4, 11},{5, 12},{5, 13},{6, 14},{6, 15},{6, 16},
				{8, 17},{8, 18}
		};
		
		int[][] edges2 = {
				{0, 1},{0, 2},{1, 3},{1, 4},{2, 5},{2, 6},{2, 7},{3, 8},{3, 9},
				{3, 10},{4, 11},{4, 12},{4, 13}
		};
		
		int[][] edges3 = {
				{0, 1},{0, 2},{1, 3},{2, 4},{2, 5},{2, 6},{3,7},{3, 8},{3, 9}
		};

		solution(19, edges);
		//solution(14, edges2);
		//solution(10, edges3);


	}

	static List<Integer>[] tree;
	static int[][] childCnt;
	static boolean[] visited;
	static int MAX = 0;
	static int MIN = Integer.MAX_VALUE;
	
	static void solution(int n, int[][] edges) {

		tree = new List[n];
		childCnt = new int[10][n];
		visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			tree[i] = new ArrayList<>();
		}

		for(int[] e : edges) {
			tree[e[0]].add(e[1]);
			tree[e[1]].add(e[0]);
		}

		dfs(0, 0);
		
		for (int[] a : childCnt) {
			System.out.println(Arrays.toString(a));
		}
		visited = new boolean[n];
		getNodeCnt(0, 1, childCnt[0][0] - 1);

		System.out.println("depth : " + MAX);
		System.out.println(" MIN : " + MIN);
	}
	
	static void getNodeCnt(int v, int depth, int cnt) {
		visited[depth] = true;
		List<Integer> childs = tree[v];
		
		for (int child : childs) {
			if (childCnt[depth][child] > 1) {
				if (!visited[child]) {
					System.out.printf("childCnt[%d][%d] : %d\n",depth, child, childCnt[depth][child]);
					getNodeCnt(child, depth + 1, childCnt[depth][child]);
				}
			} else {
				MIN = Math.min(MIN, cnt);
				System.out.println("here : " + cnt);
			}
		}
	}

	static void dfs(int parent, int depth) {

			visited[parent] = true;
			List<Integer> childs = tree[parent];
			boolean isLeaf = true;

			for (int child : childs) {
				if (!visited[child]) {
					isLeaf = false;
					dfs(child, depth + 1);
					childCnt[depth][parent] += childCnt[depth + 1][child];
				}
			}
			if (isLeaf) {
				MAX = Math.max(MAX, depth);
				childCnt[depth][parent] = 1;
			}
			else
				childCnt[depth][parent]++;
	}

}
