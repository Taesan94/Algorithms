package BOJ.PermutationAndCombination;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem15649 {
	
	static int start = 0;
	static int N, M;
	static int[] nums;
	static boolean[] pos;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		StringTokenizer st = new StringTokenizer(scan.nextLine());
		
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());

		nums = new int[M];
		pos = new boolean[N + 1];
		// N개의 요소를 가지고, 수열을 만든다.
		
		// 0번째 숫자부터, 채워나가기.
		permutation(0);
		
	}
	
	static void permutation(int idx) {
		
		if (idx == M) {
			
			// 출력하기
			for (int i = 0; i < M; i++) {
				System.out.print(nums[i]);
				if (i != M - 1) {
					System.out.print(" ");
				}
			}
			System.out.println();
			return ;
		}
		
		// 1 ~ N 까지의 숫자
		for (int i = 1; i <= N; i++) {
			if (pos[i])
				continue;
			pos[i] = true; // 방문
			nums[idx] = i;
			permutation(idx + 1);
			pos[i] = false;
		}
	}

}
