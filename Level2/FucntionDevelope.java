package Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FucntionDevelope {

	public static void main(String[] args) {

		int[] progresses = {
				93,93,93
		};

		int[] speeds = {
				1,1,1
		};

		int[] answer = solution(progresses,speeds);

		System.out.println(Arrays.toString(answer));

	}//main

	public static int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};

		Queue<Integer> periods = new LinkedList<Integer>();

		// 평균 소요기간을 구해준다.
		for ( int i = 0 ; i < speeds.length; i ++ ) {

			int value = (100-progresses[i]) / speeds[i];
			if ( (100-progresses[i]) % speeds[i] != 0 ) value++;

			periods.add(value);
		}
		
		List<Integer> result = new ArrayList<Integer>();
		
		while( !periods.isEmpty() ) {

			int cnt = 1 ;

			int period = periods.poll();

			while( !periods.isEmpty() && period >= periods.peek()) {
				periods.poll();
				cnt++;
			}
			
			result.add(cnt);
		}
		
		answer = new int[result.size()];
		
		for ( int i = 0 ; i < answer.length; i++ ) {
			answer[i] = result.get(i);
		}

		return answer;
	}

}//class
