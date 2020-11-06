package Programmers.Level2_Retry1;

import java.util.Arrays;

public class HowmuchStock {

	public static void main(String[] args) {
		int[] prices = {1,2,3,2,3};
		
		System.out.println(Arrays.toString(solution(prices)));
	}

    public static int[] solution(int[] prices) {
        int[] answer = {};
        answer = new int[prices.length];
        
        for (int i = 0; i < prices.length - 1; i++) {
        	answer[i] = findTime(i, prices);
        }
        
        return answer;
    }
    
    static int findTime(int start, int[] prices) {
    	
    	int price = prices[start];
    	
    	int time = 0;
    	for (int i = start + 1; i < prices.length; i++) {
    		time++;
    		if (prices[i] < price) {
    			break ;
    		}
    	}
    	return time;
    }
}
