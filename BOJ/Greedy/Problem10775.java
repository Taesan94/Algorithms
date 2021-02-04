package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem10775 {
	
	public static void main(String[] args) throws Exception {
		solution2();
	}

	public static void solution1() throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int g = Integer.valueOf(br.readLine());
		int p = Integer.valueOf(br.readLine());

		int[] gates = new int[g + 1];
		int[] airplains = new int[p + 1];
		
		for (int i = 1; i <= p; i++) {
			airplains[i] = Integer.valueOf(br.readLine());
		}
		int cnt = 0;
		for (int i = 1; i <= p; i++) {
			int ap = airplains[i];
			if (gates[ap] == 0)
				gates[ap] = ap;
			else {
				int gate_own = gates[ap];
				boolean possible = false;
				for (int j = ap - 1; j >= 1; j--) {
					if (gates[j] == 0) {
						gates[j] = gate_own;
						gates[ap] = ap;
						possible = true;
						break ;
					}
				}
				if (!possible)
					break;
			}
			cnt++;
		}
		System.out.println(cnt);
	}
	
	static int getParent(int[] parent, int n) {
		if (parent[n] == n)
			return n;
		return parent[n] = getParent(parent, parent[n]);
	}
	static void solution2() throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int g = Integer.valueOf(br.readLine());
		int p = Integer.valueOf(br.readLine());
		
		int[] parent = new int[g + 1];
		
		int cnt = 0;
		// 현재 비행기를 가장 높은 수에 둔다.
		for (int i = 1; i <= g; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < p; i++) {
			// 현재 비행기의 위치를 하나씩 줄여간다. 
			// 4면은 3, 2, 1, 0 까지 기록하고, 한번 더 호출하면 0임.
			int curr = getParent(parent, Integer.valueOf(br.readLine()));
			if (curr != 0) {
				parent[curr] = curr - 1;
				cnt++;
			} else {
				break ;
			}
		}
		System.out.println(cnt);
	}
}
