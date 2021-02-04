package BOJ.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem1697_retry {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String[] input = scan.nextLine().split(" ");
		
		int subin = Integer.valueOf(input[0]);
		int sister = Integer.valueOf(input[1]);
		
		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();
		q.add(subin);
		// 2로 떨어지면 , 나누고 아니면 -1, +1 
		int cnt = 0;
		
		boolean[] visits = new boolean[100001];
		
		while (!q.isEmpty()) {
			
			int current = q.poll();
			
			if (current == sister) {
				System.out.println(cnt);
				return ;
			}
			
			if (current + 1 <= 100000 && !visits[current + 1]) {
				q2.add(current + 1);
				visits[current + 1] = true;
			}
			if (current - 1 <= 100000 && current - 1 >= 0 && !visits[current - 1]) {
				q2.add(current - 1);
				visits[current - 1] = true;
			}
			if (current * 2 <= 100000 && !visits[current * 2]) {
				q2.add(current * 2);
				visits[current * 2] = true;
			}
			
			if(q.isEmpty() && !q2.isEmpty()) {
				cnt++;
				q.addAll(q2);
				q2.clear();
			}
		}
		System.out.println(cnt);
	}
}
