package Programmers.AlgorithmBasic.Sort;

import java.util.Arrays;

public class QuickSort2 {
	
	private static void quicoSort(int[] arr) {
		quickSort(arr,0,arr.length-1);
	}
	
	private static void quickSort(int[] arr, int start, int end) {
		
		System.out.println("start : " + start +", end :" + end );
		
		int part2 = partition(arr, start, end);
		
		if ( start < part2-1 ) quickSort( arr, start, part2-1 );
		if ( part2 < end ) quickSort( arr, part2, end );
	}
	
	private static int partition(int[] arr , int start, int end) {
		
		int pivot = arr[(start+end)/2];
		
		while ( start <= end ) {
			while ( arr[start] < pivot ) start++;
			while ( arr[end] > pivot ) end--;
			if ( start <= end ) {
				swap(arr,start,end);
				start++;
				end--;
			}
		}
		
		return start;
	}
	
	public static void swap(int[] arr, int start, int end ) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
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
		 * 
		 */

		int[] arr = { 6,5,1,4,3 };

		print(arr);

		quickSort(arr,0,arr.length-1);

		print(arr);

	}//main



}//class
