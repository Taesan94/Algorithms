package Programmers.Level2;

public class OneTwoFourNumber {

	public static void main(String[] args) {

		int n = 10 ;
		
		String answer = solution(n);
		
		//System.out.println(answer);
		show();

	}//main

	  public static String solution( int n ) {
	      
	      String answer = "";
	      
	      String[] special = { "4","1","2" } ;
	      
	      while ( n != 0 ) {
	    	  int nmg = n%3 ;
	    	  answer = special[nmg] + answer ;
	    	  n/=3;
	    	  if ( nmg == 0 ) n-=1;
	      }
	      
	      return answer;      
	  }
	  
	  private static String makeThree( int n ) {
		  String answer = "";
		  
		  int num = n ;
		  
		  while ( num != 0 ) {
			  int nmg = num%3;
			  answer = String.valueOf(nmg) + answer ;
			  num/=3;
		  }
		  
		  return answer ;
	  }
	  
	  private static void show() {
		  for ( int i = 1 ; i <= 20 ; i++ ) {
			  
			  System.out.printf("%d\t%s(124)\t%s(3)",i,solution(i) , makeThree(i));
			  System.out.println();
			  
			  
		  }
	  }
}//class
