package Basic.AlgorithmBasic.Sort;

import java.util.Arrays;

public class QuickSort {

	private static void quickSort(int[] arr, int start, int end) {
		
		// 이거 안해줘서 .. 고생했다.....
		// 2분할이라서 start는 계속0 , 끝은 length-1이라고 생각했는데 그러면 안된다.
		// 처음 시작점이 중간에 6번째 로들어왔으면
		// 6~10에서 분할이들어가고, 6~10내에서 또 분할이 일어나야된다.. 이걸 간과하지말자..!!
		
		int beforeS = start;
		int beforeE = end;
		
		int pivot = arr[(start+end)/2];

		// pivot값을 기준으로 정렬한다.
		// 같은경우일때도 start,end를 계산해야지 start변수만보고 앞,뒤 분할을 가능하다.
		while ( start <= end ) {

			while ( arr[start] > pivot ) start++;
			while ( arr[end] < pivot ) end--;

			if ( start <= end ) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				start++;
				end--;
			}
		}
		
		// 정렬이 끝난후 start, end로 무엇을해야 할까..
		// 2분할 한다
		
		if ( beforeS < start-1 ) quickSort( arr, beforeS, start-1 );
		if ( start < beforeE ) quickSort( arr, start, beforeE);

	}

	private static void print(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}


	public static void main(String[] args) {

		/*
		 * Quick정렬이란 ?
		 * 
		 * pivot값을 기준으로 작은값은 왼쪽,큰값은 오른쪽으로 partition을 나눠가면서 정렬하는 방법이다.
		 * 
		 * 평균속도 N logN
		 * 최악속도 N^2 이다.
		 * 
		 */

		int[] arr = { 2,6,8,9,1 };

		print(arr);

		quickSort(arr,0,arr.length-1);

		print(arr);

	}//main



}//class
