package Programmers.BackJoon.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem2644 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int v = Integer.valueOf(scan.nextLine());
		String[] input = scan.nextLine().split(" ");

		int p1 = Integer.valueOf(input[0]);
		int p2 = Integer.valueOf(input[1]);
		int n = Integer.valueOf(scan.nextLine());

		int[][] graph = new int[v+1][v+1];
		int[] visits = new int[v+1];

		for( int i=0; i < n; i++) {
			input = scan.nextLine().split(" ");
			int t1 = Integer.valueOf(input[0]);
			int t2 = Integer.valueOf(input[1]);
			graph[t1][t2] = graph[t2][t1] = 1;
		}

		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		q.add(p1);
		int cnt = 1;
		while(!q.isEmpty()) {

			int curr = q.poll();

			if(visits[curr] == 1)
				continue;
			visits[curr] = 1;
			for(int i=0; i <= v; i++) {
				if(graph[curr][i] == 1 && visits[i] == 0) {
					q2.add(i);
					if(i == p2) {
						System.out.println(cnt);
						return;
					}
				}
			}
			if(q.isEmpty() && !q2.isEmpty()) {
				q.addAll(q2);
				q2.clear();
				cnt++;
			}
		}
		System.out.println(-1);
	}
	private static void show(int[][] arr) {
		for(int i = 0 ; i < arr.length; i++ ) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}

}
