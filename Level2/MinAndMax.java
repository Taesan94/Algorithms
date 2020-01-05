package Programmers.Level2;

import java.util.Arrays;

public class MinAndMax {

	public static void main(String[] args) {

		String s = "-1 -1";
		
		String answer = solution(s);
		
		System.out.println(answer);
	}

	public static String solution(String s) {
		
		String[] arrS = s.split(" ");
		
		int[] arrInt = new int[arrS.length];
		
		int i = 0 ;
		
		for ( String num : arrS ) {
			arrInt[i] = Integer.valueOf(num);
			i++;
		}
		
		Arrays.sort(arrInt);

		return arrInt[0]+" "+arrInt[arrInt.length-1];
	}

}
