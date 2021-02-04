package Basic.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class NoodleFactory {

	public static void main(String[] args) {

		int stock = 2;
		int[] dates= { 2 };
		int[] supplies = { 13 } ;
		int k = 15 ;

		int result = solution(stock,dates,supplies,k);

		System.out.println(" result : " + result );

	}

	public static int solution(int stock, int[] dates, int[] supplies, int k) {
		int answer = 0;

		// 최소로 밀가루를 공급받을 수 있도록

		int day = stock;
		// 현재 날짜에 받을 수 있는 공급량을 모두 넣기.
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		int index = 0;
		// 가장 오래 버틸 수 있는 밀가루를 공급받고, 밀가루의 양 만큼 day증가시켜주가.
		while( day < k ) {
			while( index < dates.length && dates[index] <= day ) pq.add(supplies[index++]);
			day+=pq.poll();
			answer++;
		}

		return answer;
	}

}
