package Programmers.AlgorithmBasic.Greedy;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LifeBoat {

	public static void main(String[] args) {
		
		int[] people = {
				// 70,50,80,50
				70,80,50
				// 20,20,20,20,40
		};
		
		int limit = 100;
		
		System.out.println("result : " + solution(people, limit));
		

	}
	
    public static int solution(int[] people, int limit) {
        int answer = 0;
        
        Deque<Integer> q = new LinkedList<>();
        
        Arrays.sort(people);
        
        for (int p : people) {
        	q.add(p);
        }
        
        int curr = 0;
        
        while (!q.isEmpty()) {
        	curr = q.pollLast();
        	if (!q.isEmpty() && curr + q.getFirst() <= limit) {
        		q.pollFirst();
        	}
        	answer++;
        }
        return answer;
    }

}
