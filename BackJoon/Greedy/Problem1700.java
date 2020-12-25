package Programmers.BackJoon.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1700 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n =
				Integer.valueOf(st.nextToken());
		int k = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(br.readLine());

		int[] order = new int[k];
		boolean[] use = new boolean[k + 1];
		for (int i = 0; i < k; i++) {
			order[i] = Integer.valueOf(st.nextToken()); 
		}
		
		int cnt = 0;
		int possible = n;
		for (int i = 0; i < k; i++) {
			int m = order[i];

			if (use[m]) // 사용중
				continue;

			if (possible <= 0) { // 콘센트를 뽑아야하는 경우
				cnt++;
				List<Integer> after = new ArrayList<>();
				// 현재 콘센트의 기기들이 나중에 사용 됨?
				for (int j = i + 1; j < k; j++) {
					int m2 = order[j];
					if (use[m2] && !after.contains(m2))
						after.add(m2);
				}
				
				// 지금 꽂혀있는게 다 나중에 한번이라도 더 쓰이면, 맨 마지막에 있는거를 뽑아주기.
				if (after.size() == n) {
					use[after.get(after.size() - 1)] = false;
				} else {
					for (int j = 0; j < k; j++) {
						int m2 = order[j];
						if (use[m2] && !after.contains(m2))
							use[m2] = false;
					}
				}
			}
			possible--;
			use[m] = true;
		}
		System.out.println(cnt);
	}
}
