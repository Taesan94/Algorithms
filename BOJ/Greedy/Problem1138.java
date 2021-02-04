package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Problem1138 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.valueOf(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] line = new int[N];
		int[] result = new int[N];

		for (int i = 0; i < N; i++) {
			line[i] = Integer.valueOf(st.nextToken());
		}

		// 1의 위치는 정해져있다.
		result[line[0]] = 1;
		
		for (int i = 1; i < N; i++) {
			int cnt = line[i] + 1;
			int j = 0;
			while (j < N) { 
				if (result[j] == 0)
					cnt--;
				if (cnt == 0)
					break ;
				j++;
			}
			result[j] = i + 1;
		}
		StringBuilder sb = new StringBuilder("");
		
		for (int i = 0; i < N; i++) {
			sb.append(result[i]);
			if (i != N - 1)
				sb.append(" ");
		}
		System.out.print(sb.toString());
		solution(N, line);
	}
	
	static void solution(int N, int[] line) {
		System.out.println("\nis Solution");
		LinkedList<Integer> list = new LinkedList<>();
		
		for (int i = N - 1; i >= 0; i--) {
			list.add(line[i], i + 1);
		}
		System.out.println(list.toString());
		
		
		
	}
}
