package Programmers.KAKAO_INTERNSHIP_2019;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CrossingSteppingBridge2 {

	public static void main(String[] args) {
		
		int[] stones = {
				 2, 4, 5, 3, 2, 1, 4, 2, 5, 1
				// 1,1,1,1,1,1,1,1,1,1,2
		};
		
		int k = 3;
		
		System.out.println("result : "+ solution(stones, k));
		
		
	}

    public static int solution(int[] stones, int k) {
    	
    	int left = 1;
    	int right = 200000000;
    	
    	// 가능하다면 범위를 줄이고 불가능하면 늘리고.
    	while (left < right - 1) {
    		int mid = (left + right) / 2;
    		if (isPossible(stones, mid, k)) {
    			left = mid;
    		} else {
    			right = mid;
    		}
    	}
        return left;
    }
    
    static boolean isPossible(int[] stones, int mid, int k) {
    	
    	int cnt = 0;
    	boolean possible = true;
    	for (int i = 0; i < stones.length; i++) {
    		if (stones[i] - mid < 0) { // 0일 땐, 지나갈 수 있는거다.
    			cnt++;
    		} else {
    			cnt = 0;
    		}
    		if (cnt == k)
    			return false;
    	}
    	return possible;
    }
    
}
