package Programmers.AlgorithmBasic.Sort;

import java.util.Arrays;

public class QuickSort_Self {
	
	// pivot값을 기준으로 작은값은 왼쪽, 큰값은 오른쪽정렬한다.
	
	private static void quickSort(int[] arr, int start, int end ) {
		
		//분할지점을 찾아오자.
		
		System.out.println("### Before [arr] : " + Arrays.toString(arr));
		int part = partition(arr,start,end);
		print(arr,(start+end/2));
		System.out.println();
		
		//분할지점을 재귀하자.
		
		// 좌측정렬, 원소가2개이상이어야함무조건 !
		if ( start < part-1 ) quickSort( arr, start, part-1 );
		// 우측정렬, 얘도 원소2개이상이어야 함!
		if ( part < end ) quickSort(arr, part, end );
		
	}
	
	// start값을 return한다.
	// 같은경우에도 index를 ++,-- 해주어야 정확한 index지점을 찾을 수 있다.
	// start값을 기준으로 2분할지점을 찾는다.
	private static int partition(int[] arr, int start, int end) {
		
		int pivot = arr[(start+end)/2];
		
		// 같은경우도 봐야된다.
		while ( start <= end ) {
			while( arr[start] < pivot ) start++; // 작은값은 넘어간다. 큰값일때만 멈춘다.
			while( arr[end] > pivot ) end--; // 큰 값은 넘어간다. 작은값일때만 멈춘다. 
			
			// 조건을 한번더 확인한다.어긋나버린경우에는 바뀌면안된다... 이거 한번더확인해보자.
			if ( start <= end ) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				start++;
				end--;
			}
		}
		
		return start;
	}
	
	private static void print(int[] arr, int pivot) {
		System.out.print("### After [arr] : ");
		for ( int i = 0 ; i <arr.length; i++ ) {
			if( i== pivot ) System.out.print("[ "+ arr[i] +" ] ");
			else System.out.print(arr[i] +" ");
		}
	}
	
	public static void main(String[] args) {
		
		int[] arr = { 6,5,4,1,22,3 } ;
		
		quickSort(arr,0,arr.length-1);

	}

}
