package BOJ.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1753 {

	static int INF = 3000000;
	static List<List<Pair>> graph = new ArrayList<>();
	static int[] minDistance;
	static boolean[] visited;
	static int vertex;
	static int edge;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		vertex = Integer.valueOf(st.nextToken());
		edge = Integer.valueOf(st.nextToken());
		int start = Integer.valueOf(br.readLine());

		minDistance = new int[vertex + 1];
		visited = new boolean[vertex + 1];

		for (int i = 1; i <= vertex; i++) {
			minDistance[i] = INF;
			graph.add(new ArrayList<Pair>());
		}
		minDistance[start] = 0;
		graph.add(new ArrayList<Pair>());

		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.valueOf(st.nextToken());
			int v = Integer.valueOf(st.nextToken());
			int w = Integer.valueOf(st.nextToken());

			Pair p = new Pair(v, w);
			graph.get(u).add(p);
		}

		dijkstra(start);
		for (int i = 1; i <= vertex; i++) {
			if (minDistance[i] == INF)
				System.out.println("INF");
			else
				System.out.println(minDistance[i]);
		}
	}

	private static void dijkstra(int start) {

		// 정점, 가중치
		PriorityQueue<Pair> pq = new PriorityQueue<>();

		pq.add(new Pair(start, 0));

		while (!pq.isEmpty()) {

			int v = pq.poll().vertex;

			if (visited[v])
				continue;
			visited[v] = true;
			List<Pair> list = graph.get(v);
			
			for(Pair p : graph.get(v)) {
				if (!visited[p.vertex] && (minDistance[v] + p.value) < minDistance[p.vertex] ) {
					minDistance[p.vertex] = minDistance[v] + p.value;
					pq.add(new Pair(p.vertex, minDistance[p.vertex])); // 여기 add를 처음에 그냥 p2로 해서 틀렸었다.. 주의 하고 한번더 확인하자.
				}
			}
		}
	}

	public static class Pair implements Comparable<Pair>{

		int vertex;
		int value;

		public Pair(int vertex, int value) {
			this.vertex = vertex;
			this.value = value;
		}

		@Override
		public int compareTo(Pair o) {
			return this.value - o.value;
		}

		@Override
		public String toString() {
			return "vertex : " + vertex + ", value : " + value;
		}

	}

	private static void show(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
}
