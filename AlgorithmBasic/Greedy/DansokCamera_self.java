package Programmers.AlgorithmBasic.Greedy;

import java.util.Arrays;

public class DansokCamera_self {

	public static void main(String[] args) {
		
		int[][] routes = {
				{-5,-3},{-20,15}, {-14,-5}, {-18,-13}
		};

		int result = solution(routes);

		System.out.println(" result : " + result );
	}
	
    public static int solution(int[][] routes) {
        int answer = 1;
        
        // 먼저들어 온 차 순서대로 비교해나갈 것이다.
        Arrays.sort(routes, (o1,o2) -> { return o1[0]-o2[0]; });
        
        for( int[] route : routes ) {
        System.out.println(Arrays.toString(route) );
        }
        
        int outTime = routes[0][1];
        
        // 먼저 들어온 차와, 다음 차름 비교한다.
        for( int i=1; i<routes.length; i++ ) {
        	
        	int[] car = routes[i];
        	
        	// 나중에 들어온차의 시작점이, 처음들어온차가 나간시간보다 큰 경우에는 카메라를 추가로 설치해야 하는 경우이다.
        	if( car[0] > outTime ) {
        		outTime = car[1];
        		answer++;
        	}else { // 그렇지 않은 경우는 같이 감시 될 수 있다는 뜻이다.
        		// 그러나, 계속 앞,뒤 차량을 비교하는 것이아니고
        		// 진출시점이 작은 차량과 다음차량의 진입시점을 비교하여, 함께감시할 수 없는 경우를 고려해야 한다.
        		outTime = Math.min( car[1], outTime );
        	}
        }
        return answer;
    }

}
