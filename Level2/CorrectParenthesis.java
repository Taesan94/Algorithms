package Programmers.Level2;

public class CorrectParenthesis {

	public static void main(String[] args) {
		String s = "(()(";
		
		boolean result = solution(s);
		
		System.out.println(result);
		
	}//main

    static boolean solution(String s) {
        boolean answer = true;
        
        char[] arrayS = s.toCharArray();
        
        int result = 0 ;
        
        for ( char parenthesis : arrayS ) {
        
        	if ( parenthesis == '(' ) {
        		result++;
        	}else if ( parenthesis == ')' ) {
        		result--;
        	}
        	
        	if ( result < 0 ) return false;
        }
        
        if ( result > 0 ) return false;
        
        return answer;
    }
	
}//class
