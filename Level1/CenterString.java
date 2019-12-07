package Programmers.Level1;

public class CenterString {

	public static void main(String[] args) {

		String answer = solution("abcde");
		String answer2 = solution("qwer");
		
		System.out.println(" answer : " + answer);
		System.out.println(" answer2 : " + answer2);
		
	}//main

	public static String solution(String s) {
		String answer = "";
		
		int centerIndex = s.length()/2;
		
		if (s.length() % 2 == 0 ) {
			answer = s.substring(centerIndex-1,centerIndex+1);
		}else {
			answer = s.substring(centerIndex,centerIndex+1);
		}
		
		
		return answer;
	}


}//class
