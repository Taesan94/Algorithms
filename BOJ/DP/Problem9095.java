package BOJ.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem9095 {
	
	static int[] basic = {1, 2, 3};
	static int cnt = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.valueOf(br.readLine());
		for (int i = 0; i < n; i++) {
			//System.out.println(findNum(Integer.valueOf(br.readLine())));
			cnt = 0;
			findNum2(0, Integer.valueOf(br.readLine()));
			System.out.println(cnt);
		}
	}

	private static int findNum(int n) {
		
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		int answer =  0;

		q.add(1);
		q.add(2);
		q.add(3);

		while (!q.isEmpty()) {
			int num = q.poll();

			if (num == n)
				answer++;
			
			for (int i = 0; i < 3; i++) {
				
				int next = num + basic[i];
				if (next <= n)
					q2.add(next);
			}

			if (q.isEmpty() && !q2.isEmpty()) {
				q.addAll(q2);
				q2.clear();
			}
		}
		
		return answer;
	}
	
	private static void findNum2(int value, int n) {
		
		if (value == n)
			cnt++;
		else if (value > n)
			return;
		else {
			findNum2(value + 1, n);
			findNum2(value + 2, n);
			findNum2(value + 3, n);
		}
	}

}
