package Programmers.BackJoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem1463 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Integer n = Integer.valueOf(br.readLine());
		int cnt = 0;

		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		q.add(n);
		while (!q.isEmpty()) {

			int num = q.poll();
			
			if (num == 1)
				break;

			if (num != 0 && num % 3 == 0) {
				q2.add(num / 3);
			}
			if (num != 0 && num % 2 == 0) {
				q2.add(num / 2);
			}
			if ((num - 1) > 0)
				q2.add(num - 1);

			if (q.isEmpty() && !q2.isEmpty()) {
				q.addAll(q2);
				q2.clear();
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
