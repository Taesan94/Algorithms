package Programmers.KAKAO_BLIND_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LockAndKey {

	public static void main(String[] args) {

		int[][] key = {
				{0, 0, 0}, 
				{1, 0, 0}, 
				{0, 1, 1}
		};

		int[][] lock = {
				{1, 1, 1}, 
				{1, 1, 0}, 
				{1, 0, 1}
		};

		boolean result = solution(key,lock);

		System.out.println(" result1: " + result);


	}

	static void print(int[][] arr) {
		System.out.println("### print ###");
		for (int[] a : arr ) {
			System.out.println(Arrays.toString(a));
		}
	}

	static int N, M, lockCnt = 0; 
	static List<Key> keyInfo;
	static int[][] lockInfo; 
	public static boolean solution(int[][] key, int[][] lock) {
		boolean answer = true;

		N = key.length;
		M = lock.length;
		lockInfo = lock;

		for (int x = 0; x < M; x++) {
			for (int y = 0; y < M; y++) {
				if (lock[x][y] == 0)
					lockCnt++;
			}
		}

		// 1. key를 회전
		for (int i = 0; i < 4; i++) {

			keyInfo = new ArrayList<>();
			key = rotate(key);

			for (int x = 0; x < M; x++) {
				for (int y = 0; y < M; y++) {
					if (lock[x][y] == 0) {
						if(isPossible(x, y)) {
							return true;
						}
					}
				}
			}
		}

		return answer;
	}

	static boolean isPossible(int x, int y) {

		// list의 크기만큼 for . 시작점 지정
		for (int i = 0; i < keyInfo.size(); i++) {
			Key start = keyInfo.get(i);
			int cnt = lockCnt - 1;
			// 빈 공간부터, 열쇠의 1의 자리를 확인.
			for (int j = 0; j < keyInfo.size(); j++) {
				if (i != j) {
					Key next = keyInfo.get(j);

					int nextX = next.x - start.x + x;
					int nextY = next.y - start.y + y;

					if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < M) {
						if (lockInfo[nextX][nextY] == 1)
							return false;
						cnt--;
					}
				}
			}
			if (cnt == 0)
				return true;
		}
		return false;
	}


	static int[][] rotate(int[][] key) {

		int[][] rotate = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				rotate[i][j] = key[N - 1 - j][i];
				if (rotate[i][j] == 1) {
					keyInfo.add(new Key(i,j));
				}
			}
		}
		return rotate;
	}

	static class Key {
		int x;
		int y;

		Key(int x, int y){
			this.x = x;
			this.y =y;
		}

		public String toString() {
			return x+", " + y +"\n";
		}
	}

}
