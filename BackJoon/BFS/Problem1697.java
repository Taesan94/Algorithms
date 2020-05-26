package Programmers.BackJoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem1697 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int k = scan.nextInt();
		
		
		// 각, 거리에 도달하는데 걸리는 횟수를 기록.
		int[] visits = new int[100001];
		
		//  지나 갈 수 있는 위치를 저장한다.
		Queue<Integer> q = new LinkedList<>();
		
		q.add(n);
		
		// 찾을 때 까지 탐색한다.
		while( !q.isEmpty() ) {
			
			int d = q.poll();
			
			if( d == k ) break;
			
			if( d+1 <= 100000 && visits[d+1] == 0 ) {
				visits[d+1] = visits[d] + 1 ;
				q.add(d+1);
			}
			
			if( d-1 >= 0 && visits[d-1] == 0 ) {
				visits[d-1] = visits[d]+1;
				q.add(d-1);
			}
			
			if( d*2 <= 100000 && visits[d*2] == 0 ) {
				visits[d*2] = visits[d]+1;
				q.add(d*2);
			}
		}
		
		System.out.println( visits[k] );
		
		
	}

}
