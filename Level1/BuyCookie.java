package Programmers.Level1;

public class BuyCookie {

	public static void main(String[] args) {

		int[] cookie = {
				1,1,11,11,2
		};

		int answer = solution(cookie);

		System.out.println(answer);

	}//main

	public static int solution(int[] cookie) {
		
		int answer = 0;
		
		// cookie전체 보기
		for ( int i = 0 ; i < cookie.length-1; i++ ) {
			
			// i를 기준으로 이전 값을 더해간다.
			int cur  = i   ;
			int curSum = cookie[cur] ;
			// i+1을 기준으로 이후 값을 더해간다.
			int next = i+1 ;
			int nextSum = cookie[next];
			
			while ( true ) {
				
				if ( curSum == nextSum ) {
					answer = Math.max( answer, curSum );
				}
				
				if ( curSum <= nextSum && cur > 0 ) {
					cur--;
					curSum += cookie[cur];
				}else if ( nextSum <= curSum && next < cookie.length-1 ) {
					next++;
					nextSum += cookie[next];
				}else break;
			}
		}

		return answer;
	}


}//class
