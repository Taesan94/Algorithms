package Programmers.BackJoon.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1931 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		List<Conference> conferences = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.valueOf(st.nextToken());
			int end = Integer.valueOf(st.nextToken());
			conferences.add(new Conference(start, end));
		}
		
		Collections.sort(conferences);
		Conference curr = conferences.get(0);
		int cnt = 1;
		// 가장 빨리 끝나는 회으부터 처리한다.
		for (int i = 1; i < n; i++) {
			Conference next = conferences.get(i);
			
			if(next.start >= curr.end) {
				curr = next;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	public static class Conference implements Comparable<Conference>{
		int start;
		int end;
		
		public Conference(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Conference o) {
			int result = this.end - o.end;
			
			if (result == 0)
				result = this.start - o.start;
			
			return result;
		}
		
		@Override
		public String toString() {
			return "start : "+start+", end :" + end;
		}
		
	}
}
