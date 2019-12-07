package Programmers.Level1;

public class StrangeString {

	public static void main(String[] args) {

		String s = "ab a ";
		String result = solution(s);

		System.out.println(result);

	}//main

	public static String solution(String s) {
		String answer = "";
		
		// -1 안하면 공백도 사라져버린다.
		String[] words = s.split(" ",-1);

		for ( int i = 0 ; i < words.length; i ++ ){

			String word = words[i];

			String[] splitWord = word.split("");

			for ( int j = 0 ; j < splitWord.length; j++ ){              

				if ( j % 2 == 0 ){ // 짝수면 대문자로
					answer+=splitWord[j].toUpperCase();
				}else { // 홀수면 소문자로
					answer+=splitWord[j].toLowerCase();
				}              
			}   

			if ( i !=  words.length-1 ) answer += " ";          
		}

		return answer;
	}


}//class
