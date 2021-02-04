package Basic.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Rank {

	public static void main(String[] args) {

		int n =5 ;

		int[][] results ={
				{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}
		};	

		int result = solution(n,results);

		System.out.println( " result : " + result );

	}

	public static int solution(int n, int[][] results) {
		int answer = 0;

		List<List<Integer>> players = new ArrayList<>();
		List<List<Integer>> winners = new ArrayList<>();

		for( int i=0; i<=n; i++ ) {
			players.add(new ArrayList<>());
			winners.add(new ArrayList<>());
		}

		for(int[] r : results ) {

			int winner = r[0];
			int looser = r[1];

			players.get(winner).add(looser);
			players.get(looser).add(winner);
			winners.get(looser).add(winner);
		}

		Queue<Integer> q = new LinkedList<Integer>();

		boolean[] visit = new boolean[n+1];

		// 처음 찾을 수 있는 대상을 확인.
		for ( int i=1; i<=n; i++ ) {
			if( players.get(i).size()+1 == n ) {
				q.add(i);
				visit[i] = true;
				answer++;
			}
		}

		while ( !q.isEmpty() ) {
			int ok = q.poll();
			for ( int i=1; i<=n; i++ ) {
				
				List<Integer> list = players.get(i);
				if( list.contains(ok)) {
					
					
				}
			}
		}
		return answer;
	}
}
