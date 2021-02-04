package BOJ.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Problem2606 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int vertex = scan.nextInt();
		int edge = scan.nextInt();
		scan.nextLine();


		List<List<Integer>> graph = new ArrayList<>();

		// 인접 리스트 초기화
		for( int i=0; i<=vertex; i++ ) {
			graph.add(new ArrayList<>());
		}

		for( int i=0; i < edge; i++ ) {

			String[] input = scan.nextLine().split(" ");

			int v1 = Integer.valueOf(input[0]);
			int v2 = Integer.valueOf(input[1]);

			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}

		// 방문여부 
		boolean[] visit = new boolean[vertex+1];
		// 처리 중인 데이터를 Queue에 보관해간다.
		Queue<Integer> q = new LinkedList<>();
		q.add(1);

		int cnt = 0 ;

		while( !q.isEmpty() ) {

			int v = q.poll();

			if( !visit[v] ) {
				cnt++;
				visit[v]=true;
				List<Integer> list = graph.get(v);
				for( int v2 : list ) {
					if( !visit[v2] ) q.add(v2);
				}
			}
		}

		// 최초 1번째 컴퓨터는 cnt하지 않도록.
		System.out.println(cnt-1);
	}

}
