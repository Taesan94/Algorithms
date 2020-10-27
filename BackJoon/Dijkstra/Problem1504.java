package Programmers.BackJoon.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1504 {

	static List<Pair>[] graph;
	static int N,E;
	static int INF = 160000001;
	static int result;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.valueOf(st.nextToken());
		E = Integer.valueOf(st.nextToken());
		graph = new List[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		int v1,v2;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			v1 = Integer.valueOf(st.nextToken());
			v2 = Integer.valueOf(st.nextToken());
			int w = Integer.valueOf(st.nextToken());

			graph[v1].add(new Pair(v2,w));
			graph[v2].add(new Pair(v1,w));
		}

		st = new StringTokenizer(br.readLine());
		v1 = Integer.valueOf(st.nextToken());
		v2 = Integer.valueOf(st.nextToken());

		int r1 = 0;
		int r2 = 0;

		r1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
		r2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);
		
		int min = Math.min(r1, r2);
		
		if (min < INF)
			System.out.println(min);
		else
			System.out.println(-1);
	}


	static int dijkstra(int start, int end) {

		boolean[] visited = new boolean[N + 1];
		int[] distance = new int[N + 1];
		Arrays.fill(distance, INF);
		distance[start] = 0;

		PriorityQueue<Pair> pq = new PriorityQueue<>();

		pq.add(new Pair(start, 0));

		while (!pq.isEmpty()) {	
			int curr = pq.poll().v;

			if (visited[curr])
				continue;			
			visited[curr] = true;

			List<Pair> adjList = graph[curr];
			for (int i = 0; i < adjList.size(); i++) {
				Pair next = adjList.get(i);
				if (!visited[next.v]) {
					if (distance[curr] + next.w < distance[next.v]) {
						distance[next.v] = distance[curr] + next.w;
						pq.add(new Pair(next.v, distance[next.v]));
					}
				}
			}
		}
		result += distance[end];
		return distance[end];
	}

	static class Pair implements Comparable<Pair>{
		int v;
		int w;

		Pair(int v, int w) {
			this.v = v;
			this.w = w;
		}

		public int compareTo(Pair o) {
			return this.w - o.w;
		}

		public String toString() {
			return "v : " + v +", w : " + w ;
		}

	}

}
