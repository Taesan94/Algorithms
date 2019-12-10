package Programmers.Level2;

import java.util.Arrays;

public class HIndex {

	public static void main(String[] args) {
		
		int[] citations = { 3,3,3,3,3 } ;
		int answer = solution(citations);
		
		System.out.println(answer);
		
		
	}//main
	
    public static int solution(int[] citations) {
        // 오름차순.
        Arrays.sort(citations);
        
        int max = citations.length ;
        
        int i ;
        
        // 최대 h값은 논문의갯수이다.
        // h의 max값을 구할 것이다.
        for ( i = max-1; i >= 0 ; i-- ) {
        	System.out.println(" citations[ "+(max-1-i)+" ] : " + citations[ max-1-i]);
        	System.out.println(" i : " + i );
        	
        	// 예를들어 논문의갯수가 5일때면 모든 논문이 5이상이어야한다.
        	// 그렇다는것은, 가장 작은값도 5를 넘는지 확인해야한다.
        	if ( citations[ max-1-i ] >= i+1 ) break;
        	
        }
        
        return i+1;
        
    }//solution
    
}//class
