package Programmers.SummerWinter2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MoveLand {

	public static void main(String[] args) {

		int[][] land = {
				{10, 11, 10, 11}, {2, 21, 20, 10}, {1, 20, 21, 11}, {2, 1, 2, 1}
//				{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}
//				{4, 10, 15, 20}, {20, 15, 20, 15}, {4, 10, 15, 20}, {20, 15, 20, 15}
//				{3, 3, 3, 3},
//				{3, 3, 3, 3},
//				{3, 3, 3, 3},
//				{3, 3, 3, 3}
				
		};

		int height = 1;

		System.out.println("result : " + solution(land, height));

	}


	static int[] posX = {0, 1, 0, -1};
	static int[] posY = {1, 0, -1, 0};

	static int N, H;
	static int[][] partInfo;
	static int[][] landStat;
	static int[] parents;
	static List<MovingInfo> mvInfos = new ArrayList<>();
	
	public static int solution(int[][] land, int height) {
		int answer = 0;

		N = land.length;
		H = height;
		partInfo = new int[N][N];
		landStat = land;

		int partNum = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// bfs 끊길때까지 방문
				if (partInfo[i][j] == 0) {
					partInfo[i][j] = partNum;
					bfs(new Pair(i, j), partNum);
					partNum++;
				}
			}
		}
		
		makeMvInfos();
		Collections.sort(mvInfos);
		
		System.out.println(mvInfos.toString());
		
		parents = new int[partNum];
		for (int i = 0; i < partNum; i++) {
			parents[i] = i;
		}
		
		// 연결 된 정보 기록하기.
		for (int i = 0; i < mvInfos.size(); i++) {
			
			MovingInfo m = mvInfos.get(i);
			
			if (getParent(m.from) != getParent(m.to)) {
				union(m.from, m.to);
				answer += m.value;
			}
		}
		
		return answer;
	}
	
	static int getParent(int land) {
		if (parents[land] == land)
			return land;
		return getParent(parents[land]);
	}
	
	static void union(int from, int to) {
		
		from = getParent(from);
		to = getParent(to);
		
		if (from < to)
			parents[to] = from;
		else
			parents[from] = to;
	}
	
	static void makeMvInfos() {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 2; k++) {
					
					int nextI = i + posX[k];
					int nextJ = j + posY[k];
					
					if (nextI >= 0 && nextI < N && nextJ >= 0 && nextJ < N) {
						if (partInfo[i][j] != partInfo[nextI][nextJ]) {
							mvInfos.add(new MovingInfo(partInfo[i][j], partInfo[nextI][nextJ], Math.abs(landStat[i][j] - landStat[nextI][nextJ])));
						}
					}
				}
			}
		}
	}
	
	static void bfs(Pair start, int partNum){

		Queue<Pair> q = new LinkedList<>();
		
		q.add(start);

		while(!q.isEmpty()) {

			Pair p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = p.x + posX[i];
				int nextY = p.y + posY[i];

				if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
					if (partInfo[nextX][nextY] == 0 && Math.abs(landStat[p.x][p.y] - landStat[nextX][nextY]) <= H) {
						q.add(new Pair(nextX, nextY));
						partInfo[p.x][p.y] = partNum;
					}
				}
			}
		}
	}

	static void print(boolean[][] arr) {
		for (boolean[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
	}

	static class Pair {

		int x;
		int y;

		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return "x : " + x +", y : " + y;
		}
	}
	
	static class MovingInfo implements Comparable<MovingInfo>{
		
		int from;
		int to;
		int value;
		
		MovingInfo(int from, int to, int value) {
			this.from = from;
			this.to = to;
			this.value = value;
		}
		
		@Override
		public int compareTo(MovingInfo o) {
			// return this.value - o.value == 0 ? this.from - o.from == 0 ? this.to - o.to : this.from - o.from : this.value - o.value;
			return this.value - o.value;
		}
		
		public String toString() {
			return "from : " + from +", to : " + to + ", value : " + value + "\n";
		}
	}

}