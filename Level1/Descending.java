package Programmers.Level1;

import java.util.Arrays;
import java.util.Collections;

public class Descending {

	public static void main(String[] args) {

		String s = "Zbcdefg";

		String result = solution(s);

		System.out.println(result);

	}//main
	
	public static String solution(String s) {
		String answer = "";
		
		String[] datas = s.split("");
		
		Arrays.sort(datas , Collections.reverseOrder());
		
		for ( String wk : datas ) {
			answer+=wk;
		}
		
		return answer;
	}

}//class
