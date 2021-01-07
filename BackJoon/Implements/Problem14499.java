package Programmers.BackJoon.Implements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14499 {

	static int N, M, X, Y, K;
	static int[][] Map;
	static int[] Dice = new int[6];
	// 동, 서, 북, 남
	static int[] posX = {0, 0, 0, -1, 1};
	static int[] posY = {0, 1, -1, 0, 0};
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		X = Integer.valueOf(st.nextToken());
		Y = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());
		
		Map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				Map[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		// System.out.println("N : " + N +", M : " + M +", X : " + X +", Y : " + Y +", K : " + K);
		
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < K; i++) {
			int pos = Integer.valueOf(st.nextToken());
			int nX = X + posX[pos];
			int nY = Y + posY[pos];
			
			if (nX < 0 || nX >= N || nY < 0 || nY >= M)
				continue;
			X = nX;
			Y = nY;
			
			int top = Dice[0];
			
			if (pos == 1) { // 동
				Dice[0] = Dice[4];
				Dice[4] = Dice[2];
				bottom(Dice[5]);
				Dice[5] = top;
			} else if (pos == 2) { // 서
				Dice[0] = Dice[5];
				Dice[5] = Dice[2];
				bottom(Dice[4]);
				Dice[4] = top;
			} else if (pos == 3) { // 북
				Dice[0] = Dice[3];
				Dice[3] = Dice[2];
				bottom(Dice[1]);
				Dice[1] = top;
			} else { // 남
				Dice[0] = Dice[1];
				Dice[1] = Dice[2];
				bottom(Dice[3]);
				Dice[3] = top;
			}
			// System.out.println("X : " + X +", Y : " + Y + ", Bottom : " + Dice[2]);
			sb.append(Dice[0]);
			if (i != K - 1)
				sb.append("\n");
		}
		System.out.print(sb.toString());
	}
	
	static void bottom(int diceBottom) {
		
		if (Map[X][Y] == 0) {
			Map[X][Y] = diceBottom;
			Dice[2] = diceBottom;
		} else {
			Dice[2] = Map[X][Y];
			Map[X][Y] = 0;
		}
	}

}
