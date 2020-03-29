package Programmers.AlgorithmBasic.BruteForce;

public class Problem1912 {

	public static void main(String[] args) {

		int n = 2 ;

		int[] problem = { -1,0 };

		int[] sums = new int[n];
		sums[0] = problem[0];
		int max = problem[0];

		int sum = 0;

		for ( int i = 1 ; i < n; i++ ) {
			sum = sums[i-1] + problem[i] ;

			if ( sum < problem[i] ) {
				sum = problem[i];
			}
			
			sums[i] = sum;

			if( sum > max ) {
				max=sum;
			}
		}

		System.out.println(" max :" + max);
	}


}
