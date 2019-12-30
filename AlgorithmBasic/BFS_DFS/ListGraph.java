package Programmers.AlgorithmBasic.BFS_DFS;

import java.util.ArrayList;

public class ListGraph {

	private ArrayList<ArrayList<Integer>> listGraph;

	// size의 Node를 가진 Graph 생성
	public ListGraph(int size) {
		this.listGraph = new ArrayList<ArrayList<Integer>>();

		// size+1까지 만들어서
		// 0은 사용하지 않겠음
		// 이게 더 명확하고 편 할 수 있음.
		for ( int i = 0 ; i < size+1; i++ ) {
			listGraph.add(new ArrayList<Integer>());
		}
	}

	public ArrayList<ArrayList<Integer>> getGraph(){
		return this.listGraph;
	}

	// 그래프의 특정 노드 받아옴
	public ArrayList<Integer> getNode(int i){
		return this.listGraph.get(i);
	}

	// 그래프 추가 ( 양방향 )
	public void put(int x, int y ) {
		listGraph.get(x).add(y);
		listGraph.get(y).add(x);
	}

	public void singlePut( int x, int y) {
		listGraph.get(x).add(y);
	}

	public void printGraph() {

		for ( int i = 1 ; i < listGraph.size(); i++ ) {
			System.out.println(" 정점 " + i + "의 인접리스트 : " + listGraph.get(i).toString());
		}
	}

	public static void main(String[] args) {

		int size = 6 ;

		ListGraph adjList = new ListGraph(size);

		adjList.put(1, 2);
		adjList.put(1, 3);
		adjList.put(2, 3);
		adjList.put(2, 4);
		adjList.put(3, 4);
		adjList.put(3, 5);
		adjList.put(4, 5);
		adjList.put(4, 6);

		adjList.printGraph();

	}

}
