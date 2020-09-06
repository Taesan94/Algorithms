package Programmers.KAKAO_BLIND_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColumnsAndBeams {

	public static void main(String[] args) {

		int n = 5;

		int[][] build_frame ={
				 {1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}
				// {0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}
				// {0,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1},{2,0,0,1}
		};

		int[][] result = solution(n, build_frame);

		for(int i = 0; i < result.length; i ++) {
			System.out.println(Arrays.toString(result[i]));
		}
	}

	static int[][] columns;
	static int[][] beams;

	public static int[][] solution(int n, int[][] build_frame) {
		// n + 1 * n + 1 행렬 생성... 기록한다..
		// 1은 기둥이 설치되어 있음을 나타냄        		
		// 2는 보가 설치되어 있음을 나타냄
		columns = new int[n + 3][n + 3];
		beams = new int[n + 3][n + 3];

		// 명령어를 수행해도 되는지 ???        
		// 주어진 조건에 맞는지 확인하여서 .. 
		// 가능하다면 기록하기.

		// 0 = 기둥 , 1 = 보 // 0 = 삭제 , 1 = 설치
		for(int[] instruction : build_frame) {

			int x = instruction[0] + 1; // -->
			int y = instruction[1] + 1; // 상단
			int obj = instruction[2];
			int act = instruction[3];

			if (act == 0) { // 삭제
				if(obj == 0) {
					columns[x][y] = 0;
					if(!isDelete(n)) {
						columns[x][y] = 1;
					}
				} else {
					beams[x][y] = 0;
					if(!isDelete(n)) {
						beams[x][y] = 1;
					}
				}
			} else { // 설치
				if(isPossible(x, y, n, obj)) {
					if(obj == 0) {
						columns[x][y] = 1;
					} else {
						beams[x][y] = 1;
					}
				};

			}
		}

		List<int[]> list = new ArrayList<>();

		for (int i = 1; i <= n + 1; i++) {
			for (int j = 1; j <= n + 1; j++) {
				if (columns[i][j] == 1) {
					list.add(new int[] {i - 1, j - 1, 0});
				}
				if (beams[i][j] == 1) {
					list.add(new int[] {i - 1, j - 1, 1});
				}
			}
		}

		int[][] answer = new int[list.size()][3];

		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		Arrays.sort(answer, (o1, o2) -> {
			int result = o1[0] - o2[0];

			if(result == 0)
				result = o1[1] - o2[1];

			if(result == 0)
				result = o1[2] - o2[2];

			return result;
		});
		

		return answer;
	}

	static boolean isPossible(int x, int y, int n, int obj) {

		int l = x - 1;
		int r = x + 1;
		int down = y - 1;

		if (obj == 0) {
			return beams[l][y] == 1 || beams[x][y] == 1 || columns[x][down] == 1 || y == 1;
		} else // 보
			return columns[x][down] == 1 || columns[r][down] == 1 || ( beams[l][y] == 1 &&  beams[r][y] == 1);
			
	}

	static boolean isDelete(int n) {
	       for(int i = 1 ; i <= n + 1; i++){
	            for(int j = 1 ; j <= n + 1; j++){
	                if(columns[i][j] == 1 && !isPossible(i, j, n, 0) ){
	                    return false;
	                }
	                if(beams[i][j] == 1 && !isPossible(i, j, n, 1) ){
	                    return false;
	                }
	            }
	        }
		return true;
	}
}