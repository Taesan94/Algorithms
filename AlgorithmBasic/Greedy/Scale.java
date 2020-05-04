package Programmers.AlgorithmBasic.Greedy;

import java.util.Arrays;

public class Scale {

	public static void main(String[] args) {
		
		int[] weight= {
				3,1,6,2,7,30,1
		};
		
		int result = solution(weight);
		
		System.out.println(" result : " + result );
		
	}
	
	public static int solution(int[] weight) {
		int answer = 0 ;
		
		// n개의 추로 측정 할 수 없는 양의 정수 무게 중 최솟 값..
		
		// 우선, 정렬.
		Arrays.sort(weight);
		
		answer = weight[0];
		// 가장 작은 값이 1보다 크다면, 1이 측정할 수 없는 최솟 값이 된다.
		if(answer > 1) return 1;
		
		// 추의 무게를 더해간다.
		
		for( int i=1; i<weight.length; i++ ) {
			// 현재 값이 answer+1한 값보다 작거나 같으면 누적합을 계산해준다.
			if(weight[i] <= answer+1) answer+=weight[i];
			else break;
			// 만들 수 없는 최소 값.
		}
		
		return answer+1 ;
	}
}
