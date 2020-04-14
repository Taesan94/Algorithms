package Programmers.Level3;

public class Network {

	public static void main(String[] args) {

		int n = 3;
		int[][] computers = {
				// {1,1,0},{1,1,0},{0,0,1}
				{1,1,0}, {1,1,1} , {0,1,1}
		};
		int result = solution(n,computers);

		System.out.println("result : " + result );
	}

	public static int solution(int n, int[][] computers) {

		int result = 0;
		
		boolean[] visit = new boolean[n];
		
		for ( int i = 0 ; i < computers.length; i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(i,computers,visit);
				result++;
			}
		}
		return result;
	}
	
	private static void dfs(int v, int[][] computers, boolean[] visit ) {
		
		int[] computer = computers[v];
		
		for ( int i=0; i < computer.length; i++ ) {
			if(!visit[i] && computer[i] == 1) {
				visit[i] = true;
				dfs( i,computers,visit);
			}
		}
	}

}
