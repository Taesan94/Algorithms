package Programmers.BackJoon.Implements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem14503 {
	
	static int N, M, Result;
	static int[][] Map;
	static Info Robot;	

	// 동,북,서,남
	static int[] X = {0, -1, 0, 1};
	static int[] Y = {1, 0, -1, 0};
	static Map<Integer,Integer> Direction = new HashMap<>();
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		
		Direction.put(1, 0);
		Direction.put(0, 1);
		Direction.put(3, 2);
		Direction.put(2, 3);
		
		Result = 0;
		Map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		Robot = new Info(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()), Direction.get(Integer.valueOf(st.nextToken())));
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				Map[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		if (Map[Robot.x][Robot.y] == 0)
		{			
			Map[Robot.x][Robot.y] = 2;
			Result++;
		}
		
		// 현재 방향 왼쪽부터, 청소가능한 구역있는지 ?
		while (true) {
			if (!movePossible()) {
				// 후진 불가능하면 break
				if (!backPossible())
					break;
			}
		}
		System.out.println(Result);
	}
	
	static boolean backPossible() {
		
		int back = (Robot.eye + 2) % 4;
		
		int nX = Robot.x + X[back];
		int nY = Robot.y + Y[back];
		
		if (nX < 0 || nX >= N || nY < 0 || nY >= M)
			return (false);
		if (Map[nX][nY] == 1)
			return (false);
		Robot = new Info(nX, nY, Robot.eye);
		return (true);
	}
	
	static boolean movePossible() {
		Info r = Robot;
		
		for (int i = 1; i <= 4; i++) {
			
			int nextEye = (r.eye + i) % 4;
			int nX = r.x + X[nextEye];
			int nY = r.y + Y[nextEye];
			
			
			if (nX < 0 || nX >= N || nY < 0 || nY >= M)
				continue;
			if (Map[nX][nY] == 0) {
				Robot = new Info(nX, nY, nextEye) ;
				Result++;
				Map[nX][nY] = 2;
				return (true) ;
			}
		}
		
		return (false);
	}
	
	static void print(int[][] arr) {
		for (int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
	}
	
	static class Info {
		int x;
		int y;
		int eye;
		
		public Info(int x, int y, int eye) {
			this.x = x;
			this.y = y;
			this.eye = eye;
		}

		@Override
		public String toString() {
			return "Info [x=" + x + ", y=" + y + ", eye=" + eye + "]";
		}
		
	}

}
