package Programmers.BackJoon.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1761 {

	static int INF = 10001;
	static int N, M;

	static List<Node>[] tree;
	static List<Integer>[] distance;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());


		tree = new List[N + 1];
		distance = new List[N + 1];

		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
			distance[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int v1 = Integer.valueOf(st.nextToken());
			int v2 = Integer.valueOf(st.nextToken());
			int value = Integer.valueOf(st.nextToken());

			tree[v1].add(new Node(v2, value));
			tree[v2].add(new Node(v1, value));
		}

		dijkstra();

		M = Integer.valueOf(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.valueOf(st.nextToken());
			int v2 = Integer.valueOf(st.nextToken());
			System.out.println(distance[v1].get(v2));
		}

	}

	static void dijkstra() {

		for (int i = 1; i <= N; i++) {

			boolean[] visited = new boolean[N + 1];
			List<Integer> dis = distance[i];

			for (int k = 0; k <= N; k++) {
				dis.add(INF);
			}
			dis.set(i, 0);

			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(i,0));

			while (!pq.isEmpty()) {

				int v = pq.poll().v;

				if (visited[v])
					continue;

				visited[v] = true;

				List<Node> list = tree[v];
				
				for (int j = 0; j < list.size(); j++) {
					
					int next = list.get(j).v;
					int value = list.get(j).value;
					
					if (!visited[next] && dis.get(v) + value < dis.get(next)) {
						dis.set(next, dis.get(v) + value);
						pq.add(new Node(next, dis.get(next)));
					}
				}
			}
		}
	}

	static class Node implements Comparable<Node> {
		int v;
		int value;

		Node (int v, int value) {
			this.v = v;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return this.value - o.value;
		}
		
		public String toString() {
			return "v : " + v +", value : " + value;
		}
	}

}
