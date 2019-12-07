package Programmers.Level2;

import java.util.Arrays;

public class Top {

	public static void main(String[] args) {

		int[] heights = {
				1,5,3,6,7,6,5
		};

		int[] answer = solution(heights);

		System.out.println(Arrays.toString(answer));
		
	}//main
	
    public static int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        
        for ( int i = heights.length-1 ; i > 0 ; i -- ) {
        	int top1 = heights[i];
        	for ( int j = i-1 ; j >= 0; j-- ) {
        		int top2 = heights[j];
        		if ( top2 > top1 ) {
        			answer[i] = j+1;
        			break;
        		}
        	}
        }
        return answer;
    }
    
}//class
