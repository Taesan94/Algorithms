package Programmers.Level2;

import java.util.Arrays;

public class Carpet {

	public static void main(String[] args) {

		int brown = 24 ;
		int red = 24 ;

		int[] answer = solution( brown , red );

		System.out.println(Arrays.toString(answer));


	}//main

	public static int[] solution(int brown, int red) {
		int[] answer = new int[2];

		for ( int i = red; i > 0 ; i-- ) {

			int possibleBrown = 0 ;

			if ( red % i == 0 ) {
				int width = i;
				int height = red / i ;

				if ( width >= height ) possibleBrown = width*2 + height*2 + 4;
				else return null;
				
				if ( possibleBrown == brown ) {
					answer[0] = width+2;
					answer[1] = height+2;
					break;
				}
			}
		}

		return answer;
	}

}//class
