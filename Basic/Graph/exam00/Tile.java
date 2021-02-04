package Basic.Graph.exam00;

import java.util.Arrays;

public class Tile {

	public static void main(String[] args) {
		
		int N=6;
		
		long result = solution(N);
		
		System.out.println(result);
	}
	
	static long[] dp = new long[100];
	
	
    public static long solution( int N ) {
    	dp(N);
    	
    	System.out.println(Arrays.toString(dp));
    	
    	return dp[N];
    }
    
    private static long dp(int N) {
    	if( N==1 ) return dp[1]=4;
    	if( N==2 ) return dp[2]=6;
    	
    	if ( dp[N] != 0 ) return dp[N];
    	
    	return dp[N] = dp[N-1]+dp[N-2];
    }

}
