package Programmers.AlgorithmBasic.BFS_DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS {

	private static ArrayList<ArrayList<Integer>> listGraph;

	private static int[] visits ;

	private static ArrayList<Integer> result ;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String input = scan.nextLine();

		String[] inputs=input.split(" ");

		int vertex = Integer.valueOf(inputs[0]);
		int edge = Integer.valueOf(inputs[1]);
		int start = Integer.valueOf(inputs[2]);

		// 그래프 만들기
		listGraph(vertex);

		for ( int i = 0 ; i < edge; i ++ ) {
			String[] next = scan.nextLine().split(" ");
			put(Integer.valueOf(next[0]),Integer.valueOf(next[1]));
		}

		//DFS
		visits = new int[listGraph.size()];
		result = new ArrayList<Integer>();
		DFS(start);
		printGraph();

		visits = new int[listGraph.size()];
		result = new ArrayList<Integer>();
		BFS(start);
		
		System.out.println();
		printGraph();

		//BFS

	}

	private static void DFS(int vertex) {

		// 방문하지않았으면
		if( visits[vertex]==0 ) {
			// 방문 체크를 하고
			visits[vertex]=1;

			result.add(vertex);

			// 인접노드를 방문한다.
			ArrayList<Integer> hasNodes = listGraph.get(vertex);

			Collections.sort(hasNodes);

			for ( int i = 0; i < hasNodes.size(); i++ ) {
				if(visits[hasNodes.get(i)]==0) {
					DFS(hasNodes.get(i));
				}
			}
		}

	}//dfs

	private static void BFS(int vertex) {

		Queue<Integer> q = new LinkedList<Integer>();

		q.add(vertex);
		visits[vertex]=1;

		while ( !q.isEmpty() ) {

			int workingVertex = q.poll();
			result.add(workingVertex);


			ArrayList<Integer> hasNodes = listGraph.get(workingVertex);
			Collections.sort(hasNodes);

			for ( int i = 0; i < hasNodes.size(); i++ ) {
				if( visits[hasNodes.get(i)] == 0 ) {
					visits[hasNodes.get(i)]=1;
					q.add(hasNodes.get(i));
				}
			}
		}

	}//dfs

	// size의 Node를 가진 Graph 생성
	private static void listGraph(int size) {
		listGraph = new ArrayList<ArrayList<Integer>>();

		// size+1까지 만들어서
		// 0은 사용하지 않겠음
		// 이게 더 명확하고 편 할 수 있음.
		for ( int i = 0 ; i < size+1; i++ ) {
			listGraph.add(new ArrayList<Integer>());
		}
	}

	// 그래프 추가 ( 양방향 )
	private static void put(int x, int y ) {
		listGraph.get(x).add(y);
		listGraph.get(y).add(x);
	}

	private static void printGraph() {

		for ( int i = 0 ; i < result.size(); i++ ) {
			System.out.print(result.get(i));
			if ( i != result.size()-1 ) System.out.print(" ");
		}
	}

}
