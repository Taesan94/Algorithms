package BOJ.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
 * LCA1의 풀이보다 경우의 수가 더 많다.
 * 
 * 이 경우 빠르게 처리하기위해 각 정점의 2^N번째 노드만 기억하도록한다. 
 * => A라는 노드의 2^3번째 조상의 2^3번째 조상을 알면, A라는 노드의 2^4 조상을 알 수 있다. => OK
 * => A라는 노드의 2^3번째 조상을 알면, A라는 노드의 2^4조상을 알 수 있다.
 * https://taesan94.tistory.com/183?category=331916
 * 
 */
public class Problem11438_LCA2 {

	static int MAX = 17; // 주어진 수 100,000으로 갈 수 있는 최대 깊이는 2^17(131,072) 까지이다.
	static int[] depth; // 각 정점의 깊이를 기록한다.
	static int[][] parents; // 각정점의 2^n깊이에 있는 부모노드를 기록한다.
	static List<List<Integer>> tree = new ArrayList<>();
	static int N, M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());

		depth = new int[N + 1];
		parents = new int[N + 1][MAX + 1];

		init();

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.valueOf(st.nextToken());
			int v2 = Integer.valueOf(st.nextToken());

			tree.get(v1).add(v2);
			tree.get(v2).add(v1);
		}

		dfs(1);

		for (int j = 0; j <= MAX; j++) {
			for (int i = 1; i <= N; i++) {
				if(parents[i][j] != -1) {
					parents[i][j + 1] = parents[parents[i][j]][j];
				}
			}
		}

		M = Integer.valueOf(br.readLine());

		for (int i = 0; i < M; i++) {
			findSameParent(br.readLine());
		}
	}

	static void init() {

		for (int i = 0; i <= N; i++) {
			tree.add(new ArrayList<>());
		}

		Arrays.fill(depth, -1);
		depth[1] = 0;

		for (int[] parent : parents) {
			Arrays.fill(parent, -1);
		}
	}


	/*
	 * dfs를 통해서 root부터 시작하여
	 *   - 각 정점의 depth와
	 *   - 각 정점의 2^n의 부모를 기록한다.
	 */
	static void dfs(int parent) {

		List<Integer> childs = tree.get(parent);

		for (int child : childs) {
			if (depth[child] == -1) {
				depth[child] = depth[parent] + 1;
				parents[child][0] = parent;
				dfs(child);
			}
		}
	}

	static void findSameParent(String input) {

		StringTokenizer st = new StringTokenizer(input);

		int moreDeep = Integer.valueOf(st.nextToken()); // 더 큰수가오도록... 즉 조상에서 더 깊은....
		int lessDeep = Integer.valueOf(st.nextToken()); // 더 작은수가오도록.. 즉 조상에서 더 가까운(얕다..)..

		if (depth[moreDeep] < depth[lessDeep]) {
			int temp = lessDeep;
			lessDeep = moreDeep;
			moreDeep = temp;
		}

		int hDiff = depth[moreDeep] - depth[lessDeep];
		int i = 0;
		
		// 두 정점의 깊이를 맞춰준다. 더 깊은곳에서 --> 더 얕은곳으로 올려준다.
		// 2^n 만큼씩 올리는 것이다. (아래는 코드는 이해안되면 일단 공식처럼..(디버깅하면 논리적이다..))
		while (hDiff != 0) {
			if (hDiff % 2 != 0) {
				moreDeep = parents[moreDeep][i]; // 짝수의 경우에도 마지막 1일때는 무조건 타게되있다.. 그 때의 2^i 의 정점으로 바뀐다. 
			}
			hDiff /= 2; // 깊이를 높여 나가기
			i++; // 2^i을 의미한다... 2^i만큼 높여간다.
		}

		// 깊이를 맞추지 못했다면..
		// 재 계산된 moreDeep과 lessDeep정점의 2^MAX 깊이부터 2^0 까지 비교한다.
		if (moreDeep != lessDeep) {
			for (int j = MAX; j >= 0; j--) {
				if (parents[moreDeep][j] != -1 && parents[moreDeep][j] != parents[lessDeep][j]) { // 해당 깊이에 정점이 존재하면서, 두 정점이 같지않을 때.. 정점을 낮춰간다.
					moreDeep = parents[moreDeep][j];
					lessDeep = parents[lessDeep][j];
				}
			}
			// 모든 for문이 끝났을 때의 정점에 2^0위치에 있는 정점이 LCA가 된다.
			moreDeep = parents[moreDeep][0];
		}
		System.out.println(moreDeep);
	}

}
