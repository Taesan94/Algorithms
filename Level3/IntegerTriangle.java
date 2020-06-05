package Programmers.Level3;

import java.util.Arrays;

public class IntegerTriangle {
	
	public static void main(String[] args) {
		
		int[][] triangle = {
				{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}
		};
		
		int result = solution(triangle);
		
		System.out.println(" result : " + result );
	}
	
    public static int solution(int[][] triangle) {
        
    	int answer =0;
        
        // 층을 내려가면서, 층의 최대 값을 기록해간다.
        int[][] maxValues = new int[triangle.length][triangle.length];
        
        // 2층까지는 초기 값지정.
        
        maxValues[0][0] = triangle[0][0];
        maxValues[1][0] = triangle[0][0] + triangle[1][0];
        maxValues[1][1] = triangle[0][0] + triangle[1][1];
        
        for ( int i=2; i< triangle.length; i++ ) {
        	 for ( int j=0; j<triangle[i].length; j++ ) {
        		 int left = j-1;
        		 maxValues[i][j] = Math.max(maxValues[i][j], maxValues[i-1][j] + triangle[i][j]);
        		 if( left >= 0 ) maxValues[i][j] = Math.max(maxValues[i][j], maxValues[i-1][left] + triangle[i][j]);
        	 }
        }
        
        int[] result = maxValues[triangle.length-1];
        Arrays.sort(result);
        
        answer = result[result.length-1];
        
        return answer;
    }
	
}
