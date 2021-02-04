package Basic.QueueStack;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CrossBridge {

	public static void main(String[] args) {

		int len = 5;
		int w = 5;

		int[] truck_weight = {
				2,2,2,2,1,1,1,1,1
		};

		int result = solution(len,w,truck_weight);
		System.out.println(" result : " + result );


	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {

		int time = 0;

		// 대기트럭
		Queue<Truck> wait = new LinkedList<>();

		for ( int w : truck_weights ) {
			wait.add(new Truck(bridge_length,w));
		}

		// 다리를 건너는 트럭
		List<Truck> working = new LinkedList<>();

		// 순서대로 건너기 때문에, 최초 트럭을 작업중으로 바꿔준다.
		working.add(wait.poll());

		// 현재 이동중인 무게이다.
		int w =  working.get(0).weight;
		// 처음 트럭이 진입했을 때, 시간은 1초가 된다.
		time++;
		working.get(0).distance--;
		
		// if ( wait.isEmpty() ) time+=bridge_length;
		
		// 대기중인 트럭이 모두 건널때 까지.
		while( !wait.isEmpty() ) {

			// 트럭을 더 추가할 수 있다면, 넣어준다.
			if( w + wait.peek().weight <= weight ) {
				// 새로운 트럭을 넣으려면 1초가 더 소요되야 한다.
				time++;
				
				w += wait.peek().weight;
				working.add(wait.poll());
				
				// 시간이 증가한 만큼, 기존의 작업중인 트럭들도 거리를 1만큼 더 간다.
				for( int i=0; i<working.size(); i++ ) {
					 working.get(i).distance--;
				}
				
				
			}else { // 추가할 수 없다면, 진행중인 트럭을 빼고, 무게를 빼주고, 시간을 증가시킨다.
				
				Truck randTruck = working.get(0);
				w -= randTruck.weight;
				int t = randTruck.distance;
				
				working.remove(0);
				
				// 기존에 남아있는 트럭들의 거리도 이동한 시간만큼 가주어야 한다.
				for( int i=0; i<working.size(); i++ ) {
					if ( t > 0 ) working.get(i).distance-=t;
				}
				
				if ( t > 0 ) time+=t;
			}
		}
		
		int max = 0 ;
		
		for( int i=0; i<working.size(); i++ ) {
			max = Math.max(max, working.get(i).distance);
		}
		
		time+=max;
		
		return time+1;
	}

	static class Truck {
		
		// 남은거리.
		int distance ;
		// 트럭의 무게.
		int weight;

		Truck(int distance, int weight ){
			this.distance=distance;
			this.weight=weight;
		}
		
	}
}
