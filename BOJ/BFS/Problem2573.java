package BOJ.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem2573 {
	
	static int N, M, Time;
	static int[][] Map;
	static int[][] tempArr;
	static Queue<Pair> IceM = new LinkedList<>();
	static Queue<Pair> temp = new LinkedList<>();
	
	static int[] X = {1, -1, 0, 0};
	static int[] Y = {0, 0, 1, -1};
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		Map = new int[N][M];
		Time = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				Map[i][j] = Integer.valueOf(st.nextToken());
				if (Map[i][j] != 0)
					IceM.add(new Pair(i, j));
			}
		}
		
		while (!IceM.isEmpty()) {
			Time++;
			// 1. 빙산을 녹인다.
			melt();
			
			// 2. 빙산이 두개로 나눠져있는지 확인.
			if (is_split()) {
				System.out.println(Time);
				return ;
			}
		}
		System.out.println(0);
	}
	
	static void print(int[][] arr) {
		System.out.println("## ## ## ## ##");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(Map[i][j]);
			}
			System.out.println();
		}
	}
	
	static void melt() {
		
		tempArr = new int[N][M];
		temp = new LinkedList<>();
		
		while (!IceM.isEmpty()) {
			Pair p = IceM.poll();
			
			int cnt = 0;
			
			for (int i = 0; i < 4; i++) {
				
				int nX = p.x + X[i];
				int nY = p.y + Y[i];
				
				if (nX < 0 || nX >= N || nY < 0 || nY >= M || Map[nX][nY] > 0)
					continue;
				cnt++;
			}
			if (Map[p.x][p.y] - cnt > 0)
				temp.add(p);
			tempArr[p.x][p.y] = cnt; 
		}
		IceM = temp;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Map[i][j] -= tempArr[i][j];
			}
		}
	}
	
	static boolean is_split() {

		int cnt = 0;
		temp = new LinkedList<>();
		tempArr = new int[N][M];
		
		if (IceM.isEmpty())
			return false;
		temp.add(IceM.peek());
		
		while(!temp.isEmpty()) {
			
			Pair p = temp.poll();
			
			if (tempArr[p.x][p.y] == 1)
				continue;
			tempArr[p.x][p.y] = 1;
			cnt++;
			for (int i = 0; i < 4; i++) {
				
				int nX = p.x + X[i];
				int nY = p.y + Y[i];
				
				if (nX < 0 || nX >= N || nY < 0 || nY >= M || Map[nX][nY] <= 0 || tempArr[nX][nY] == 1)
					continue;
				temp.add(new Pair(nX, nY));
			}
		}
		
		if (cnt != IceM.size())
			return true;
		return false;
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
