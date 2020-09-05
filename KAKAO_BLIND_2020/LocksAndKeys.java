package Programmers.KAKAO_BLIND_2020;

import java.util.ArrayList;
import java.util.List;

public class LocksAndKeys {

	public static void main(String[] args) {
		int[][] key = {
				{1, 0, 0}, 
				{0, 0, 0}, 
				{0, 0, 1}
		};

		int[][] lock = {
				{0, 1, 1}, 
				{1, 0, 1}, 
				{1, 1, 1}
		};

		boolean result = solution(key,lock);
		
		System.out.println(" result1: " + result);

	}

	static int N;
	static int M;
	static int emptyCnt;
	static List<Key> keyList;

	public static boolean solution(int[][] key, int[][] lock) {

		N = key.length;
		M = lock.length;

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				if(lock[i][j] == 0) {
					emptyCnt++;
				}
			}
		}		
				
		if (emptyCnt == 0)
			return true;

		// 90도씩 key를 회전하면서
		for (int i = 0; i < 4; i++) {

			key = rotate(key);
			keyList = new ArrayList<>();
			
			for (int j=0; j < N; j++) {
				for (int k=0; k < N; k++) {
					if(key[j][k] == 1) {
						keyList.add(new Key(j, k));
					}
				}
			}
			
			if (keyList.size() < 1) 
				return true;
			
			if(isPossible(lock)) {
				return true;
			};
		}
		return false;
	}

	static boolean isPossible(int[][] lock) {

		for (int i = 0; i < M; i++ ) {
			for (int j = 0; j < M; j++ ) {
				if (lock[i][j] == 0) {
					if(possibleCheck(lock, i, j))
						return true;
				}
			}
		}
		return false;
	}
	
	static boolean possibleCheck(int[][] lock, int i, int j) {
		
		for (int k = 0; k < keyList.size(); k++) {
			boolean possible = true;
			int cnt = 1;
			// 해당 공간을 k번 째 돌기로 채운다.
			Key curr = keyList.get(k);
			for (int r = 0; r < keyList.size(); r++) {
				if (k != r) {
					Key next = keyList.get(r);

					int nextX = i - (curr.x - next.x);
					int nextY = j - (curr.y - next.y);

					if ((nextX >= 0 && nextX < M) && (nextY >= 0 && nextY < M)) { //돌기가 범위 안에 있을 때는
						if (lock[nextX][nextY] == 1) {// 돌기끼리 부딛혀서는 안 됨.
							possible = false;
							break;
						}
						cnt++;
					}
				}
			}
			if (cnt == emptyCnt && possible) {
				return true;
			}
		}
		return false;
	}
	

	static int[][] rotate(int[][] key) {
		
		int[][] rotate = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				rotate[i][j] = key[N - 1 - j][i];
			}
		}
		return rotate;
	}

	static class Key {
		int x;
		int y;

		Key(int x, int y){
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "("+x+", " + y +")";
		}
	}



}
