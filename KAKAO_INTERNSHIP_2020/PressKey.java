package Programmers.KAKAO_INTERNSHIP_2020;

import java.util.HashMap;
import java.util.Map;

public class PressKey {

	public static void main(String[] args) {
		int[] numbers = {
			// 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5
			//	1, 2, 3, 4, 5, 6, 7, 8, 9, 0
				7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2
		};
		
		String hand = "left";
		
		System.out.println(solution(numbers, hand));
	}
	
	
	static StringBuilder sb = new StringBuilder();
	static Map<Integer, Pair> numPos = new HashMap<>();
	
    public static String solution(int[] numbers, String hand) {

        
        int num = 1;
        for (int i = 0; i < 3; i++) {
        	for (int j = 0; j < 3; j++) {
        		numPos.put(num++, new Pair(i,j));
        	}
        }
        
        numPos.put(0, new Pair(3,1));
        Pair handL = new Pair(3,0);
        Pair handR = new Pair(3,2);
        
        for (int n : numbers) {
        	
        	if (n == 1 || n == 4 || n == 7)
        		handL = setAndAppend(n , "L");
        	else if(n == 3 || n == 6 || n == 9)
        		handR = setAndAppend(n , "R");
        	else {
        		
        		Pair pos = numPos.get(n);
        		
        		int diffL = Math.abs(handL.x - pos.x) + Math.abs(handL.y - pos.y);
        		int diffR = Math.abs(handR.x - pos.x) + Math.abs(handR.y - pos.y);
        		
        		if (diffL < diffR)
        			handL = setAndAppend(n , "L");
        		else if(diffR < diffL)
        			handR = setAndAppend(n , "R");
        		else {
        			if (hand.equals("left"))
        				handL = setAndAppend(n , "L");
        			else
        				handR = setAndAppend(n , "R");
        		}
        	}
        }
        return sb.toString();
    }
    
    static Pair setAndAppend(int num, String w) {
    	
    	Pair hand = numPos.get(num);
    	sb.append(w);
    	
    	return hand;
    }
    
    static class Pair {
    	
    	int x;
    	int y;
    	
    	Pair(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    }

}
