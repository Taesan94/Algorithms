package Programmers.Level1;

public class TwoIntSum {

	public static void main(String[] args) {

		int a = 3;
		int b = 5; 

		long result = solution( a,b );

		System.out.println(result);	

	}//main

	  public static long solution(int a, int b) {
		  
	      long answer = 0;
	      
	      int max = (a >= b) ? a : b ;
	      
	      int min = ( a < b )? a : b ;
	      
	      for ( int i = min ; i <= max ; i++ ){
	          answer+=i;
	      }                   
	      return answer;
	  }


}//class
