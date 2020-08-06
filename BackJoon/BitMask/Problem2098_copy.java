package Programmers.BackJoon.BitMask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2098_copy {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	// 무한대 |v - 1| * maxLength
	private static int INF = 16 * 1_000_000;
	// vertex 수
	static int n;
	// graph 배열
	static int arr[][];
	// dp[node][visit] = k -> 현재 node번에 잇고 visit를 방문하고 왔을 때
	// 0번 노드로 가는 최소의 거리
	static int dp[][];

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		dp = new int[n][(1 << n) - 1]; // 111... 의 크기만큼할당 ?

		for(int i = 0 ; i < n; i++)
			Arrays.fill(dp[i], INF);

		for(int i = 0 ; i < n ; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++){
				int value = Integer.parseInt(st.nextToken());
				arr[i][j] = value;
			}
		}

		bw.write(tsp(0, 1) + "\n");
		br.close();
		bw.close();
	}

	private static int tsp(int node, int visit){
		// 모든 지점을 방문한 경우
		if(visit == (1 << n) - 1){
			if(arr[node][0] == 0) return INF;
			return arr[node][0];
		}

		// 이미 계산 했던 경우
		if(dp[node][visit] != INF)
			return dp[node][visit];

		for(int i = 0 ; i < n; i++){
			int next = visit | (1 << i);
			// i번 노드에 대해서 길이 없거나 방문한 경우
			if(arr[node][i] == 0 || (visit & (1 << i)) != 0) continue;
			System.out.println("node : " + node + ", visits : " + visit + ", i : " + i + ", next : " + next);

			dp[node][visit] = Math.min(dp[node][visit], tsp(i, next) + arr[node][i]);
		}

		return dp[node][visit];
	}
}

