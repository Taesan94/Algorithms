package Programmers.AlgorithmBasic.Heap;

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

		for(String oper : operations ) {

			String[] opers = oper.split(" ");

			String op = opers[0];
			int value = Integer.valueOf(opers[1]);

			if( op.equals("D") && !pq.isEmpty() ) {
				if(value==1) { // 최댓값 삭제
					PriorityQueue<Integer> reverse = new PriorityQueue<>(Collections.reverseOrder());
					reverse.addAll(pq);
					int remove = reverse.poll();
					pq.remove(remove);
				}else { // 최솟값 삭제
					pq.poll();
				}
			}else if( op.equals("I") ) pq.add(value); // I 인경우.
		}

		if( pq.isEmpty() ) return new int[] {0,0};
		else {
			PriorityQueue<Integer> reverse = new PriorityQueue<>(Collections.reverseOrder());
			reverse.addAll(pq);
			return new int[] { reverse.peek(), pq.peek() } ;
		}
	}	

}
