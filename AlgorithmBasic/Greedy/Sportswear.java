package Programmers.AlgorithmBasic.Greedy;

import java.util.Arrays;

public class Sportswear {

	public static void main(String[] args) {
		
		int n = 3;
		
		int[] lost = {
				3
		};
		
		int[] reserve = {
				1
		};
		
		int result = solution(n,lost,reserve);
		
		System.out.println(" result : " + result );

	}

	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = n;

		// 학생들의 여분을 기록한다.
		int[] students = new int[n+1];
		
		Arrays.fill(students, 1);

		for( int i=0; i<n; i++ ) {

			int lostStu = 0;
			int reserveStu = 0;

			if(i<lost.length) {
				lostStu = lost[i];
				students[lostStu]--;
			}

			if(i<reserve.length) {
				reserveStu = reserve[i];
				students[reserveStu]++;
			}
		}
		
		System.out.println(" Before : " + Arrays.toString(students));
		
		// 없는 학생이, 왼쪽 학생껄 먼저빌려보고, 얘도없으면 오른쪽껄빌린다.
		for( int i=1; i<students.length; i++ ) {
			
			int amount = students[i];
			
			int left = 0;
			int right = 0 ;
			// 체육복이 없는학생.
			if(amount == 0) {
				
				left = i-1;
				right = i+1;
				
				if( left > 0 && students[left]==2) {
					students[i]=1;
					students[left]=1;
					continue;
				}
				
				if( right < students.length && students[right]==2 ) {
					students[i]=1;
					students[right]=1;
					continue;
				}
				answer--;
			}
		}
		
		System.out.println(" After : " + Arrays.toString(students));
		
		return answer;
	}

}
