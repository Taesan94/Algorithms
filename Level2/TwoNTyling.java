package Programmers.Level2;

import java.util.Scanner;

public class TwoNTyling {

	static int[] prevSum ;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner( System.in);
		
		int n = Integer.valueOf(scan.nextLine());
		
		prevSum = new int[n+1];
		
		int result = solution(n) % 1000000007;
		
		System.out.println(" int max : " + Integer.MAX_VALUE);
		
		System.out.println(result);
	}

	public static int solution(int n) {
		
		if ( n == 0 ) return 0;
		if ( n == 1 ) return 1;
		if ( n == 2 ) return 2;
		
		if ( prevSum[n] != 0 ) return prevSum[n];
		
		return prevSum[n] = (solution(n-1) + solution(n-2)) % 1000000007;
	}

}
