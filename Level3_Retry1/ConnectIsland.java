package Programmers.Level3_Retry1;

import java.util.Arrays;
import java.util.Comparator;

public class ConnectIsland {

	public static void main(String[] args) {

		int[][] c1 ={
				{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}
		};

		System.out.println("result : " + solution(4, c1));

	}

	static int[] parents;
	public static int solution(int n, int[][] costs) {
		int answer = 0;

		parents = new int[n];
		// 초기화
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}

		// 낮은 가중치 기준으로 정렬
		Arrays.sort(costs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		for (int[] cost : costs) {
			int v1 = cost[0];
			int v2 = cost[1];
			int w = cost[2];
			// 연결되어 있지 않다면 연결
			if (parents[getParent(v1)] != parents[getParent(v2)]) {
				union(v1, v2);
				answer += w;
			}

		}
		return answer;
	}

	static int getParent(int v) {
		if (parents[v] == v)
			return v;
		return getParent(parents[v]);
	}

	static void union(int v1, int v2) {
		v1 = getParent(v1);
		v2 = getParent(v2);

		if (v1 < v2) {
			int temp = v1;
			v1 = v2;
			v2 = temp;
		}
		parents[v1] = v2;
	}

}
