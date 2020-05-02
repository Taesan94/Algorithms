package Programmers.Level3;

import java.util.Arrays;

public class Immigration {

	public static void main(String[] args) {
		
		int n = 6;
		int[] times = { 7,10 } ;
		
		long result = solution(n,times);
		
		System.out.println(" result : " + result );
		
		
	}
	
    public static long solution(int n, int[] times) {
        
        
        // 이분 탐색으로 해결한다.
        Arrays.sort(times);
        
        long answer = (long)times[0]*n ;
        
        long start = 0 ;
        // 될 수 있는 max 값이다.
        long end = (long)(times[times.length-1]) * n ;
        
        // start==end일때, 수용 가능하다면 answer에 최솟 값을 구하게 된다.
        // 그러다 어긋났을 때는 고려하지 않아도 된다.
        while( start <= end ) {
        	
        	long endTime = (start+end)/2;
        	
        	int maxPeople = 0 ;
        	
        	// 해당시간동안 n번째 플랫폼에서 수용 할 수 있는 최대 인원을 더해간다.
        	for( int time : times ) 
        		maxPeople += endTime/time;
        	
        	// 수용 가능한 인원이 n보다 작다면, 더 많은 시간이 필요하다.
        	if( maxPeople < n ) start=endTime+1;
        	else {
        		// 해당 시간에 수용가능하다면, 최솟값을 찾아간다.
        		answer = Math.min(answer, endTime);
        		end = endTime-1;
        	}
        }
        return answer;
    }

}
