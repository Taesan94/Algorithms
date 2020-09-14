package Programmers.AlgorithmBasic.BFS_DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Problem18352 {

	static List<List<Integer>> board = new ArrayList<>();
	static boolean[] visited;	
	static List<Integer> result = new ArrayList<>();
	static int N, M, K, X, cnt = 0;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String[] inputs = scan.nextLine().split(" ");

		N = Integer.valueOf(inputs[0]);
		M = Integer.valueOf(inputs[1]);
		K = Integer.valueOf(inputs[2]);
		X = Integer.valueOf(inputs[3]);

		
		for (int i = 0; i < N + 1; i++) {
			board.add(new ArrayList<>());
		}
		
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			String[] input = scan.nextLine().split(" ");
			board.get(Integer.valueOf(input[0])).add(Integer.valueOf(input[1]));
		}

		visited[X] = true;
		bfs();
		
		if (result.size() > 0) {
			Collections.sort(result);
			
			for(int n : result) {
				System.out.println(n);
			}
		} else 
			System.out.println(-1);
	}

	private static void bfs() {
		
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		
		q.add(X);
		
		while(!q.isEmpty()) {
			int wkV = q.poll();
			
			List<Integer> list = board.get(wkV);
			
			for (int i = 0; i < list.size(); i++){
				int v = list.get(i);
				if (!visited[v]) {
					visited[v] = true;
					q2.add(v);
				}
			}
			
			if (q.isEmpty() && !q2.isEmpty()) {
				cnt++;
				if (cnt == K) {
					result.addAll(q2);
					return;
				}
                q.addAll(q2);
				q2.clear();
			}
		}
	}
}