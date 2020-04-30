package Programmers.Level3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ExpressN_retry {

	public static void main(String[] args) {

		int n =5 ;
		int number = 12;

		int result = solution(n,number);
		System.out.println(" result : " + result );

	}
	static int staticNum = 0 ;
	static Map<Integer,Set<Integer>> dp = new HashMap<>();
	
	public static int solution(int N, int number) {

		// N를 최소한을 사용해서 number을 만들어야 한다.

		// N은 최대8번까지 사용, 그 이상은 -1을 return 한다.

		// N을 1번~8번사용해서 number가 되는지 확인한다.

		// 주어진 N을 1번만 사용하는 경우에는 N과 -N이 존재 할 수 있다.

		// 2번만 사용하는 경우에는 N을 한번만 사용한 경우에서 사칙연산을 하고, N을 2번 붙인 경우가 된다. 55와 같이.

		// 3번만 사용하는 경우는 2번만 사용하는 경우 + N을 3번 붙인경우다.555

		Set<Integer> values = new HashSet<>();
		values.add(N);
		values.add(-N);
		dp.put(1,values);

		if(number==N) return 1;

		staticNum = number;

		int addNum = N;

		// N을 4개붙이는 경우일 때, N을 2개 붙이는 경우의 사칙연산을 구할 수 도 있다.
		// 혹은 N을 1개,3개일 수도있다.

		// 즉 N개 붙이는 경우의 수를 모두 기록하고, 모든 경우의 수를 확인해야 한다.
		
		// 2개부터 만들어 간다.
		int seq = 2;
		while( seq <= 8 ) {
			
			// seq번째에 가능한 List를 add하면서 찾아간다.
			for( int i=1; i<=seq/2; i++ ) {
				
				// 비교대상 집합
				int compare = seq-i;
				System.out.println(seq+"일 때 , "+i+"와 , "+ compare);
				boolean find = nextValues(seq, dp.get(i), dp.get(compare));
				if(find) return seq;
			}

			addNum = addNum*10+N;
			if(addNum==number) return seq;
			dp.get(seq).add(addNum);
			
			System.out.println(seq +"번째 결과 ! : " + dp.toString());
			
			
			seq++;
		}

		return -1;
	}
	private static boolean nextValues(int seq, Set<Integer> values1, Set<Integer> values2) {

		Set<Integer> seqValues = dp.getOrDefault(seq, new HashSet());
		
		for( int v1 : values1 ) {
			for ( int v2 : values2 ) {
				
				int plus = v1+v2;
				int minus = v1-v2;
				int multiple = v1*v2;
				int division = v1;
				// 나누기의 경우에는 비교대상 두 수의 순서에 따라 다른 결과가 나온다...
				if(v2!=0) division = v1/v2;
				if(v1!=0) division = v2/v1;
				
				if( plus==staticNum || minus==staticNum || multiple==staticNum || division==staticNum ) {
					return true;
				}
				seqValues.add(plus);
				seqValues.add(minus);
				seqValues.add(multiple);
				seqValues.add(division);
			}
		}
		dp.put(seq, seqValues);
		
		return false;
	}
}
