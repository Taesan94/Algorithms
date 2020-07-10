package Programmers.AlgorithmBasic.Graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra_nlogn {

	public static void main(String[] args) {
		int n = 6;

		int[][] vertex = {
				{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}
		};

		int result = solution(n,vertex);

		System.out.println( "result : " + result );
	}

	static boolean[] visit ;
	static int[] distance ;
	static int[][] weight ;

	
	static int N ;
	static int INF = 50001;

	public static int solution(int n, int[][] edge) {
		int answer = 0;

		N= n+1;

		weight = new int[N][N];
		distance = new int[N];
		visit = new boolean[N];

		// 가중치 ,최단거리 초기화 작업.
		for( int i=1; i<N; i++ ) {
			Arrays.fill(weight[i], INF);
			distance[i] = INF;
		}
		
		// 그래프 연결 작업, 양뱡향으로 연결
		for(int i=0; i<edge.length; i++) 
			weight[edge[i][0]][edge[i][1]]=weight[edge[i][1]][edge[i][0]]=1;
		
		for( int[] w : weight ) {
			System.out.println(Arrays.toString(w));
		}
		
		// 다익스트라 알고리즘은, 하나의 정점에서 모든 정점간의 최단거리를 구한다.
		// 문제에서 시작 정점은 1이다.
		dijkstra(1);
		
		Arrays.sort(distance);
		
		// 가장 멀리 떨어진 노드를 구하는 문제이기 때문에, 가장 먼 거리를 찾는다.
		int max = distance[N-1];

		// 큰 대상부터, max와 동일한 거리에 있는 대상들만 count해준다.
		for(int i=N-1; i>=0; i-- ) {
			if(distance[i]==max) answer++;
			else break;
		}

		return answer;
	}

	static void dijkstra(int start) {

		// 가중치가 가장 작은 대상을 넣어간다.
		// 작은 대상을 먼저 처리해야하기 때문에, PriorityQueue를 사용한다.
		
		// 내가 풀었던 문제에서는 가중치가 모두 1이라, PriorityQueue적용을 하지않아도 해결할 수 있는것 같다..
		// 하지만, 가중치가 Random할 때, 하나의 정점에 2개가 인접했다면, 가중치가 더 작은 정점을 먼저 방문한 후에 최소 거리를 구하는게 맞다..
		// 그렇기 때문에, heap구조의 pq를 활용한다.
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		// 시작 정점의 최단거리는0이다.
		distance[start] = 0;
		pq.add(new Pair(start,0));

		// 가까운 순서대로 처리.
		while( !pq.isEmpty() ) {

			Pair pair = pq.poll();

			int vertex = pair.vertex;
			
			// 해당 정점을 방문했다는 것은, 최단거리를 구했다는 의미이다.
			if( visit[vertex] ) continue;
			
			// 방문처리
			visit[vertex] = true;

			// 인접한 노드 중에서 최소 값을 갱신 할 수 있다면, 최소비용을 변경해준다.
			// 모든 정점을 확인한다.
			for( int i=1; i<N; i++) {
				if( !visit[i] ) { // 최단거리를 구하지않은 정점을 기준으로 
					// 1. 해당 정점과 인접한 정점으로 가는 가중치 값 + 해당 정점까지 걸린 최소거리.
					// 2. 해당 정점의 기록된 최단거리를 비교한다.
					if( ( weight[vertex][i] + distance[vertex] ) < distance[i] ) { // weight의 초깃 값을 INF로 채웠기 때문에, 연결 되어 있는경우에만 확인하게 된다.
						// 최소 값을 기록해준다.
						distance[i] = weight[vertex][i] + distance[vertex];
						// 기준 정점으로부터, 인접한 정점의 최단경로를 구한 후
						// 인접한 정점 이후의 인접한 대상을 찾기위하여 add해준다.
						pq.add(new Pair(i,distance[i]));
					}
				}
			}
			System.out.println( "[ " + vertex +" ] 에 인접한 정점들은 ??? : " + pq.toString());
		}
	}
	
	// 해당 정점에 도달 할 수 있는 최단거리를 기록하기위한 클래스이다.
	// distance는 가중치값이다, 가중치가 작은 값이 먼저 처리되도록 정렬하기 위함이다.
	static class Pair implements Comparable<Pair>{

		int vertex;
		int distance;

		Pair(int vertex, int distance){
			this.vertex= vertex;
			this.distance = distance;
		}

		// 처리 순서가 빠른대상이 먼저 처리되도록.
		@Override
		public int compareTo(Pair o){
			return distance-o.distance;
		}

		@Override
		public String toString() {
			return "Pair [vertex=" + vertex+ ", distance=" + distance + "]";
		}

	}

}
