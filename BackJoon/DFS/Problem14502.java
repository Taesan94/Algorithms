package Programmers.BackJoon.DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem14502 {

	static int max = -1;
	static int row;
	static int col;
	static int[][] map;
	static int[] arrX = {0, 0, 1, -1};
	static int[] arrY = {1, -1, 0, 0};
	static Queue<int[]> infections = new LinkedList<>();

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		row = Integer.valueOf(input[0]);
		col = Integer.valueOf(input[1]);
		map = new int[row][col];


		for(int i=0; i < row; i++) {
			input = scan.nextLine().split(" ");
			for(int j=0; j < col; j++) {
				int num = Integer.valueOf(input[j]);
				if (num == 2)
					infections.add(new int[] {i,j});
				map[i][j] = num;
			}
		}
		// N*M 행렬에서 모든 좌표에 3개씩 놓는 경우의 수를 찾은 후
		// 해당 경우에 가능한 안전 영역의 최대크기를 찾는다.
		putThreeWall(0, 0);

		System.out.println(max);
	}

	private static void putThreeWall(int start, int cnt) {

		// System.out.println("start : " + start +", cnt : " + cnt );
		if (cnt == 3) {
			// 3개의 벽을 모두 세웠을 때, 안전영역의 크기를 센다.
			int safeArea = getSafeArea();
			max = Math.max(safeArea, max);
			return ;
		}
		for (int i=start; i < (row * col); i++) {
			int x = i / col;
			int y = i % col;

			if(map[x][y] == 0) {
				map[x][y] = 1;
				putThreeWall((i + 1), (cnt + 1));
				map[x][y] = 0;
			}
		}
	}

	private static int getSafeArea() {

		int[][] tempMap = new int[row][col];
		Queue<int[]> tempQ = new LinkedList<>();

		for(int i=0; i < row; i++) {
			for(int j=0; j < col; j++) {
				tempMap[i][j] = map[i][j];
			}
		}
		tempQ.addAll(infections);
		while(!tempQ.isEmpty()) {

			int[] infection = tempQ.poll();

			int x = infection[0];
			int y = infection[1];

			for(int k=0; k < 4; k++) {
				int nextX = x + arrX[k];
				int nextY = y + arrY[k];
				if( (nextX >= 0 && nextX < row) && (nextY >= 0 && nextY < col)) {
					if(tempMap[nextX][nextY] == 0) {
						tempQ.add(new int[] {nextX, nextY});
						tempMap[nextX][nextY] = 2;
					}
				}
			}
		}
		int safeArea = 0;
		for(int i=0; i < row; i++) {
			for(int j=0; j < col; j++) {
				if(tempMap[i][j] == 0)
					safeArea++;
			}
		}
		return safeArea;
	}

	private static void show(int[][] arr) {
		for(int i = 0 ; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
}
