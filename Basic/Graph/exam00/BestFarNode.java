package Basic.Graph.exam00;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BestFarNode {

	public static void main(String[] args) {

		int n = 6;
		int[][] edge = {
				{3,6},
				{4,3},
				{3,2},
				{1,3},
				{1,2},
				{2,4},
				{5,2}
		};

		int result = solution(n, edge);

		System.out.println(" result : " + result );

	}

	static int INF = 30000;

	public static int solution(int n, int[][] edge) {
		int answer = 0;


		// 최단거리 기록
		int[] minDistance = new int[n+1];
		boolean[] visits = new boolean[n+1];

		int[][] graph = new int[n+1][n+1];

		for( int i=1; i<n+1; i++) {
			minDistance[i]= INF;
			Arrays.fill(graph[i],INF);			
		}

		minDistance[1] = 0; // 시작정점의 최단거리는 0
		// connect
		for( int[] e : edge ) {
			graph[e[0]][e[1]] = 1;
			graph[e[1]][e[0]] = 1;
		}

		// 시작, 우선순위 큐에 정점,정점까지의 가중치 값을 기록해서 가중치가 작은 값부터 처리되도록
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});

		pq.add(new int[] {1,0});

		while ( !pq.isEmpty() ) {
			
			int v = pq.poll()[0];
			
			if( visits[v] ) continue;
			visits[v] = true;

			for( int i=1; i<n+1; i++ ) {
				if( !visits[i] && minDistance[v] + graph[v][i] < minDistance[i] ) {
					minDistance[i] = minDistance[v] + graph[v][i];
					pq.add(new int[] {i,minDistance[i]});
				}
			}
		}
		
		Arrays.sort(minDistance);
		
		int max = minDistance[n];
		
		for( int i=n; i>=0; i-- ) {
			if( minDistance[i] == max ) answer++;
			else break;
		}
		
		return answer;
	}

}
