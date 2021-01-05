package Programmers.BackJoon.Implements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem3190 {

	static int N, K, L, Result = 0, Eye = 0, SnakeLen = 1;
	static int[][] Map;
	static PriorityQueue<Info> Rota = new PriorityQueue<>();
	static Deque<Pair> Snake = new ArrayDeque<Pair>();
	
	// 우측, 좌측, 상단, 하단
	
	// 우, 상, 좌, 하
	static int[] X = {0, -1, 0, 1};
	static int[] Y = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.valueOf(br.readLine());
		K = Integer.valueOf(br.readLine());
		
		Map = new int[N + 1][N + 1];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			Map[Integer.valueOf(st.nextToken())][Integer.valueOf(st.nextToken())] = 1;
		}
		// print(Map);
		L = Integer.valueOf(br.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			Rota.add(new Info(Integer.valueOf(st.nextToken()), st.nextToken()));
		}
		// System.out.println(Rota.toString());
		
		Snake.add(new Pair(1, 1));		
		
		if (!Rota.isEmpty() && Rota.peek().time == 0)
			changeEye(Rota.poll().dir);
		
		while (true) {
			
			Pair p = Snake.peekFirst();
			Result++;
			int nX = p.x + X[Eye];
			int nY = p.y + Y[Eye];
			
			if (nX < 1 || nY < 1 || nX > N || nY > N) {
//				System.out.println("# wall crush #");
//				System.out.println("[" + Result +"],  SnakeLen : " + SnakeLen +", " + Snake.toString());
//				snakePrint();
				break ;
			}
			Pair next = new Pair(nX, nY);
			// 뱀끼리 부닫히면 끝낸다.
			if (isCrush(next)) {
//				System.out.println("# tail crush #");
//				System.out.println("next : " + next.toString());
//				System.out.println("[" + Result +"],  SnakeLen : " + SnakeLen +", " + Snake.toString());
//				snakePrint();
				break ;
			}
			
			Snake.addFirst(next); // 머리 붙이기.
			if (Map[nX][nY] == 1) {
				SnakeLen++;
				// System.out.println("nX : " + nX +", nY : " + nY +" #################");
				Map[nX][nY] = 0;
			} else {
					Snake.pollLast();
			}
			// System.out.println("[" + Result +"],  SnakeLen : " + SnakeLen +", " + Snake.toString());
			if (!Rota.isEmpty() && Rota.peek().time == Result)
				changeEye(Rota.poll().dir);
			// snakePrint();
		}
		System.out.println(Result);
	}
	
	static boolean isCrush(Pair next) {
		
		Queue<Pair> temp = new LinkedList<>();
		temp.addAll(Snake);
		
		while (!temp.isEmpty()) {
			Pair p = temp.poll();
			if (p.x == next.x && p.y == next.y)
				return true;
		}
		return false;
	}
	
	static void changeEye(String dir) {
		if (dir.equals("L")) {
			Eye++;
			if (Eye == 4)
				Eye = 0;
		} else {
			Eye--;
			
			if (Eye < 0)
				Eye = 3;
		}
	}
	
	static void print(int[][] arr) {
		for(int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
	}
	
	static void snakePrint() {
		System.out.println("===============================================================================");
		Queue<Pair> temp = new LinkedList<>();
		int[][] temp2 = new int[N + 1][N + 1];
		temp.addAll(Snake);
		
		while (!temp.isEmpty()) {
			Pair p = temp.poll();
			temp2[p.x][p.y] = 1;
		}
		print(temp2);
		System.out.println("===============================================================================");
	}
	
	
	static class Pair {
		
		int x;
		int y;
		
		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	static class Info implements Comparable<Info> {
		
		int time;
		String dir;
		
		public Info(int time, String dir) {
			super();
			this.time = time;
			this.dir = dir;
		}
		
		@Override
		public int compareTo(Info o) {
			return this.time - o.time;
		}

		@Override
		public String toString() {
			return "Info [time=" + time + ", dir=" + dir + "]";
		}
	}

}
