package Programmers.AlgorithmBasic.BasicAlgorithm;

import java.util.Arrays;

public class PowerSet_self {

	public static void main(String[] args) {
		
		// 처리대상 
		
		String[] arr = { "a" , "b" , "c"};
		
		int[] flag = new int[arr.length];
		
		powerset(arr, flag, 0);


	}
	
	// 처리 집합
	// 포함여부를 나타내는 배열
	// 요소의 index
	private static void powerset(String[] arr, int[] flag, int index ) {
		
		if(index == arr.length) {
			
			System.out.println(Arrays.toString(flag));
			
			for ( int i = 0 ; i < arr.length; i ++ ) {
				if(flag[i]==1) {
					System.out.print(arr[i]);
				}
			}
			System.out.println();
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
