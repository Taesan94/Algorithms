package Programmers.Level1;

public class ReplaceAllSample {

	static int cnt = 0;
	
	public static void main(String[] args) {

		String phoneNum = "027778888" ;
		
		String answer =solution( phoneNum );

		System.out.println(answer);


	}//main

	  public static String solution(String phone_number) {
	      
	      return phone_number.substring(0,phone_number.length()-4).replaceAll(".", "*")+phone_number.substring(phone_number.length()-4,phone_number.length());

	  }

}//class
