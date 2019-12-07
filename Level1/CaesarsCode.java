package Programmers.Level1;

public class CaesarsCode {

	public static void main(String[] args) {

		System.out.println( " 소문자 : " + (int)'a' + "~ "+ (int)'z') ;
		System.out.println( " 대문자 : " + (int)'A' + "~ "+ (int)'Z') ;
		
		String s = "a B z";
		int n = 1 ;
		String result = solution(s,n);
		
		System.out.println(result);
		
	}//main

	public static String solution(String s, int n) {

		String answer = "";

		char[] words = s.toCharArray();
		
		for ( char w : words ) {

			int intW = w;	    
			
			if ( Character.isLowerCase(w)) { // 소문자
				intW+=n;
				if ( intW > 122 ) intW = ( intW % 123 ) + 97;
				
			}else if ( Character.isUpperCase(w) ) { // 대문자
				intW+=n;
				if ( intW > 90 ) intW = ( intW % 91 ) + 65;
			}
			
		    answer += (char)intW;
		}


		return answer;
	}


}//class
