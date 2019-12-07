package Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindSosuLevel2 {

	public static void main(String[] args) {

		String n = "011" ;

		int result = solution(n);

		System.out.println(result);

	}//main

	public static int solution(String numbers) {
		
		int answer = 0;

		String[] nums = numbers.split("");

		Arrays.sort(nums,Collections.reverseOrder());

		String arrayNumber ="";

		for ( String num : nums ) {
			arrayNumber+=num;
		}

		int max = Integer.valueOf(arrayNumber);

		int[] visits = new int[max+1];

		List<Integer> prime = new ArrayList<Integer>();

		// 소수 체크. 0이면 소수다.
		for ( int i = 2 ; i <= max; i++  ) {
			if ( visits[i] == 1 ) continue;
			for ( int j = 2*i; j <= max ; j+=i) {
				visits[j] = 1;
			}

			// 소수를 1차적으로 거른다. 흩어진 numbers에 해당되지 않는 값을 가지고있다면 처리대상이아니다.
			String[] iS = String.valueOf(i).split("");
			boolean possible = true;

			for ( int k = 0 ; k < iS.length; k++ ) {
				if ( !numbers.contains(iS[k])) {
					possible = false;
					break;
				}
			}
			// 2차적으로 거른다. 흩어진 수보다 더 많은 수를 가지고있는 경우를 체크한다.
			StringBuilder temp = new StringBuilder(numbers);
			
			for ( int r = 0 ; r < iS.length; r++ ) {
				int index = temp.indexOf(iS[r]);
				if ( index == -1 ) {
					possible = false;
					break;
				}
				else temp.setCharAt(index, '#');
			}
			if ( possible ) prime.add(i);
		}

		answer = prime.size();

		return answer;
	}

}//class
