package Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FunctionDevelope {

	public static void main(String[] args) {

		int[] progresses = {
				//93,30,55	
				93,55,30
		};

		int[] speeds = {
				//1,30,5
				1,5,30
		};

		int[] result = solution(progresses, speeds);

		System.out.println(Arrays.toString(result));

	}

	public static int[] solution(int[] progresses, int[] speeds) {

		int len = progresses.length;
		Queue<Integer> q = new LinkedList<>();
		
		for( int i=0; i<len; i++ ) {
			int day = (100-progresses[i])/speeds[i];
			day = (100-progresses[i])%speeds[i]==0 ? day : day+1;
			q.add(day);
		}
		
		List<Integer> result = new ArrayList<>();
		
		while( !q.isEmpty() ) {
			
			int buildP = q.poll();
			
			int cnt = 1;
			
			while ( !q.isEmpty() && q.peek() <= buildP ) {
				q.poll();
				cnt++;
			}
			result.add(cnt);
		}
		
		int i =0;
		int[] answer = new int[result.size()];
		for( int n : result ) {
			answer[i++] = n;
		}
		
		return answer;
	}
}
