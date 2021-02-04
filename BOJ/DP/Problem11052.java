package BOJ.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11052 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.valueOf(br.readLine());
		int[] p = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			p[i] = Integer.valueOf(st.nextToken());
		}
		for (int i = 1; i <=n; i++) {
			for (int j = 1; j <= i; j++) {
				p[i] = Math.max(p[i], p[i - j] + p[j]);
			}
		}
		System.out.println(p[n]);
	}

}
