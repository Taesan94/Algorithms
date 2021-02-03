package Programmers.BackJoon.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem13549 {
	
	static int LIMIT = 100001;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		int k = Integer.valueOf(st.nextToken());
		
		boolean[] visited = new boolean[LIMIT];
		
		if (n == k)
			System.out.println(0);
		else {
			PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1] - o2[1];
				}
			});
			
			q.add(new int[] {n, 0});
			
			while (!q.isEmpty()) {
				
				int[] v = q.poll();
				
				if (v[0] == k) {
					System.out.println(v[1]);
					return ;
				}
				
				if (visited[v[0]])
					continue;
				visited[v[0]] = true;
				
				if (v[0] + 1 < LIMIT && !visited[v[0] + 1]) {
					q.add(new int[] {v[0] + 1, v[1] + 1});
				}
				if (v[0] - 1 >= 0 && !visited[v[0] - 1]) {
					q.add(new int[] {v[0] - 1, v[1] + 1});
				}
				if (v[0] > 0 && v[0] * 2 < LIMIT && !visited[v[0] * 2]) {
					q.add(new int[] {v[0] * 2, v[1]});
				}
			}
		}
		/*
		 * 정렬 없이 푸는방법... 그냥 if문 순서에 따라서 정답이 바뀔수도 있다...
		 * 
		else {
			Queue<int[]> q = new LinkedList<>();			
			q.add(new int[] {n, 0});			
			while (!q.isEmpty()) {								
				int[] v = q.poll();				
				if (v[0] == k) {
					System.out.println(v[1]);
					return ;
				}				
				if (visited[v[0]])
					continue;
				visited[v[0]] = true;
                
				if (v[0] * 2 < LIMIT && !visited[v[0] * 2])
					q.add(new int[] {v[0] * 2, v[1]});
                if (v[0] - 1 >= 0 && !visited[v[0] - 1])
					q.add(new int[] {v[0] - 1, v[1] + 1});
				if (v[0] + 1 < LIMIT && !visited[v[0] + 1])
					q.add(new int[] {v[0] + 1, v[1] + 1});
			}
		}
		*/
	}

}
