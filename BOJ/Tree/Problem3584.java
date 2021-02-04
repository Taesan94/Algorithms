package BOJ.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem3584 {

	static Map<Integer, Integer> parents = new HashMap<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.valueOf(br.readLine());

		for (int i = 0; i < t; i++) {

			int n = Integer.valueOf(br.readLine());

			parents = new HashMap<>();
			StringTokenizer st;
			int v1;
			int v2;
			for (int j = 0; j < n - 1; j++) {

				st = new StringTokenizer(br.readLine());

				v1 = Integer.valueOf(st.nextToken());
				v2 = Integer.valueOf(st.nextToken());
				parents.put(v2, v1);
			}

			st = new StringTokenizer(br.readLine());

			v1 = Integer.valueOf(st.nextToken());
			v2 = Integer.valueOf(st.nextToken());

			int d1 = getDepth(v1);
			int d2 = getDepth(v2);

			if (d2 < d1) {
				int temp = v1;
				v1 = v2;
				v2 = temp;
				temp = d1;
				d1 = d2;
				d2 = temp;
			}

			while (v1 != v2) {
				if (d1 == d2) {
					v1 = parents.getOrDefault(v1, v1);
					v2 = parents.getOrDefault(v2, v2);
				} else {
					v2 = parents.getOrDefault(v2, v2);
					d2--;
				}
			}

			System.out.println(v1);

		}
	}

	static int getDepth(int v) {

		int depth = 0;

		while (parents.get(v) != null) {
			depth++;
			v = parents.get(v);
		}
		return depth;
	}

}
