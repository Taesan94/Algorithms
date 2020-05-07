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

		for(int i=0; i<edge.length; i++) 
			weight[edge[i][0]][edge[i][1]]=weight[edge[i][1]][edge[i][0]]=1;
		
		
		for( int[] w : weight ) {
			System.out.println(Arrays.toString(w));
		}
		

		dijkstra(1);

		Arrays.sort(distance);

		int max = distance[N-1];

		for(int i=N-1; i>=0; i-- ) {
			if(distance[i]==max) answer++;
			else break;
		}

		return answer;
	}

	static void dijkstra(int start) {

		// 가중치가 가장 작은 대상을 넣어간다. 최초 시작은 start의 정보이다.
		// 그냥 vertex로 해봤더니.. 거리기준으로 정렬 할 수 가 없다..
		PriorityQueue<Pair> pq = new PriorityQueue<>();

		distance[start] = 0;
		pq.add(new Pair(start,0));

		// 가까운 순서대로 처리.
		while( !pq.isEmpty() ) {

			Pair pair = pq.poll();

			int vertex = pair.vertex;
			int cost = pair.distance;
			
			if( visit[vertex] ) continue;
			
			// 방문처리
			visit[vertex] = true;

			// 인접한 노드 중에서 최소 값을 갱신 할 수 있다면, 최소비용을 변경해준다.
			for( int i=1; i<N; i++) {
				if( !visit[i] ) {
					if( ( weight[vertex][i] + distance[vertex] )< distance[i] ) {
						distance[i] = weight[vertex][i] + distance[vertex];
						System.out.println("[ vertex : "+vertex+" ], distance["+i+"] : "+ distance[i]);
						pq.add(new Pair(i,distance[i]));
					}
				}
			}
			
			System.out.println(" ### distance : " + Arrays.toString(distance) + ", " + pair.toString());
		}

		System.out.println(" distance REsult : " + Arrays.toString(distance));
	}

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
