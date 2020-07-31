package Programmers.BackJoon.DFS;

import java.util.Arrays;
import java.util.Scanner;

public class Problem11724 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String[] input = scan.nextLine().split(" ");
		
		int v = Integer.valueOf(input[0]);
		int e = Integer.valueOf(input[1]);
		
		int[][] graph = new int[v+1][v+1];
		int[] visits = new int[v+1];
		
		for(int i=0; i < e; i++) {
			input = scan.nextLine().split(" ");
			int a = Integer.valueOf(input[0]);
			int b = Integer.valueOf(input[1]);
			graph[a][b] = 1;
		}
		show(graph);
		
		int cnt = 0;
		
		for (int i=1; i<=v; i++) {
			if(visits[i] == 0) {
				dfs(graph,visits, i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	private static void show(int[][] arr) {
		for(int i = 0 ; i < arr.length; i++) {
			
			System.out.println(Arrays.toString(arr[i]));
		}
	}
	
	private static void dfs(int[][] graph, int[] visits, int v) {
		
		if(visits[v] == 1)
			return ;
		
		visits[v] = 1;
		
		for( int i=1; i < visits.length; i++) {
			if((graph[v][i] == 1 || graph[i][v] == 1 ) && visits[i] == 0)
				dfs(graph, visits, i);
		}
	}

}
