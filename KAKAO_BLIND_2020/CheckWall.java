package Programmers.KAKAO_BLIND_2020;

import java.util.Arrays;

public class CheckWall {

	public static void main(String[] args) {

		int n = 12;

		int[] weak = {
				// 1, 5, 6, 10
				1, 3, 4, 9, 10
				// 0, 100
		};

		int[] dist = {
				// 1, 2, 3, 4
				3, 5, 7
				//1, 1
		};

		int result = solution(n, weak, dist);

		System.out.println("result : " + result );

	}

	private static int n, num = 0; 
	private static boolean finish = false; 
	private static int[] weak, dist, choice; 
	private static int[][] rotateWeak; 

	public static int solution(int intputN, int[] inputWeak, int[] inputDist) {

		n = intputN; 
		weak = inputWeak; 
		dist = inputDist; 
		setWeak(); 

		for (int i = 1; i <= dist.length; i++) { 
			num = i; 
			choice = new int[i];
			permutation(0, new boolean[dist.length]);

			if (finish) 
				return i; 
		}
		return -1;
	} 

	public static void permutation(int depth, boolean[] visit) { 

		if (finish) 
			return;

		if (depth == num) {
			check(); 
			return; 
		}

		for (int i = 0; i < dist.length; i++) { 
			if (!visit[i]) { 
				choice[depth] = dist[i]; 
				visit[i] = true; 
				permutation(depth + 1, visit); 
				visit[i] = false; 
			} 
		} 
	} 

	public static void check() { 
		for (int[] weak : rotateWeak) { 
			int idx = 0;
			int start = 0; 
			boolean[] visit = new boolean[weak.length]; 
			while (idx != num) { 
				int distance = choice[idx++]; 
				for (int i = start; i < weak.length; i++) { 
					if (weak[i] > weak[start] + distance) {
						start = i;
						break; 
					}
					visit[i] = true; 
				} 
			} 
			if (isFinish(visit)) { 
				finish = true; 
				return; 
			} 
		} 
	} 

	public static boolean isFinish(boolean[] visit) { 
		for (boolean bool : visit) { 
			if (!bool) return false; 
		} 
		return true; 
	} 

	public static void setWeak() {

		int len = weak.length; 
		rotateWeak = new int[len][len]; 

		for (int i = 0; i < len; i++) { 
			rotateWeak[i] = rotate(i); 
		}
	} 

	public static int[] rotate(int idx) { 
		int len = weak.length; 
		int[] result = new int[len]; 
		for (int i = 0; i < len; i++) { 
			result[i] = weak[(i + idx) % len];

			if (i + idx >= len) {
				result[i] += n;
			}
		} 
		return result; 
	}
}