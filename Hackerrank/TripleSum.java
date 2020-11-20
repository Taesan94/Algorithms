package Programmers.Hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TripleSum {

	static int[][] arr = {
			{1, 4, 5},
			{2, 3, 3},
			{1, 2, 3}
	};

	public static void main(String[] args) {

		int[] a = {
				5, 4, 1 , 1,4,5,1,4,5,1,4,5
		};

		int[] b = {
				2,3,3
		};

		int[] c = {
				1,2,3
		};

		System.out.println(triplets2(a,b,c));
	}

	static long triplets(int[] a, int[] b, int[] c) {

		Map<String,Boolean> visited = new HashMap<>();
		long answer = 0;

		for (int i = 0; i < a.length; i++) {
			int p = a[i];
			for (int j = 0; j < b.length; j++) {
				int q = b[j];
				if (q >= p) {
					for (int k = 0; k < c.length; k++) {
						int r = c[k];
						if (q >= r) {
							String value = String.valueOf(p) + String.valueOf(q) + String.valueOf(r);
							if (!visited.getOrDefault(value, false)) {
								answer++;
								visited.put(value, true);
							}
						}
					}
				}
			}
		}
		return answer;
	}

	static long triplets2(int[] a, int[] b, int[] c) {

		List<Long> A = new ArrayList<>();
		List<Long> B = new ArrayList<>();
		List<Long> C = new ArrayList<>();

		setMap(A, a);
		setMap(B, b);
		setMap(C, c);

		int i = 0 , j = 0, k = 0;

		long answer = 0;

		while (i < B.size()) {
			while (j < A.size() && B.get(i) >= A.get(j)) j++;
			while (k < C.size() && B.get(i) >= C.get(k)) k++;
			answer += (long)j * (long)k;
			i++;
		}


		return answer;
	}

	static void setMap(List<Long> list, int[] arr) {
		Map<Long,Boolean> visited = new HashMap<>();

		for (int num : arr) {
			long n = (long)num;
			if (!visited.getOrDefault(n, false)) {
				visited.put(n, true);
				list.add(n);
			}
		}
		Collections.sort(list);
	}
}
