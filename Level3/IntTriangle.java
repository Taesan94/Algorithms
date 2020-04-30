package Programmers.Level3;

import java.util.Arrays;

public class IntTriangle {
	
	public static void main(String[] args) {
		
		int[][] triangle = {
				{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}
		};
		
		int result = solution(triangle);
		
		System.out.println(" result : " + result );
		
	}
	
    public static int solution(int[][] triangle) {
        
        int row = triangle.length;
        
        // 현재위치에 올 수 있는 최대 값을 기록해간다.
        int[][] dp = new int[row][row];
        dp[0][0] = triangle[0][0];
        
        for( int i=1; i<row; i++ ) {
        	for( int j=0; j<=i; j++ ) {
        		int n = j-1;
        		int max = triangle[i][j]+dp[i-1][j];
        		if(n >= 0) {
        			max = Math.max(max,triangle[i][j]+dp[i-1][n]);
        		}
        		dp[i][j]=max;
        	}
        }
        
        Arrays.sort(dp[row-1]);
        
        return dp[row-1][row-1];
    }

}
