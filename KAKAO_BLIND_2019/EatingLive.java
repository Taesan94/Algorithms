package Programmers.KAKAO_BLIND_2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class EatingLive {

	public static void main(String[] args) {
		
		int[] food_times = {
				  3, 1, 2
				 // 3, 5, 1 , 6, 5, 3
				
		};
		
		int k = 5;//5;
		
		System.out.println("result : " + solution(food_times, k));

	}
	
	
    public static  int solution(int[] food_times, long k) {
        
        int foodCnt = food_times.length;
        // 걸리는 시간의 , index 기록
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Map<Integer, List<Integer>> map2 = new TreeMap<>();
        
        
        for (int i = 0; i < food_times.length; i++) {
        	int value = food_times[i];
        	List<Integer> list= map.getOrDefault(value, new ArrayList<>());
        	list.add(i);
        	map.put(value, list);
        	map2.put(value, list);
        }
        
        Iterator keys = map.keySet().iterator();
        
        long prevT = 0;
        long finishT = 0;
        
        while(keys.hasNext()) {
        	
        	int time = (int)keys.next();
        	System.out.println("time : " + time);
        	
        	finishT = (time - prevT) * foodCnt; // finishT 까지는, time에 해당하는 음식이 남아있다는 의미.
        	
        	// k는 네트워크 장애가 발생한 시간. 
        	
        	// time에 해당하는 음식이 남아 있는동안 네트워크 장애가 발생하는지 ??
       		if (k >= finishT) { // 다음음식을 찾는다.
    			foodCnt -= map.get(time).size(); // 같은 시간이 소요되는 음식을 한번에 제거.
    			map2.remove(time); // 소요된 대상 삭제
    			k -= finishT;	// 소요된 시간만큼 장애시간을 감소시킴.
    			prevT = time; // prevT만큼 회전을 끝냈다.
    		} else { // 장애가 발생 한다면.
    			
    			int seq = (int)(k % foodCnt);
    			
    			List<Integer> list = new ArrayList<>();
    			
    			Iterator itr = map2.keySet().iterator();
    			
    			while(itr.hasNext()) {
    				list.addAll(map2.get(itr.next()));
    			}
    			
    			Collections.sort(list);
    			System.out.println(list.toString());
    			
    			return list.get(seq) + 1;	
    			// seq에 있는 index 값 + 1    			
    		}
        }
        
        return -1;
    }

}
