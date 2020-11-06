package Programmers.Level3_Retry1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class BestDistanceNode {

	public static void main(String[] args) {

		int[][] edge = {
				{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}
		};

		System.out.println(solution(6, edge));

	}

	static int INF = 1000001;
	static List<Integer>[] graph;
	static int[] distances;

	public static int solution(int n, int[][] edge) {
		int answer = 0;

		graph = new List[n + 1];
		distances = new int[n + 1];

		Arrays.fill(distances, INF);

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int[] e : edge) {
			graph[e[0]].add(e[1]);
			graph[e[1]].add(e[0]);
		}

		distances[1] = 0;
		dijkstra(1);

		Arrays.sort(distances);

		int max = 0;

		for (int i = n; i >= 0; i--) {
			if (distances[i] == INF)
				continue;

			max = Math.max(max,distances[i]);
			if (distances[i] == max)
				answer++;
			else
				break;

		}
		return answer;
	}

	private static void dijkstra(int v) {

		boolean[] visited = new boolean[graph.length];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(v, 0));

		while (!pq.isEmpty()) {

			Pair p = pq.poll();

			if (visited[p.v])
				continue;

			visited[p.v] = true;
			List<Integer> adjList = graph[p.v];

			for (int i = 0; i < adjList.size(); i++) {
				int nV = adjList.get(i);
				if (distances[p.v] + 1 < distances[nV]) {
					distances[nV] = distances[p.v] + 1;
					pq.add(new Pair(nV, distances[nV]));
				}
			}
		}
	}

	static class Pair implements Comparable<Pair>{

		int v;
		int w;

		Pair (int v, int w)  {
			this.v = v;
			this.w = w;
		}

		public int compareTo(Pair o) {
			return this.w - o.w;
		}
	}
}
