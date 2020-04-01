package Programmers.Level2;

import java.util.Arrays;

public class LifeBoat {

	public static void main(String[] args) {

		int[] people = {
				70,50,80,50
		};

		int limit = 100 ;

		int answer = solution2(people,limit);

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
	
	public static int solution2(int[] people, int limit) {

		int answer = 0;

		Arrays.sort(people);

		// 최적은 가장 가벼운사람 + 가장 무거운사람을 먼저보내는것이다.
		// 무거운사람을 기준으로 보내줘야 한다.
		int i = 0 ;
		int j = people.length-1 ;
		
		while ( i < j ) {
			// 한명을 더 같이 태우는 경우.
			if ( people[i] + people[j] <= limit ) i++;
			// 두명 태울 수 없다면 무거운사람을 먼저 보트에 태워서 보낸다.
			j--;
			answer++;
		}
		
		// 종료시점에 i와 j의 위치가 동일하다면 해당 index에 남아있는 사람은 처리되지않았으므로, 혼자 보내준다.
		if ( i==j ) answer++;
		
		return answer;
	}
}
