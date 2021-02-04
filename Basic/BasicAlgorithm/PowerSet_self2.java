package Basic.AlgorithmBasic.BasicAlgorithm;

import java.util.Arrays;

public class PowerSet_self2 {

	static int N = 8; 
	static int result = 0 ;

	public static void main(String[] args) {

		// 2가 될 수 있는 max는  N/2이다.
		int max = N/2;

		while( max >= 0 ) {

			// 1이 채워지는 갯수
			int nmg = N-(2*max);

			int[] arr = new int[max+nmg];
			int wkMax = max ;
			for ( int i = 0 ; i < arr.length; i++ ) {
				if(wkMax != 0 ) {
					arr[i] = 2;
					wkMax--;
				}else {
					arr[i] = 1;
				}
			}

			System.out.println( " 조합대상 배열 : " + Arrays.toString(arr));

			// 원소의 갯수 - 2의 갯수 + 1
			int cnt = arr.length - max + 1;

			if( max == 0 || cnt == 1 ) result+=1;
			else if( max == 1 || cnt == 2 ) result += arr.length;
			else {
				for ( int i = cnt; i > 0 ; i-- ) {
					result+=i;
				}
			}
			max--;
		}

		System.out.println(" result : " + result );
	}

	// 처리 집합
	// 포함여부를 나타내는 배열
	// 요소의 index
	private static void powerset(int[] arr, int[] flag, int index ) {

		if(index == arr.length) {

			int sum = 0 ;

			for ( int i = 0 ; i < arr.length; i ++ ) {
				if(flag[i]==1) {
					sum+= arr[i];
				}
			}
			if( sum == N ) result++;
			return;
		}

		// 현재요소를 포함하는경우
		flag[index] = 1;
		powerset(arr,flag,index+1);

		// 현재요소를 포함하지 않는경우
		flag[index] = 0;
		powerset(arr,flag,index+1);
	}

}
