package Programmers.Level1;

public class GymClothes {

	public static void main(String[] args) {


		int n = 3;
		int[] lost = { 3 };
		int[] reserve = { 1 } ;



		int answer = solution ( n, lost , reserve );

		System.out.println(" 정답은 ?? " + answer);

	}//main

	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;

		// 체육복을 가진 학생들을 기록하는 배열이다.
		int[] result = new int[n+1];

		// 초기 값을 1로 초기화하면서 잃어버린 학생과, 여벌이 있는 학생을 함께 계산한다.
		for ( int i = 0 ; i < result.length; i++ ) {

			int lostStu = 0 ;
			int reserveStu = 0;
			
			result[i] ++ ;

			if ( i < lost.length ) {
				lostStu = lost[i];
				result[lostStu]--;
			}
			
			if ( i < reserve.length ) {
				reserveStu = reserve[i];
				result[reserveStu]++;
			}
		}
		
		for ( int i = 1 ; i < result.length; i ++ ) {
			
			if( result[i] > 1 ) {
				
				int prev = i-1;
				int next = i+1;
				
				if ( prev > 0 && result[prev] == 0) {
					result[i]--;
					result[prev]++;
				}else if ( next < result.length && result[next] == 0 ) {
					result[i]--;
					result[next]++;
				}
			}
		}
		
		for( int i = 1 ; i < result.length; i++ ) {
			if ( result[i] > 0 ) answer++;
		}

		return answer;
	}

}//class
