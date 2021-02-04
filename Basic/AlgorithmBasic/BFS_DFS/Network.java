package Basic.AlgorithmBasic.BFS_DFS;

public class Network {

	public static void main(String[] args) {
		int n =3;
		int[][] computers= {
				{1, 1, 0}, {1, 1, 0}, {0, 0, 1}
		};

		int result= solution(n, computers);
		System.out.println(" Result : " + result );


	}

	static int[][] cputs ;
	static boolean[] visits ;

	public static int solution(int n, int[][] computers) {

		int answer = 0;

		cputs = computers;
		visits = new boolean[n];

		for( int i=0; i<n; i++ ) {

			if( !visits[i] ) {
				dfs(i);
				answer++;
			}
		}
		return answer ;
	}

	private static void dfs( int vertex ) {
		
		if( !visits[vertex] ) {
			
			visits[vertex] = true;
			
			int[] wk = cputs[vertex];
			for( int i=0; i<wk.length; i++ ) {
				if( wk[i]==1 && !visits[i] ) {
					dfs(i);
				}
			}
		}
	}

}
