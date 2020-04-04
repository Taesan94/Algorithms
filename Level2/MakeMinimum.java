package Programmers.Level2;

import java.util.Arrays;

public class MakeMinimum {
	
	public static void main(String[] args ) {
		
		int[] A = { 1,4,2 };
		int[] B = { 5,4,4 } ;
		
		int result = solution(A,B);
		
		System.out.println(" result : " + result );
		
	}
	
    public static int solution(int []A, int []B)
    {
        int answer = 0;
        
        int j = A.length-1;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for ( int num : A ) {
        	answer+=(num*B[j]);
        	j--;
        }
        
        return answer;
    }
	
	

}
