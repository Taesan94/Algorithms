package Basic.AlgorithmBasic.Heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class DoublePriorityQueue {

	public static void main(String[] args) {

		String[] operations = {
				"I 16","I -5643","D -1","D 1","D 1","I 123","D -1"
		};

		int[] result = solution(operations);

		System.out.println(" result : " + Arrays.toString(result));

	}

	public static int[] solution(String[] operations) {

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		PriorityQueue<Integer> reverse = new PriorityQueue<>(Collections.reverseOrder());

		for(String oper : operations ) {

			String[] opers = oper.split(" ");

			String op = opers[0];
			int value = Integer.valueOf(opers[1]);

			if( op.equals("D") && !pq.isEmpty() && !reverse.isEmpty() ) {
				if(value==1) pq.remove(reverse.poll()); // 최대 값 삭제
				else reverse.remove(pq.poll()); // 최소 값 삭제
			}else if( op.equals("I") ) {// I 인경우.
				pq.add(value); 
				reverse.add(value);
			}
		}

		if( pq.isEmpty() ) return new int[] {0,0};
		else {
			return new int[] { reverse.peek(), pq.peek() } ;
		}
	}	

}
