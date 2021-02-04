package BOJ.DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem11403 {

	static int n;
	static int[][] graph;
	static int[][] result = new int[n][n];

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		n = scan.nextInt();
		graph = new int[n][n];
		result = new int[n][n];
		int[] visited ;

		scan.nextLine();
		for (int i = 0; i < n; i++) {
			String[] line = scan.nextLine().split(" ");
			for(int j=0; j < line.length; j++) {
				int value = Integer.valueOf(line[j]);
				graph[i][j] = value;
			}
		}

		for (int i = 0; i < n; i++) {
			for(int j=0; j < n; j++) {
				visited = new int[n];
				if(possible(i, j, visited))
					result[i][j] = 1;
			}
		}
		
		for (int i = 0; i < n; i++) {
			for(int j=0; j < n; j++) {
				System.out.print(result[i][j]);
				if (j != n-1)
					System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	private static boolean possible(int from, int to, int[] visited) {
		
		Queue<Integer> q = new LinkedList<>();
		q.add(from);
		
		while (!q.isEmpty()) {
			int v = q.poll();
			int[] childes = graph[v];

			for (int i=0; i < n; i++) {
				if (childes[i] == 1 && visited[i] == 0) {
					if(i == to)
						return true;
					visited[i] = 1;
					q.add(i);
				}
			}
		}
		return false;
		
	}
	private static void show(int[][] arr) {
		for(int i = 0 ; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
}
