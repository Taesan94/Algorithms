package Programmers.AlgorithmBasic.Heap;

import java.util.PriorityQueue;

public class MoreSpicy {

	public static void main(String[] args) {
		
		int[] scoville = {
			1,2,3,9,10,12	
		};
		
		int K = 7;
		
		int result = solution(scoville, K);
		
		System.out.println(" result : " + result );
		
	}
	
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int n : scoville) pq.add(n);
        
        // 가장 안 매운거, 그다음 안 매운거를 뽑아서 계산한다.
        while( pq.size() > 1 && pq.peek() < K ) {
        	answer++;
        	pq.add(pq.poll() + pq.poll()*2);
        }
        
        if(pq.peek() < K) return -1;
        
        return answer;
    }

}
