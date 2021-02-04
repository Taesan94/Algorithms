package BOJ.TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem7795 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.valueOf(br.readLine());

		for (int i = 0; i < t; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine()); // a cnt , b cnt
			
			int[] A = new int[Integer.valueOf(st.nextToken())];
			int[] B = new int[Integer.valueOf(st.nextToken())];

			setData(br.readLine(), A);
			setData(br.readLine(), B);
			
			Arrays.sort(A);
			Arrays.sort(B);

			int j = 0;
			int result = 0;
			int cnt = 0;

			for (int a = 0; a < A.length; a++) {
				int n = A[a];
				while (j < B.length && n > B[j]) {
					j++;
					cnt++;
				}
				result += cnt;
			}
			System.out.println(result);
		}
	}

	private static void setData(String input, int[] arr) {
		StringTokenizer st = new StringTokenizer(input);
		int i = 0;
		while (st.hasMoreTokens()) {
			arr[i++] = Integer.valueOf(st.nextToken());
		}
	}

}
