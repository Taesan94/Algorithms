package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem9576 {
	
	static List<Borrow> list;
	static boolean[] status;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int caseCnt = Integer.valueOf(br.readLine());
		
		for (int i = 0;  i < caseCnt; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.valueOf(st.nextToken());
			int m = Integer.valueOf(st.nextToken());
			list = new ArrayList<>();
			status = new boolean[n + 1];
			for (int j = 0 ; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.valueOf(st.nextToken());
				int b = Integer.valueOf(st.nextToken());
				list.add(new Borrow(a, b));
			}
			Collections.sort(list);
			System.out.println(list.toString());
			System.out.println(checkPossible());
		}
	}
	// 일단 a ~ b를 class로 기록.
	// a가작은것부터 정렬.
	// 가장 작은거 빌려주고, 그 작은게 빌려갔으면 max까지 하나씩 높여간다.
	static int checkPossible() {
		int cnt = 0;
		
		for (int i = 0; i < list.size(); i++) {
			
			Borrow bor = list.get(i);
			int j = bor.a;
			while (j <= bor.b) {
				if (!status[j]) {
					status[j] = true;
					cnt++;
					break;
				}
				j++;
			}
		}
		return cnt;
	}
	
	static class Borrow implements Comparable<Borrow>{
		int a;
		int b;
		
		public Borrow(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public String toString() {
			return "Books [a=" + a + ", b=" + b + "]";
		}
		
		@Override
		public int compareTo(Borrow o) {
			int result = this.b - o.b;
			if (result == 0)
				result = this.a - o.a;
			return result;
		}
		
	}
}
