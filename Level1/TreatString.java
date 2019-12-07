package Programmers.Level1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TreatString {

	public static void main(String[] args) {

		String s = "abcd";

		boolean result = solution2(s);

		System.out.println(result);

	}//main

	public static boolean solution(String s) {

		boolean answer = true;

		if ( s.length() == 4 || s.length() == 6 ) {

			Pattern p = Pattern.compile("(^[0-9]*$)");

			Matcher m = p.matcher(s);

			answer = m.find();
		} else return false;

		return answer;
	}
	
	public static boolean solution2( String s ) {
		
		if ( s.length() == 4 || s.length() == 6 ) {
			
			try {
				int a = Integer.parseInt(s);
				return true ;
			}catch(NumberFormatException e ) {
				return false;
			}
		}else return false;
		
	}

}//class
