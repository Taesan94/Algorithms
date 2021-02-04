package BOJ.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1753_retry {

	static int INF = 300001;
	static List<Pair>[] graph;
	static int[] distance;
	static int v,e,s;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.valueOf(st.nextToken());
		e = Integer.valueOf(st.nextToken());
		s = Integer.valueOf(br.readLine());

		
		distance = new int[v + 1];
		Arrays.fill(distance, INF);
		distance[s] = 0;
		
		graph = new ArrayList[v + 1];
		
		for (int i = 0; i <= v; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.valueOf(st.nextToken());
			int to = Integer.valueOf(st.nextToken());
			int w= Integer.valueOf(st.nextToken());
			graph[from].add(new Pair(to, w));
		}
		
//		for (int i = 0; i < v; i++) {
//			List<Pair> p = graph[i];
//			System.out.println(p.toString());
//		}
		
		
		dijkstra(s);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= v; i++) {
			if (distance[i] == INF)
				sb.append("INF");
			else
				sb.append(String.valueOf(distance[i]));
			if (i != v)
				sb.append("\n");
		}
		System.out.println(sb.toString());

	}
	
	static void dijkstra(int vertex) {
		
		boolean[] visited = new boolean[v + 1];
		
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.w - o2.w;
			}
		});
		
		pq.add(new Pair(vertex, 0));
		
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
	}
	
	static class Pair {
		int v;
		int w;
		
		Pair(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		public String toString() {
			return "v : " + v +", w : " + w ;
		}
		
	}

}
