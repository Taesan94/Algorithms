package Programmers.Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SameNumberHate {

	public static void main(String[] args) {

		int[] arr = { 4,4,4,4,4 } ;

		int[] result = solution(arr);

		System.out.println(Arrays.toString(result));


	}//main

	public static int[] solution(int []arr) {
		int[] answer = {};

		List<Integer> ans = new ArrayList<Integer>();
		
		ans.add(arr[0]);

		for ( int i = 1 ; i < arr.length; i++ ) {

			if ( !ans.isEmpty() ) {

				if( arr[i] == ans.get(ans.size()-1)) {
					continue;
				}else {
					ans.add(arr[i]);
				}
			}
		}

		answer = new int[ans.size()];

		for ( int i = 0 ; i < answer.length; i++ ) {
			answer[i] = ans.get(i);
		}

		return answer;
	}


}//class
