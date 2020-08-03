package Programmers.BackJoon.DFS;

import java.util.Arrays;
import java.util.Scanner;

public class Problem14502 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		int row = Integer.valueOf(input[0]);
		int col = Integer.valueOf(input[1]);
		
		int[][] map = new int[row+1][col+1];
		
		for(int i=1; i <= row; i++) {
			input = scan.nextLine().split(" ");
			for(int j=1; j <= col; j++) {
				map[i][j] = Integer.valueOf(input[j-1]);
			}
		}
		show(map);
		
		// 전체 순회 하면서, 0일 때놓는다.
		
		// how ?
		
		// 
		
		
	}
		
	
	private static void show(int[][] arr) {
		for(int i = 0 ; i < arr.length; i++) {
			
			System.out.println(Arrays.toString(arr[i]));
		}
	}
}
