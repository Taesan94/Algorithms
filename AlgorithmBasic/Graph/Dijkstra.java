package Programmers.AlgorithmBasic.Graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {

	public static void main(String[] args) {

		int INF = 50001; // 무한대 값
		int N = 9; // 정점의 개수를 표현하기 위한 배열의 크기
		int[] distance = new int[N]; // 정점의 최단거리 기록
		boolean[] visit = new boolean[N];  // 정점의 최단거리 기록

		int[][] adjacency = { // 주어진 그래프를 표현하기위한 인접행렬
				{ 0,0,0,0,0,0,0,0,0 },
				{ 0,0,4,3,INF,INF,INF,INF,INF },
				{ 0,4,0,2,5,INF,INF,INF,INF },
				{ 0,3,2,0,3,6,INF,INF,INF },
				{ 0,INF,5,3,0,1,5,INF,INF },
				{ 0,INF,INF,6,1,0,INF,5,INF },
				{ 0,INF,INF,INF,5,INF,0,2,7 },
				{ 0,INF,INF,INF,INF,5,2,0,4 },
				{ 0,INF,INF,INF,INF,INF,7,4,0},
		};

		// 최초 최단거리를 무한대 값으로 초기화
		for ( int i=1; i<N; i++ ) distance[i] = INF;

		// 시작정점
		int start = 1 ;

		// 가중치가 가장 작은 대상을 먼저 처리하도록 하기위해  PriorityQueue를 사용.
		PriorityQueue<Pair> pq = new PriorityQueue<>();

		// 시작 정점의 최단거리는 0.
		distance[start] = 0;
		pq.add(new Pair(start,0));

		// 가중치가 낮은 노드부터 방문
		while( !pq.isEmpty() ) {

			Pair pair = pq.poll();

			int vertex = pair.vertex;

			// 해당 정점을 방문했다는 것은, 최단거리를 구했다는 의미.
			if( visit[vertex] ) continue;

			// 방문처리
			visit[vertex] = true;

			// 인접한 노드 중에서 최소 값을 갱신 할 수 있다면, 최소비용을 변경.
			// 모든 정점을 확인한다.
			for( int i=1; i<N; i++) {
				if( !visit[i] ) { // 최단거리를 구하지않은 정점을 기준으로 
					// 1. 해당 정점과 인접한 정점으로 가는 가중치 값 + 해당 정점까지 걸린 최소거리.
					// 2. 해당 정점의 기록된 최단거리를 비교한다.
					if( ( adjacency[vertex][i] + distance[vertex] ) < distance[i] ) { // weight의 초깃 값을 INF로 채웠기 때문에, 연결 되어 있는경우에만 확인.
						// 조건에 맞는 경우 최단거리 기록.
						distance[i] = adjacency[vertex][i] + distance[vertex];
						// 기준 정점으로부터, 인접한 정점의 최단경로를 구한 후, 인접한 정점 이후의 인접한 대상을 찾기위하여 add해준다.
						pq.add(new Pair(i,distance[i]));
					}
				}
			}
			System.out.println( " 정점 [ " + vertex+ " ] 방문 후 최단거리 : " + Arrays.toString(distance));
		}
	}

	// 최단거리 기록 및, 최단거리 순 정렬을 위한 class
	static class Pair implements Comparable<Pair>{

		int vertex;
		int distance;

		Pair(int vertex, int distance){
			this.vertex= vertex;
			this.distance = distance;
		}

		// 최단거리 순으로 정렬하기 위한 코드
		@Override
		public int compareTo(Pair o){
			return distance-o.distance;
		}
	}
}
