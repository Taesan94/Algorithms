package Programmers.Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DividedArray {

	public static void main(String[] args) {

		int[] arr = { 3,2,6 } ;

		int divisor = 10 ; 

		int[] result = solution(arr , divisor );

		System.out.println(Arrays.toString(result));


	}//main

	public static int[] solution(int[] arr, int divisor) {
		
		int[] answer = { -1 };

		List<Integer> result = new ArrayList<Integer>();

		for ( int i = 0 ; i < arr.length; i++ ) {
			if ( arr[i]%divisor == 0 ) result.add(arr[i]);
		}
		
		if ( result.isEmpty() ) return answer;
		
		Collections.sort(result);
		
		answer = new int[result.size()];
		
		for ( int i = 0 ; i < result.size(); i++ ) {
			answer[i] = result.get(i);
		}

		return answer;
	}


}//class
