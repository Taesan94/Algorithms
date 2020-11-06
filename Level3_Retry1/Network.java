package Programmers.Level3_Retry1;

public class Network {

	public static void main(String[] args) {

		int[][] c1 = {
				{1,1,0},
				{1,1,0},
				{0,0,1}
		};
		int[][] c2 = {
				{1,1,0},
				{1,1,1},
				{0,1,1}
		};
		System.out.println(solution(3, c1));
		System.out.println(solution(3, c2));
		

	}

	static boolean[] visited;
	public static int solution(int n, int[][] computers) {
		int answer = 0;

		int[][] netWork = new int[n][n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				answer++;
				visited[i] = true;
				dfs(i, computers);
			}
		}
		return answer;
	}

	static void dfs(int v, int[][] computers) {
		
		int[] adjArr = computers[v];
		
		for (int i = 0; i < adjArr.length; i++) {
			if (!visited[i] && adjArr[i] == 1) {
				visited[i] = true;
				dfs(i, computers);
			}
		}
	}
}
