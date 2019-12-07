package Programmers.Level2;

import java.util.Arrays;
import java.util.Collections;

public class MakeBigNumber {

	public static void main(String[] args) {

		String number ="4177252841";
		int k = 4;

		String answer = solution2( number,k );

		System.out.println(answer);

	}//main

	public static String solution(String number, int k) {

		StringBuilder answer = new StringBuilder();

		// 최종 return값의 길이
		int size = number.length()-k;
		int cnt = size;

		StringBuilder subNum = new StringBuilder();
		StringBuilder numberBuilder = new StringBuilder(number);

		int maxIndex = 0 ;

		// 한글자씩 붙여 나간다.
		while ( answer.length() !=  cnt ) {

			// n번째 글자가 될 수 있는 후보군들.
			subNum = new StringBuilder(numberBuilder.substring( maxIndex, numberBuilder.length()-(size-1) ));

			//가장 큰 값을 찾아준다.
			String[] splitNum = subNum.toString().split("");

			Arrays.sort(splitNum,Collections.reverseOrder());

			//자릿수대로 가장 큰 값을 넣어준다.
			answer.append(splitNum[0]);

			//다시 문자열을 잘라준다.
			maxIndex = numberBuilder.indexOf(splitNum[0]);

			for ( int i = 0 ; i <= maxIndex; i++ ) {
				numberBuilder.setCharAt(i, '#');
			}

			// 구할 자리수의 범위도 점점 줄여나간다.
			size--;
		}

		return answer.toString();
	}

	public static String solution2(String number, int k) {
		
		StringBuilder answer = new StringBuilder();
		
		char[] numbers = number.toCharArray();
		
		// 가장 큰 값을 가지고있는 index를 기억한다.
		int index = 0 ;
		
		// 1차 loop 만들어야 하는 글자 수 만큼 처리한다.
		// i번째 자릿수의 범위를 결정하는대 i값이 쓰인다.
		for ( int i = 0 ; i < number.length()-k; i++ ) { 
			
			// 자리수 별로 max의 초기 값을 주기 위함이다.
			char max = '0';
			// i번째 자릿수가 올 수 있는 범위에서 최댓 값을 찾는다.
			for ( int j = index; j <= i+k; j++ ) {
				if( numbers[j] > max ) {
					max = numbers[j];
					index = j+1;
				}
			}
			// 범위에서 찾은 max 값을 answer에 apeend 해준다.
			answer.append(max);
		}
		return answer.toString();
	}


}//class
