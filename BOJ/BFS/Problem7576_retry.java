package BOJ.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem7576_retry {

	static int[] X = {0,0,1,-1};
	static int[] Y = {1,-1,0,0};

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String[] input1 = scan.nextLine().split(" ");
		int col = Integer.valueOf(input1[0]);
		int row = Integer.valueOf(input1[1]);
		int[][] box = new int[row+1][col+1];
		int[][] visits = new int[row+1][col+1];
		Queue<int[]> goodTomato = new LinkedList<>();
		Queue<int[]> goodTomato2 = new LinkedList<>();
		
		int bad = 0;
		int good = 0;

		for (int i = 1;  i <= row; i++ ) {
			String[] line = scan.nextLine().split(" ");
			for (int j=1; j <= line.length; j++) {
				box[i][j] = Integer.valueOf(line[j-1]);
				if(box[i][j] == 0)
					bad++;
				if(box[i][j] == 1) {
					good++;
					goodTomato.add(new int[] {i,j});
				}
			}
		}
		if ( bad == 0 || good == row * col ) {
			System.out.println("0");
			return ;
		}
		int cnt = 0 ;
		while(!goodTomato.isEmpty()) {
			
			int[] current = goodTomato.poll();
			
			int x = current[0];
			int y = current[1];
			
			if(visits[x][y] == 1)
				continue;
			
			visits[x][y] = 1;
			
			for( int i = 0 ; i < 4; i ++ ) {
				int nextX = x + X[i];
				int nextY = y + Y[i];
				
				if (nextX <= 0 || nextY <= 0 || nextX > row || nextY > col)
					continue;
				if (box[nextX][nextY] == 0 && visits[nextX][nextY] == 0) {
					box[nextX][nextY] = 1;
					goodTomato2.add(new int[] {nextX, nextY});
					bad--;
				}
				if (bad == 0) {
					System.out.println(cnt + 1);
					return ;
				}
			}
			
			if(goodTomato.isEmpty() && !goodTomato2.isEmpty()) {
				goodTomato.addAll(goodTomato2);
				goodTomato2.clear();
				cnt++;
			}
		}
		if (bad != 0)
			System.out.println("-1");
		else
			System.out.println(cnt-1);
	}


	private static void show(int[][] arr) {
		for(int i = 0; i < arr.length; i ++ ) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}

}
