package Programmers.AlgorithmBasic.Greedy;

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
		
		boolean[] visit = new boolean[n];
		int[][] min = new int[n][n];
		
		// 모든 섬을 방문한다.
		for(int i=0; i<n; i++) {
			
			// 방문하지 않았다면, 최소 경로르 찾는다.
			if( !visit[i] ) {
				
				visit[i] = true;
				
				for( int[] cost : costs ) {
					int from = cost[0];
					int to = cost[1];
					
					if( from == i ) {
						min[from][to] = Math.min(min[from][to], cost[2]);
					}else if ( to == i ) {
						min[to][from] = Math.min(min[to][from], cost[2]);
					}
				}
			}
			
			
		}
		
		
		
		
		return answer;
	}

}
