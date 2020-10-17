package Programmers.BackJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2003 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		int i = 1;
		int[] nums = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		
		while (st.hasMoreTokens()) {
			nums[i++] = Integer.valueOf(st.nextToken());
		}
		
		int answer = 0;		
		int s = 1;
		int e = 1;
		int value = 0;
		
		while (s <= N) {
			
			if (e > N) {
				s++;
				e = s;
				value = 0;
				continue;
			}
			
			value += nums[e];
			
			if (value < M) {
				e++;
			} else {
				if (value == M)
					answer++;
				s++;
				e = s;
				value = 0;
			}
		}
		
		System.out.println(" answer : " + answer);
		
	}

}
