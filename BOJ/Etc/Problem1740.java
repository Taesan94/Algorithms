package BOJ.Etc;

import java.util.Scanner;

public class Problem1740 {
	
	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		
		long n = scan.nextLong();
		
		long cnt = 0 ;
		long answer = 0 ;
		
		
		String[] arr = Long.toBinaryString(n).split("");
		
		for ( int i=arr.length-1; i>=0; i-- ) {
			answer += Long.valueOf(arr[i])*pow(cnt++);
		}
		
		System.out.println(answer);
		
	}
	
	private static long pow(long cnt) {
		long answer = 1 ;
		for( int i=0; i<cnt; i++ ) answer*=3 ; 		
		return answer ;
	}

}
