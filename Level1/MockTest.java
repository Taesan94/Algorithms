package Programmers.Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockTest {

	public static void main(String[] args) {

		int[] answers = {2,1,2,3,2};

		int[] answer = solution(answers);

		System.out.println(Arrays.toString(answer));

	}//main

	public static int[] solution(int[] answers) {

		int[][] mathGiveUp = {
				{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}
		};

		int[] result = new int[4];

		for ( int i = 0 ; i < answers.length; i ++ ) {

			int man1 = mathGiveUp[0][ ( i % mathGiveUp[0].length) ];
			int man2 = mathGiveUp[1][ ( i % mathGiveUp[1].length) ];
			int man3 = mathGiveUp[2][ ( i % mathGiveUp[2].length) ];

			if ( man1 == answers[i] ) result[1] += 1 ;
			if ( man2 == answers[i] ) result[2] += 1 ;
			if ( man3 == answers[i] ) result[3] += 1 ;

		}

		Map<Integer,List<Integer>> m = new HashMap<Integer,List<Integer>>();


		for ( int i =1; i <4; i++ ) {
			if ( m.get(result[i]) == null ) {
				m.put( result[i] , new ArrayList<Integer>());
				m.get(result[i]).add(i);
			}else {
				m.get(result[i]).add(i);
			}
		}

		Arrays.sort(result);

		List<Integer> end = m.get(result[3]);

		int[] answer = new int[end.size()];

		for ( int i = 0 ; i < end.size(); i ++ ) {
			answer[i] = end.get(i);
		}

		return answer;
	}
	
	// 마지막에 결과 출력부분 다시.
	public static int[] solution2(int[] answers) {

		int[][] mathGiveUp = {
				{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}
		};

		int[] result = new int[4];

		for ( int i = 0 ; i < answers.length; i ++ ) {

			int man1 = mathGiveUp[0][ ( i % mathGiveUp[0].length) ];
			int man2 = mathGiveUp[1][ ( i % mathGiveUp[1].length) ];
			int man3 = mathGiveUp[2][ ( i % mathGiveUp[2].length) ];

			if ( man1 == answers[i] ) result[1] += 1 ;
			if ( man2 == answers[i] ) result[2] += 1 ;
			if ( man3 == answers[i] ) result[3] += 1 ;

		}
		
		int max = Math.max( result[1], Math.max( result[2], result[3]));
		
		if ( max == result[1] && max == result[2] && max == result[3]) {
			return new int[] {1,2,3};
		}
		else if ( max== result[1] && max==result[2] ) return new int[] {1,2};
		else if ( max== result[2] && max==result[3] ) return new int[] {2,3};
		else if ( max== result[1] && max==result[3] ) return new int[] {1,3};
		else if ( max== result[1] ) return new int[] {1};
		else if ( max== result[2] ) return new int[] {2};

		return new int[] {3};
	}
}//class
