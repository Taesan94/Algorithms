package Programmers.Level1;

public class WaterMellon {

	public static void main(String[] args) {

		int n = 10000 ;

		String result = solution(n);

		System.out.println(result);

	}//main

	public static String solution(int n) {
		String answer = "";

		String[] watermellon = { "박" ,"수" };
		
		for ( int i = 1 ; i <= n ; i ++ ) {
			answer += watermellon[i%2];
		}
		
		return answer;
	}
}//class
