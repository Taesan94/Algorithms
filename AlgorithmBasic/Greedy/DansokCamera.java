package Programmers.AlgorithmBasic.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DansokCamera {

	public static void main(String[] args) {

		int[][] routes = {
				{-5,-3},{-20,15}, {-14,-5}, {-18,-13}
		};

		int result = solution(routes);

		System.out.println(" result : " + result );

	}

	public static int solution(int[][] routes) {

		List<Car> routeList = new ArrayList<>();

		for(int[] route : routes) {
			routeList.add(new Car(route[0],route[1]));
		}

		Collections.sort(routeList, new Comparator<Car>() {
			// 출발점을 기준으로 오름차순 정렬 하겠다.
			@Override
			public int compare(Car o1, Car o2) {
				return o1.in - o2.in;
			}
		});
		
		for( Car c : routeList ) {
			System.out.println(c.toString());
		}
		
		// 카메라는 최소1대 설치해야 한다.
		int camera= 1;
		// 먼저 들어온 차를 기준으로 포함 관계이면, 포함관계에 속해있는지 확인한다.
		// 포함 관계가 아니라면 현재 차가 나가기전에, 다음차가 들어왔는지를 확인 한 후에
		// 그렇다면, answer를 증가시켜주면 된다.
		Car first = routeList.get(0);
		
		for( int i=1; i < routeList.size(); i++ ) {
			
			Car second = routeList.get(i);
			// 먼저 들어온 차가 나가기 전에 다음에 들어온 차가 나갔다면 둘은 포함관계이다.
			if( second.out < first.out ) {
				// 즉, 같은 카메라에 단속 될 수 있다.
				// 고로, 기준이 되는 차를 변경해준다.
				first = second;
				
			// 먼저들어온 차가 나가기전에 다음에 들어온차가 나가지않았다면 ?
			// 먼저들어온 차가 나간 후에 다음에 들어온차가 들어왔는지를 확인해준다.
			}else if ( second.in > first.out ) { // 먼저들어온차가 나간 후에 들어왔다면
				// 카메라는 따로 설치해야 된다.
				camera++;
				first = second;
				// 먼저들어온 차가 나가기 전에 들어왔다면, 둘은 포함관계이다.
			}
		}
		
		return camera;
	}

	static class Car {

		int in ;
		int out;

		Car(int in, int out){
			this.in=in;
			this.out=out;
		}

		boolean possible(int point) {
			return (point >=in && point < out);
		}

		@Override
		public String toString() {
			return "Car [in=" + in + ", out=" + out + "]";
		}
	}

}
