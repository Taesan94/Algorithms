package Programmers.Level2;

public class MakePrime {

	public static void main(String[] args) {
		
		int[] nums = { 1,2,3,4 };
		
		int result = solution(nums);
	
		System.out.println("result : " + result );
	}

	public static int solution(int[] nums) {
		int answer = 0;

		for ( int i = 0 ; i < nums.length-2; i++ ) {
			for ( int j = i+1 ; j < nums.length-1; j++ ) {
				for ( int k = j+1; k < nums.length; k++ ) {
					int sum =  nums[i]+ nums[j]+ nums[k]; 
					if(primeCheck(sum)) answer++;
				}
			}
		}
		
		return answer;
	}
	
	private static boolean primeCheck(int sum) {
		for ( int i = 2; i < sum/2; i++ ) {
			if( sum % i == 0 ) return false;
		}
		return true;
	}

}
