package BOJ.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem3055 {

	static int R, C, Time = Integer.MAX_VALUE;
	static char[][] Map;
	static boolean[][] Visited;
	static int[] X = {1, -1, 0, 0};
	static int[] Y = {0, 0, 1, -1};

	static Queue<Pair> Waters = new LinkedList<>();
	static Queue<Pair> Gs = new LinkedList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.valueOf(st.nextToken());
		C = Integer.valueOf(st.nextToken());
		Map = new char[R][C];
		Visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				Map[i][j] = s.charAt(j);
				if (Map[i][j] == 'S') {
					Gs.add(new Pair(i, j, 0));
				} else if (Map[i][j] == '*') {
					Waters.add(new Pair(i, j, 0));
				}
			}
		}

		while (!Gs.isEmpty()) {
			
			// print(Map);
			// 물 채우기.
			fill_water();
			// 고슴도치 갈 수 있는곳 다 가기.
			if (move_G())
				return ;
		}
		System.out.println("KAKTUS");
	}
	
	static void print(char[][] arr) {
		System.out.println("## ## ## ## ##");
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(Map[i][j]);
			}
			System.out.println();
		}
	}

	static boolean move_G() {
		Queue<Pair> newG = new LinkedList<>();
		while (!Gs.isEmpty()) {
			Pair p = Gs.poll();

			if (Map[p.x][p.y] == 'D') {
				Time = Math.min(Time, p.seq);
				System.out.println(Time);
				return true;
			}
			
			if (Visited[p.x][p.y])
				continue;
			Visited[p.x][p.y]= true; 
			
			for (int i = 0; i < 4; i++) {
				int nX = p.x + X[i];
				int nY = p.y + Y[i];

				if (nX < 0 || nX >= R || nY < 0 || nY >= C || Visited[nX][nY])
					continue;
				if (Map[nX][nY] == '.' || Map[nX][nY] == 'D') {
					newG.add(new Pair(nX, nY, p.seq + 1));
				}
			}
		}
		Gs = newG;
		return false;
	}

	static void fill_water() {
		Queue<Pair> newW = new LinkedList<>();
		
		while (!Waters.isEmpty()) {
			Pair p = Waters.poll();

			for (int i = 0; i < 4; i++) {
				int nX = p.x + X[i];
				int nY = p.y + Y[i];

				if (nX < 0 || nX >= R || nY < 0 || nY >= C)
					continue;
				if (Map[nX][nY] == '.') {
					Map[nX][nY] = '*';
					newW.add(new Pair(nX, nY, 0));
				}
			}
		}
		Waters = newW;
	}

	static class Pair {

		int x;
		int y;
		int seq;

		public Pair(int x, int y, int seq) {
			this.x = x;
			this.y = y;
			this.seq = seq;
		}

		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + ", seq=" + seq + "]";
		}
	}

}
