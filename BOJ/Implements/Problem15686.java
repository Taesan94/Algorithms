package BOJ.Implements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Problem15686 {

	static int N, M, Min;
	static int[] positions;
	static boolean[] visited;
	static List<Pair> houses = new ArrayList<>();
	static List<Pair> chickens = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int sort = Integer.valueOf(st.nextToken());
				if (sort == 1)
					houses.add(new Pair(i, j));
				else if (sort == 2)
					chickens.add(new Pair(i, j));
			}
		}
		positions = new int[M];
		visited = new boolean[chickens.size()];
		Min = 100000;
		comb(0, 0);
		
		System.out.println(Min);
		
		
	}
	
	static int getMinDistance(List<Pair> comb) {
		
		int sum = 0;
		for (int i = 0; i < houses.size(); i++) {
			Pair p = houses.get(i);
			int minDistance = 100000;
			for (int j = 0; j < comb.size(); j++) {
				Pair c = comb.get(j);
				minDistance = Math.min(minDistance, Math.abs(p.x - c.x) + Math.abs(p.y - c.y));
			}
			sum += minDistance;
		}
		return sum;
	}
	
	static void comb(int start, int cnt) {
		
		if (cnt == M) {
			List<Pair> storeComb = new ArrayList<>();
			for (int i = 0; i < positions.length; i++) {
				storeComb.add(chickens.get(positions[i]));
			}
			Min = Math.min(Min, getMinDistance(storeComb));
			return ;
		}
		
		for (int i = start; i < chickens.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				positions[cnt] = i;
				comb(i + 1, cnt + 1);
				visited[i] = false;
			}
		}
	}
	
	static class Pair {
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
	}
}
