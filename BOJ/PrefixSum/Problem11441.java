package BOJ.PrefixSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11441 {
	
	static int[] nums;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n, m;
		
		n = Integer.valueOf(br.readLine());
		
		nums = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= n; i++) {
			nums[i] = nums[i - 1] + Integer.valueOf(st.nextToken());
		}
		
		m = Integer.valueOf(br.readLine());
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			sb.append(getSum(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken())));
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
	
	static int getSum(int a, int b) {
		return nums[b] - nums[a - 1];
	}

}
