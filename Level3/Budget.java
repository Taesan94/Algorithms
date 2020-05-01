package Programmers.Level3;

import java.util.Arrays;

public class Budget {

	public static void main(String[] args) {

		int[] budgets= {
				//120,110,140,150
				1,2,3,4,5,6,7,8,9,10
		};

		int M = 56;

		int result = solution(budgets,M);

		System.out.println(" result : " + result );

	}

	public static int solution(int[] budgets, int M) {

		long sum = 0 ;
		for( int n : budgets ) {
			sum+=n;
		}
		
		// 오름차순 정렬
		Arrays.sort(budgets);
		
		int max = budgets[budgets.length-1];

		if( sum <= M ) return max;
		else {
			
			// 최소 상한액은 총합을 모든 지방이 나눠가지는 금액이다.
			int min= M/budgets.length;

			int index = 0;
			
			// 100,000이 100,000번 입력 될 수 도 있다..
			long sum2 = 0 ;
			
			while( sum2 < M ) {
				// 최소 상한액 이하 금액들의 sum을구한다.
				while( index < budgets.length && budgets[index] <= min ) {
					sum2+=budgets[index++];
				}

				// 최소 상한액보다 큰 값들은 상한액을 곱해준다.
				sum2 += (budgets.length-index)*min;
				
				if( sum2 >= M ) return min-1;
				else {
					// 아직 예산이 남은 경우에는 상한액을 증가시키기위해서 이후 index의 값들은 다시 빼준다.
					sum2 -= (budgets.length-index)*min;
					min++;
				}
			}
		}
		return max;
	}

}
