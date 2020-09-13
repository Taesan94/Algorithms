package Programmers.KAKAO_BLIND_2019;

import java.util.Arrays;

public class CandidateKey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int N;
	
	public static int solution(String[][] relation) {
		int answer = 0;
		
		N = relation.length;
		



		return answer;
	}

	private static void powerset(String[] arr, int[] flag, int index ) {

		if(index == arr.length) {

			return;
		}


		// 현재요소를 포함하는경우
		flag[index] = 1;
		powerset(arr,flag,index+1);

		// 현재요소를 포함하지 않는경우
		flag[index] = 0;
		powerset(arr,flag,index+1);

	}

}
