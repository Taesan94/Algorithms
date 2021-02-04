package BOJ.Etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProgrammersTest3 {

	public static void main(String[] args) {
		
		int n = 5;
		
		solution(n);
	}
	
	static int solution(int n) {
		int answer = 0;
		
		// 총 갯수는 팩토리얼	
		int total = 0;
		for(int i = 1; i <= n; i++) {
			total += i;
		}
		
		int[][] box = new int[n+1][n+1];
		
		// X증가 
		// Y증가 
		// X감소 
		// Y감소
		// 증감 범위는 n--
		
		int seq = n;
		int stopIdx = 0;
		int num = 1;
		
		for (int i = 0; i < seq; i++) {
			box[i][stopIdx] = num++;
		}
		
		seq--;
		stopIdx = seq;
		
		for (int i = 1; i <= seq; i++) {
			box[stopIdx][i] = num++;
		}
		
		seq--;
		
		for (int i = 0; i < seq; i++) {
			box[stopIdx - i][stopIdx] = num++;
		}
		
		seq--;
		stopIdx = seq;
		
		for (int i = 0; i < seq; i++) {
			box[stopIdx][stopIdx - i] = num++;
		}
		
		

		for (int[] d : box) {
			System.out.println(Arrays.toString(d));
		}
		
		
		
		
		return answer;
	}
	
	static void temp(int n, int i, int j) {
		
		
		
	}

}
