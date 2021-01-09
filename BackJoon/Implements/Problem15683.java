package Programmers.BackJoon.Implements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem15683 {
	
	static int N, M, Min;
	static int[][] Map;
	static Map<Integer, List<Info>> cctvInfo = new HashMap<>();
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 전체보면서, cctv를 만났을 때
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		Map = new int[N][M];
		Min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				Map[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		makeCCTV();
		find(0, 0, Map);
		
		System.out.println(Min);
	}
	
	static void print(int[][] arr) {
		for (int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println("####################");
	}
	
	static void makeCCTV() {
		
		List<Info> list;
		Info i1;
		Info i2;
		Info i3;
		Info i4;
		
		for (int i = 1; i <= 5; i++) {
			cctvInfo.put(i, new ArrayList<>());
		}
		// 1 y증, y감, x증, x감
		list = cctvInfo.get(1);
		
		i1 = new Info();
		i1.list.add(new Pair(0, 1));
		list.add(i1);
		
		i2 = new Info();
		i2.list.add(new Pair(0, -1));
		list.add(i2);
		
		i3 = new Info();
		i3.list.add(new Pair(1, 0));
		list.add(i3);
		
		i4 = new Info();
		i4.list.add(new Pair(-1, 0));
		list.add(i4);
		
		cctvInfo.put(1, list);
		
		// 2 y증y감, x증x감
		list = cctvInfo.get(2);
		
		i1 = new Info();
		i1.list.add(new Pair(0, 1));
		i1.list.add(new Pair(0, -1));
		list.add(i1);
		
		i2 = new Info();
		i2.list.add(new Pair(1, 0));
		i2.list.add(new Pair(-1, 0));
		list.add(i2);
		
		cctvInfo.put(2, list);
		
		// 3 x감y증 , x감 y감 , x증 y감 , x증y증
		list = cctvInfo.get(3);
		
		i1 = new Info();
		i1.list.add(new Pair(-1, 1));
		list.add(i1);
		
		i2 = new Info();
		i2.list.add(new Pair(-1, -1));
		list.add(i2);
		
		i3 = new Info();
		i3.list.add(new Pair(1, -1));
		list.add(i3);
		
		i4 = new Info();
		i4.list.add(new Pair(1, 1));
		list.add(i4);
		
		cctvInfo.put(3, list);
		
		// 4 [y증,감 x감]  [y증,감 x증] [x증,감 y증] [x증,감 y감]
		list = cctvInfo.get(4);
		
		i1 = new Info();
		i1.list.add(new Pair(0, 1));
		i1.list.add(new Pair(0, -1));
		i1.list.add(new Pair(-1, 0));
		list.add(i1);
		
		i2 = new Info();
		i2.list.add(new Pair(0, 1));
		i2.list.add(new Pair(0, -1));
		i2.list.add(new Pair(1, 0));
		list.add(i2);
		
		i3 = new Info();
		i3.list.add(new Pair(1, 0));
		i3.list.add(new Pair(-1, 0));
		i3.list.add(new Pair(0, 1));
		list.add(i3);
		
		i4 = new Info();
		i4.list.add(new Pair(1, 0));
		i4.list.add(new Pair(-1, 0));
		i4.list.add(new Pair(0, -1));
		list.add(i4);
		
		cctvInfo.put(4, list);
		
		list = cctvInfo.get(5);
		
		i1 = new Info();
		i1.list.add(new Pair(1, 0));
		i1.list.add(new Pair(-1, 0));
		i1.list.add(new Pair(0, 1));
		i1.list.add(new Pair(0, -1));
		list.add(i1);
		
		cctvInfo.put(5, list);
		
	}
	
	static int[][] copyMap(int[][] origin) {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = origin[i][j];
			}
		}
		return temp;
	}
	
	static int[][] check(int i, int j, List<Pair> pairs, int[][] temp) {
		
		for (int r = 0; r < pairs.size(); r++) {
			Pair p = pairs.get(r);
			
			int next;
			if (p.x != 0) {
				next = i + p.x;
				while (next >= 0 && next < N && temp[next][j] != 6) {
					if (temp[next][j] == 0)
						temp[next][j] = 9;
					next += p.x;
				}
			}
			if (p.y != 0) {
				next = j + p.y;
				while (next >= 0 && next < M && temp[i][next] != 6) {
					if (temp[i][next] == 0)
						temp[i][next] = 9;
					next += p.y;
				}
			}
		}
		return temp;
	}
	
	static void checkMin(int[][] tempMap) {
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tempMap[i][j] == 0)
					cnt++;
			}
		}
		Min = Math.min(Min, cnt);
		// print(tempMap);
	}
	
	static void find(int a, int b, int[][] tempMap) {
		
		
		for (int i = a; i < N; i++) {
			for (int j = b; j < M; j++) {
				int cctv = Map[i][j];
				if (cctvInfo.get(cctv) != null) {
					List<Info> list = cctvInfo.get(cctv);
					for (int k = 0; k < list.size(); k++) {
						List<Pair> pairs = list.get(k).list;
						System.out.println("i : " + i +", j : " +j  +", pairs " + pairs.toString());
						int[][] temp = copyMap(tempMap);
						temp = check(i, j, pairs, temp);
						print(tempMap);
						if (j < M - 1)
							find(i, j + 1, temp);
						else {
							if (i < N - 1) {
								find(i + 1, j, temp);
							}
						}
					}
				}
			}
		}
		checkMin(tempMap);
	}
	// 1번 CCTV 감시가능한 경우  4가지
	
	// 2번 CCTV 감시 가능한경우  2가지
	
	// 3번 CCTV 감시 가능한경우  4가지
	
	// 4번 CCTV 감시 가능한 경우  4가지
	
	// 5번 CCTV 감시 가능한 경우 1가지
	
	static class Info {
		List<Pair> list;
		Info() {
			list = new ArrayList<>();
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
