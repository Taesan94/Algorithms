package Programmers.KAKAO_INTERNSHIP_2019;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CrossingSteppingBridge {

	public static void main(String[] args) {
		
		int[] stones = {
				 2, 4, 5, 3, 2, 1, 4, 2, 5, 1
				// 1,1,1,1,1,1,1,1,1,1,2
		};
		
		int k = 3;
		
		System.out.println("result : "+ solution(stones, k));
		
		
	}

	// 징검다리를 밟을 수 있는 수, index 의 집합.
	static Map<Integer, List<Integer>> infos  = new TreeMap<>();
	static int K;
    public static int solution(int[] stones, int k) {
        int answer = 0;
        
        K = k;
        
        // 돌 1개가 제거 되기 전까지는 친구들이 건널 수 있다.
        // 다음으로 작은 돌을 제거할 때, 건널 수 있는지를 봐야한다.
        if (stones.length == 1) {
        	return stones[0];
        } else {
        	
        	for (int i = 0; i < stones.length; i++) {
        		int stone = stones[i];
        		List<Integer> indexs = infos.getOrDefault(stone, new ArrayList<>());
        		indexs.add(i);
        		infos.put(stone, indexs);
        	}
        	
        	Iterator keys = infos.keySet().iterator();
        	
        	while(keys.hasNext()) {
        		
        		int key = (int)keys.next();
        		
        		List<Integer> indexs = infos.get(key);
        		
        		for (int i = 0; i < indexs.size(); i++) {
        			stones[indexs.get(i)] = 0;
        		}
        		
    			if (theEnd(indexs, stones)) {
    				return key;
    			}
        		answer = key;
        	}
        }
        return answer;
    }
    
    static boolean theEnd(List<Integer> indexs, int[] stones) {
    	boolean possible = false;
    	
    	
    	for (int i = 0; i < indexs.size(); i++) {
        	int left = indexs.get(i);
        	int right = left + 1;
        	
        	int cnt = 0;
        	while (left >= 0 && stones[left] == 0) {
        		cnt++;
        		if (cnt == K)
        			return true;
        		left--;
        	}
        	
        	while (right < stones.length && stones[right] == 0) {
        		cnt++;
        		if (cnt == K)
        			return true;
        		right++;
        	}
    	}
    	
    	return possible;
    }
}
