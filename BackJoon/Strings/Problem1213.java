package Programmers.BackJoon.Strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem1213 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] arr = br.readLine().toCharArray();

		int[] visited = new int[91];
		for (char c : arr) {
			visited[c]++;
		}

		List<Character> odd = new ArrayList<>();
		List<Character> even = new ArrayList<>();

		for (int i = 65; i < 91; i++) {
			if (visited[i] != 0) {
				if (visited[i] % 2 == 0)
					even.add((char)i);
				else
					odd.add((char)i);
			}
		}

		int result = odd.size() - even.size();

		if (result > 0) {
			System.out.println("I'm Sorry Hansoo");
			return;
		}

		Collections.sort(odd);
		Collections.sort(even);

		StringBuilder sb = new StringBuilder("");
		
		for (int i = 0; i < odd.size(); i++) {
			
			char oNum = odd.get(i);
			char eNum = even.get(i);
			
			for (int j = 0; j < visited[oNum]; j++) {
				sb.append(oNum);
			}
			
			for (int j = 0; j < visited[eNum] / 2; j++) {
				sb.append(eNum);
			}
		}
		
		for (int i = 0; i < even.size(); i++) {
			char eNum = even.get(i);
			for (int j = 0; j < visited[eNum] / 2; j++) {
				sb.append(eNum);
			}
		}

		System.out.print(sb.toString());
		System.out.println(sb.reverse().toString());
	}
}
