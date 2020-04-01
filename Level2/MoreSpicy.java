package Programmers.Level2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MoreSpicy {

	public static void main(String[] args) {

		int[] scoville = {
//				1,2,3,9,10,12
				1,3,3
		};

		int k = 3; //7; 

		int result = solution(scoville,k);

		System.out.println(result);

	}

	// 모든 scoville이 K이상일때까지 
	// K보다 작은 scoville이 하나라도 존재한다면 -1을 반환한다.
	public static int solution(int[] scoville, int K) {

		//들어온 순서에 상관없이 우선순위대로 나간다.
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		// Arrays.sort(scoville);

		for ( int n : scoville ) {
			pq.add(n);
		}
		
		int cnt = 0 ;

		// K이상의 수가 첫번째에 나온다면 더이상 회전 할 필요가 없다.
		// K미만의 수는 모두 봐야한다.
		while ( pq.peek() < K ) {
			
			if(pq.size()==1) return -1;

			cnt++;

			//priorityQueue는 우선순위에 따라 데이터를 뽑는다.
			int newScoville = pq.poll() + pq.poll()*2 ;
			
			// [ 1,1,2 ] , K=3 과같은경우 원래2는빠질 수 있는데 남아있게 되는 경우가존재해서 크거나 같은경우도 add를 해주어야한다.
			pq.add(newScoville);
		}
		return cnt;
	}//solution


}//class
