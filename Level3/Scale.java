package Programmers.Level3;

import java.util.Arrays;

public class Scale {

	public static void main(String[] args) {

		int[] weight = {
				//100,101
				1,2,3,3,10
		};

		int result = solution(weight);

		System.out.println(" result : " + result );

	}

	public static int solution(int[] weight) {
		int total = 0 ;

		Arrays.sort(weight);

		total = weight[0];
		
		if ( total > 1 ) return 1;
		
		for ( int i = 1 ; i < weight.length; i++ ) {
			if(total+1 >= weight[i] ) total += weight[i];
			else break;
		}
		return total+1;
	}


}
