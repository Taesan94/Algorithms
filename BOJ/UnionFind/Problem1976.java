package BOJ.UnionFind;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem1976 {

	static int N;
	static int[] parents;
	static int[][] map;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		N = Integer.valueOf(scan.nextLine());
		map = new int[N + 1][N + 1];
		parents = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
		int M = Integer.valueOf(scan.nextLine());

		for (int i = 1; i <= N; i++) {

			StringTokenizer st = new StringTokenizer(scan.nextLine());
			// i번째 도시에서 
			for (int j = 1; j <= N; j++) {
				int possible = Integer.valueOf(st.nextToken());
				// j번째 도시에 갈 수 있다면 연결, 숫자가 작은 도시를 기준으로 해준다.
				if (possible == 1) {
					union(i, j);
				}
			}
		}

		// 모든 연결이 끝난 후 마지막에, 경로가 가능한지 본다.
		String[] plan = scan.nextLine().split(" ");

		int prev = Integer.valueOf(plan[0]);
		int root = getParent(prev);

		for (int i = 1; i < plan.length; i++) {
			if(root != getParent(Integer.valueOf(plan[i]))) {
				System.out.println("NO");
				return ;
			}
		}
		
		System.out.println("YES");
	}

	static int getParent(int city) {
		if (parents[city] == city)
			return city;
		return getParent(parents[city]);
	}
	
	static void union(int from, int to) {
		int fromP = getParent(from);
		int toP = getParent(to);

		// 기준이 없어도 정답 ! , 그러나 그래프의 연결정보가 부정확 함
		if (fromP < toP)
			parents[toP] = fromP;
		else
			parents[fromP] = toP;
	}

}
