package BOJ.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem1260 {
	
	static int cnt = 0 ;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// 1. vertext, edge , start V
		String[] input1 = scan.nextLine().split(" ");
		// 2. connct V
		String[] input2;
		int vCnt = Integer.valueOf(input1[0]);
		int eCnt = Integer.valueOf(input1[1]);
		int startV = Integer.valueOf(input1[2]);
		//Adjancy Array
		int[][] graph = new int[vCnt+1][vCnt+1];
		int[] visits = new int[vCnt+1];

		for(int i = 0; i < eCnt; i++) {
			input2 = scan.nextLine().split(" ");
			int a = Integer.valueOf(input2[0]);
			int b = Integer.valueOf(input2[1]);
			graph[a][b] = graph[b][a] = 1;
		}
		// show(graph);
		dfs(graph, visits, startV);
		System.out.println();
		cnt = 0;
		visits = new int[vCnt+1];
		bfs(graph, visits, startV);
		
	}
	
	private static void show(int[][] graph) {
		for ( int i = 1; i < graph.length; i++ ) {
			System.out.println(Arrays.toString(graph[i]));
		}
	}
	
	private static void dfs(int[][] graph, int[]visits, int v) {
		// 깊이우선 탐색
		// 가장 바닥부터 찍는다.
		if(visits[v] == 1)
			return;
		visits[v] = 1;
		cnt++;
		// 현재 v의 자식요소가 1일 때, 그 v의 자식을 계속해서 재귀해야 함.
		int[] childs = graph[v];
		
		System.out.print(v);
		if (cnt < graph.length - 1)
			System.out.print(" ");
		for( int i = 1; i < graph.length; i++ ) {
			if (childs[i] == 1 && visits[i] == 0) {
				dfs(graph, visits, i);
			}
		}
	}
	
	private static void bfs(int[][] graph, int[] visits, int v) {
		// 너비우선 탐색
		// 현재 노드의 모든 자식을 다 본다음에 넘어간다.
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		
		while (!q.isEmpty()) {
			int v2 = q.poll();
			
			if(visits[v2] == 1)
				continue;
			visits[v2] = 1;
			cnt++;
			System.out.print(v2);
			if (cnt < graph.length - 1)
				System.out.print(" ");
			int[] childs = graph[v2];
			for (int i = 1; i <graph.length; i++) {
				if(childs[i] == 1 && visits[i] == 0)
					q.add(i);
			}
		}
	}
}
