package Basic.AlgorithmBasic.Graph;

import java.util.Arrays;

public class Dijkstra_n2 {

	public static void main(String[] args) {

		int n = 6;

		int[][] vertex = {
				{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}
		};

		int result = solution(n,vertex);

		System.out.println( "result : " + result );

	}

	static int INF = 50001;
	static int N=0 ;
	static boolean[] visits;
	static int[] distance;
	static int[][] weight ;

	public static int solution(int n, int[][] edge) {
		int answer = 0;

		N = n+1;
		visits = new boolean[N];
		distance = new int[N];

		weight = new int[N][N];
		
		// 가중치 초기화 작업.
		
		for( int[] w : weight ) Arrays.fill(w, INF);
		
		for(int i=0; i<edge.length; i++) {
			int[] e = edge[i];
			
			weight[e[0]][e[1]] = 1; 
			weight[e[1]][e[0]] = 1;
		}
		System.out.println("Before Distance : " + Arrays.toString(distance));
		dijkstra(1);
		System.out.println("After Distance : " + Arrays.toString(distance));
		
		int max = distance[N-1];
		
		for(int i=N-1; i>=0; i--) {
			if(distance[i]==max) answer++;
			else break;
		}
		
		return answer;
	}

	// 가장 최소 거리를 가지는 정점을 반환.
	static int getSmallIndex() {
		int min = INF;
		int index = 0 ;

		for(int i=1; i<N; i++) {
			if(!visits[i] && distance[i] < min ) {
				min = distance[i];
				index = i;
			}
		}
		return index;
	}

	// 다익스트라 함수
	static void dijkstra(int start) {
		// start는 기준이되는 정점이다.
		// start와 모든 정점간의 최소거리를 구한다.

		// start에서 i로 가는 최소거리를 초기화작업을해준다
		distance[1] = 0 ;
		for(int i=2; i< N; i++ ) {
			distance[i] = weight[start][i]; 
		}

		// 방문한 대상은 방문체크.
		visits[start] = true;

		// 첫번째 노드는 봤고..
		// 마지막노드는 안봐도 된다 ? 왜안봐도되냐 

		// 1회전에 최소비용을 가지는 노드로가서, distance를 초기화해준다.
		for( int i=1; i< N-2; i++ ) {
			int current = getSmallIndex();
			visits[current] = true;

			// 현재 최소 값을 가지는 정점에 인접한 노드들을 확인한다.
			for(int j=1; j<N; j++ ) {
				if( !visits[j] ) { // 방문하지 않았고 
					if( weight[current][j]+distance[current] < distance[j] ) {
						// 현재까지 이동거리 + 해당 노드까지의 거리가 , 해당 노드의 최소비용보다 작다면 변경해준다.
						distance[j] = weight[current][j] + distance[current];
					}
				}
			}
		}
	}

}
