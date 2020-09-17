package Programmers.AlgorithmBasic.Greedy;

import java.util.Arrays;

public class ConnectIsland {

	public static void main(String[] args) {

		int n = 4 ;
		int[][] costs = {
				{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}

		};	
		
		int result = solution(n,costs);
		
		System.out.println(" result : " + result );

	}

	public static int solution(int n, int[][] costs) {
		int answer = 0;
		
		Arrays.sort(costs,(o1,o2)->{
			return o1[2]-o2[2];
		});
		
		for(int[] c : costs ) {
			System.out.println(Arrays.toString(c));
		}
		
		// 부모노드를 기억한다.
		int[] parent = new int[n];
		
		// 초기 값 지정.
		for(int i=0; i<n; i++) {
			parent[i]=i;
		}
		
		for( int[] cost : costs ) {
			
			int from = cost[0];
			int to = cost[1];
			int value = cost[2];
			
			// 두 정점의 부모노드가 같다면, 이미 연결이 되었으므로 보지않는다.
			if( connectCheck(parent,from,to) ) continue;
			else {
				// 그렇지 않다면, 가중치를 늘려주고 부모노드를 update해준다.
				answer+=value;
				union(parent,from,to);
			}
		}
		return answer;
	}

	private static void union(int[] parent, int from, int to) {
		from = getParent(parent,from);
		to = getParent(parent,to);
		
		// 작은 쪽으로 합친다는 기준을 준다면.
		if(from < to)
			parent[to] = from;
		
		else parent[from] = to;
	}

	private static boolean connectCheck(int[] parent, int from, int to) {
		
		from = getParent(parent,from);
		to = getParent(parent,to);
		
		return from==to;
	}

	private static int getParent(int[] parent, int edge) {
		if(parent[edge]==edge) 
			return edge;
		return getParent(parent, parent[edge]);
	}

}
