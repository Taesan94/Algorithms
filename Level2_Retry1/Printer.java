package Programmers.Level2_Retry1;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Printer {

	public static void main(String[] args) {

		int[] p = {2,1,3,2};
		int[] p2 = {1, 1, 9, 1, 1, 1};
		
		System.out.println(solution(p, 0));
		System.out.println(solution(p2, 0));
	}
	
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        
        Map<Integer, Integer> maxs = new TreeMap<>(Collections.reverseOrder());
        Queue<Info> q = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
        	int p = priorities[i];
        	maxs.put(p, maxs.getOrDefault(p, 0) + 1);
        	q.add(new Info(i, p));
        }
        Iterator maxInfo = maxs.keySet().iterator();
        int max = (int)maxInfo.next();
        
        while (!q.isEmpty()) {
        	Info info = q.poll();
        	if (max == info.p && info.idx == location)
        		break ;
        	
        	if (info.p == max) {
        		answer++;
        		maxs.put(max, maxs.get(max) - 1);
        		if (maxs.get(max) == 0) {
        			max = (int)maxInfo.next();
        		}
        	} else {
        		q.add(info);
        	}
        }
        return answer + 1;
    }
    
    static class Info {
    	int idx;
    	int p;
    	
    	Info (int idx, int p) {
    		this.idx = idx;
    		this.p = p;
    	}
    	
    	public String toString() {
    		return "idx : " + idx +", p : " + p +" \n";
    	}
    }
    
}
