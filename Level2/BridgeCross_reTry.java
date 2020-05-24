package Programmers.Level2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BridgeCross_reTry {

	public static void main(String[] args) {

		int bridge_length = 2 ;

		int weight = 10;

		int[] truck_weights = // { 10,10,10,10,10,10,10,10,10,10 };
			{7,4,5,6};


		int answer = solution(bridge_length, weight , truck_weights);

		System.out.println(answer);


	}//main

	public static int solution(int bridge_length, int weight, int[] truck_weights) {

		int answer = 0;

		Queue<Integer> weights = new LinkedList<>();
		List<Truck> working = new LinkedList<>();

		for ( int t : truck_weights ) weights.add(t);
		
		int w = weights.poll();
		working.add(new Truck(w, 0));
		
		int time = 0 ;
		
		while( !working.isEmpty() ) {
			// 1초씩 계속이동....
			time ++ ;
			
			// working중인 대상의 작업시간을 늘려주기.
			for ( int i=0; i < working.size(); i++ ) {
				working.get(i).wkTime++;
			}
			
			
			
		}


		return answer;
	}
	
	static class Truck {
		
		int weight ;
		int wkTime ;
		
		Truck ( int weight , int wkTime ){
			this.weight = weight ;
			this.wkTime = wkTime;
		}
		
	}

}//class
