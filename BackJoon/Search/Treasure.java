package Programmers.BackJoon.Search;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Treasure {

	public static void main(String[] args) throws IOException {

		Scanner scan=new Scanner(System.in);
		int n = scan.nextInt();

		int[] A = new int[n];
		Integer[] B = new Integer[n];

		for( int i=0; i<2; i++ ) {
			for ( int j=0; j<n; j++ ) {
				int num = scan.nextInt();
				if(i==0) A[j]=num;
				else B[j]=num;
			}
		}

		int result = 0 ;

		Arrays.sort(A);
		Arrays.sort(B,Collections.reverseOrder());

		for( int i = 0 ; i < n; i ++ ) {
			result+=A[i]*B[i];
		}

		System.out.println(result);
	}

}
