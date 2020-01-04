package Programmers.Level2;

public class ExpressionNumber {

	public static void main(String[] args) {
		
		int n = 2;
		
		int answer = solution2(n);

		System.out.println(answer);


	}//main

	public static int solution(int n) {
		int answer = 0;
		
		
		for ( int i = 1 ; i <= n ; i ++ ) {
			int sum = 0 ;
			
			int start = i ;
			
			while ( sum < n && start <= n ) {
				sum+=start;
				start++;
			}
			
			if ( sum == n ) answer++;
		}
		
		return answer;
	}
	
	  public static int solution2(int n) {      
		    int answer = 0;      
	        for (int i = 1; i <= n; i += 2) {
	            if (n % i == 0) {
	                answer++;
	            }
	        }
	        return answer;
	  }
}//class
