package Programmers.Level2;

import java.util.Arrays;

public class LifeBoat {

	public static void main(String[] args) {

		int[] people = {
				25,25,25,25
		};

		int limit = 50 ;

		int answer = solution(people,limit);

		System.out.println(answer);


	}

	public static int solution(int[] people, int limit) {

		int answer = 0;

		Arrays.sort(people);

		// 최적은 가장 가벼운사람 + 가장 무거운사람을 먼저보내는것이다.
		int i = people.length-1;
		int j = 0 ;
		
		while ( i > j ) {
			
			if( people[i] + people[j] <= limit ) j++;
			
			i--;
			
			answer++;
		}
		
		if ( i==j ) answer++;
		
		return answer;
	}
}
