package Programmers.Level2;

public class Fibonachi {
	
	static int[] result ;
	
	public static void main(String[] args) {
		
		int n = 5;
		int answer = solution(n);
		
		System.out.println("answer : " + answer );
		
		
		
	}//main
	
	 private static int solution(int n) {
		 result = new int[n+1];
		 return fibonachi(n);
	  }
	 
	 private static int fibonachi(int n ) {
		 
		 if( n==1 || n==2 ) return 1;
		 
		 if(result[n] != 0 ) return result[n];
		 else return result[n]= (fibonachi(n-1)+fibonachi(n-2)) % 1234567 ;
		 
	 }
	  
}//class
