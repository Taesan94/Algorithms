package Programmers.Level2_Retry1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FunctionDevelope {

	public static void main(String[] args) {
		
		int[] p = {
				93, 30, 55
		};
		int[] s = {
				1, 30, 5
		};
		
		int[] p2 = {
				95,90,99,99,80,99
		};
		int[] s2 = {
				1,1,1,1,1,1
		};
		
		System.out.println(Arrays.toString(solution(p, s)));
		System.out.println(Arrays.toString(solution(p2, s2)));
	}
	
    public static int[] solution(int[] progresses, int[] speeds) {
        
        // 배포하는데 걸리는 시간.
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
        	
        	int day = (100 - progresses[i]) / speeds[i];
        	if ((100 - progresses[i]) % speeds[i] != 0) {
        		day++;
        	}
        	q.add(day);
        }
        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
        	int buildDay = q.poll();
        	int cnt = 1;        	
        	while (!q.isEmpty() && q.peek() <= buildDay) {
        		q.poll();
        		cnt++;
        	}
        	result.add(cnt);
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
        	answer[i] = result.get(i);
        }
        return answer;
    }

}
