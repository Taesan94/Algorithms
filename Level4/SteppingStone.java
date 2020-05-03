package Programmers.Level4;

import java.util.Arrays;

public class SteppingStone {

	public static void main(String[] args) {
		
		int distance = 25;
		int n = 2 ;
		int[] rocks = {
				2,14,11,21,17
		};
		
		Arrays.sort(rocks);
		
		System.out.println("########################");
		System.out.println(" input : * distance : " + distance+", n : " + n +", rocks : " + Arrays.toString(rocks)  );
		System.out.println("########################");
		
		int result = solution(distance,rocks,n);
		
		System.out.println("result : " + result );
		
	}
	
    static int solution(int distance, int[] rocks, int n){
        long ans = 0;
        long left = 1, right = distance, mid = 0;
    
        while(left <= right){
            int cnt = 0;
            int prev = 0;
            mid = (left + right) / 2;
            
            System.out.println("############## " + left + " ~ " + right +", mid : " + mid +"############## ");
            
            for(int i = 0 ; i < rocks.length ; ++i){
            	System.out.println("rocks["+ i +"] - "+ prev + " : " + (rocks[i] - prev));
                if(rocks[i] - prev < mid){
                	// mid보다 작은 값이 존재한다는 뜻으로
                    // 해당 돌을 제거한다.
                    cnt++;
                } else {
           			// mid보다 크거나 같은 값이 존재하므로
                    // prev를 현재 돌로 초기화한다.
                    prev = rocks[i];
                }
            }                                    
            // 마지막 돌과 도착점 사이의 거리도 확인한다.
            if(distance - prev < mid) cnt++;
            
            System.out.println(" CNT : " + cnt );
            
            if(cnt <= n){
            	// 주어진 n 보다 작거나 같은 만큼 돌을 없애서
                // 최솟값 x를 만들 수 있다.
                ans = mid > ans ? mid : ans;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) ans;
    }
	
	

}
