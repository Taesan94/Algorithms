package Programmers.BackJoon.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1238 {

	static int N, M, X; // 학생 수(정점의 갯수), 도로갯수(간선), 도착 정점.
	static List<Pair>[] roots1;
	static List<Pair>[] rootsR;
	static int INF = 10001;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		X = Integer.valueOf(st.nextToken());

		roots1 = new List[N + 1];
		rootsR = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			roots1[i] = new ArrayList<>();
			rootsR[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.valueOf(st.nextToken());
			int to = Integer.valueOf(st.nextToken());
			int w= Integer.valueOf(st.nextToken());
			roots1[from].add(new Pair(to, w));
			rootsR[to].add(new Pair(from, w));
		}

		//		for (int i = 1; i <= N; i++) {
		//			List<Pair> p = roots[i];
		//			System.out.println(p.toString());
		//		}

		int[] d1 = dijkstra(X,roots1);
		int[] d2 = dijkstra(X,rootsR);

//		for(int[] a : distances) {
//			System.out.println(Arrays.toString(a));
//		}
		
		
		int[] result = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			result[i] = d1[i] + d2[i];
		}
		
		Arrays.sort(result);
		System.out.println(result[result.length - 1]);

	}

	static int[] dijkstra(int start, List<Pair>[] roots) {

		boolean[] visited = new boolean[N + 1];
		int[] distance = new int[N + 1];
		Arrays.fill(distance, INF);
		distance[start] = 0;

		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.w - o2.w;
			}
		});

		pq.add(new Pair(start, 0));

		while (!pq.isEmpty()) {

			int curr = pq.poll().v;
			if (visited[curr])
				continue;

			visited[curr] = true;
			List<Pair> adjList = roots[curr];
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
		return distance;
	}	

	static class Pair {
		int v;
		int w;

		Pair(int v, int w) {
			this.v = v;
			this.w = w;
		}

		public String toString() {
			return "[ v : " + v +", w : " + w +" ]";
		}

	}

}
