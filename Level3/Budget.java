package Programmers.Level3;

import java.util.Arrays;

public class Budget {

	public static void main(String[] args) {
		
		int[] budgets= {
				120,110,140,150
		};
		
		int M = 485;
		
		int result = solution(budgets,M);
		
		System.out.println(" result : " + result );

	}
	
    public static int solution(int[] budgets, int M) {
        int answer = 0;
        
        int sum = 0 ;
        for( int n : budgets ) {
        	sum+=n;
        }
        
        // 상한액을 측정 할 필요가 없는 경우.
        if( sum < M ) return 0;
        else {
        	
        	// 최소 상한액은 총합을 모든 지방이 나눠가지는 금액이다.
        	int min = sum/budgets.length;
        	
        	// 오름차순 정렬
        	Arrays.sort(budgets);
        	
        	
        	
        }
        
        
        
        return answer;
    }

}
