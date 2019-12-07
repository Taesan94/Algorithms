package Programmers.Level1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Findkim {

	public static void main(String[] args) {

		String[] s = {
				"Jane" , "Kim"
		};
		
		String result = solution2(s);

		System.out.println(result);

	}//main

	public static String solution(String[] seoul) {
		

		for ( int i = 0 ; i < seoul.length; i++ ) {
			if ( seoul[i].equals( "Kim" )) return "김서방은 " + i +"에 있다";
		}

		return null ;
	}
	
	public static String solution2(String[] seoul) {
		
		int index = Arrays.asList(seoul).indexOf("Kim");
		
		return "김서방은 "+ index +"에 있다";
		
	}
	
	

}//class
