package Programmers.Level3;

import java.util.Arrays;

public class Budget {

	public static void main(String[] args) {

		int[] budgets= {
				// 120,110,140,150
				// 1,2,3,4,5,6,7,8,9,10
				119,120,120,120
		};

		int M = 480;

		int result = solution2(budgets,M);

		System.out.println(" result : " + result );

	}

	public static int solution(int[] budgets, int M) {
		// 100,000이 100,000번 입력 될 수 도 있다..
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

			sum = 0 ;

			while( sum < M ) {
				// 최소 상한액 이하 금액들의 sum을구한다.
				while( index < budgets.length && budgets[index] <= min ) {
					sum+=budgets[index++];
				}

				// 최소 상한액보다 큰 값들은 상한액을 곱해준다.
				sum += (budgets.length-index)*min;

				if( sum >= M ) return min-1;
				else {
					// 아직 예산이 남은 경우에는 상한액을 증가시키기위해서 이후 index의 값들은 다시 빼준다.
					sum -= (budgets.length-index)*min;
					min++;
				}
			}
		}
		return max;
	}

	public static int solution2(int[] budgets, int M) {
		int answer = 0 ;

		// 정렬한다.
		Arrays.sort(budgets);

		// 상한 값이 될 수 있는 범위를 좁혀나가면서 답을 찾는다.

		// 우선 end는 상한 값이 될 수 있는 Max 값이 되어야한다 0~Max까지의 범위에 담이 있기 때문이다.
		int start = 0 ; int end = budgets[budgets.length-1];
		
		// 범위가 같을 때 sum이 예산보다 크다면 상한가는 더 작은 범위에 있다.
		// return 이 End 인이유 1 : sum이 더 크다는 것은,해당 범위보다 1작은 값이 최대 값이라는 뜻이다.
		// 고로 A ~ A-1
		
		// 범위가 같을 때 sum이 예산보다 작거나 같다면 상한가는 더 큰 범위에 있다.
		// return 이 End 인이유 2 : sum이 작거나 같다는 것은, 상한가는 가장 큰 값이 될 수 있다는 것이다.
		// 고로 A+1 ~ A
		
		// start == end 인경우에 해당 범위의 값도 확인을 해주어야 한다.
		// 해당 범위에서 구한 sum을 가지고, sum이 더 큰 경우에는 -1을, 작은경우에는 해당 값을 넣어준다.
		// 그리고 그것이 return end를하는 이유다.. 
		while( start <= end ) {

			// 상한 값이다.
			int mid = (start+end)/2 ;
			int sum = 0 ;
			
			System.out.print( start + " ~ " + end + " 범위의 mid 값은 : " + mid);

			for( int budget : budgets )
				sum = budget > mid ? sum+mid : sum+budget;
				System.out.println(", sum : " + sum );
				// 상한 값을 적용한 sum이 큰 경우에는 상한 값은 작은 범위에 있다.
				if(sum > M) end=mid-1;
				else // 상한 값을 적용한 sum이 작은경우에는 상한 값은 더 큰 범위에 있다.
					start=mid+1;
		}
		
		// 근데 왜 end를 return 하느냐 ?? 
		return end ;
	}
	
    public static int solution3(int[] budgets, int M)
    {
        Arrays.sort(budgets);
        int start = 0, end = budgets[budgets.length - 1];
        while(start <= end)
        {
            int sum = 0;
            int mid = (start + end) / 2;
            for(int element : budgets)
                sum = element > mid ? sum + mid : sum + element;
            if(sum > M) end = mid - 1;
            else
                start = mid + 1;
        }
        return end;
    }
	
}
