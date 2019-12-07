package Programmers.Level2;

public class BasiballGame {

	public static void main(String[] args) {

		int[][] baseball = {
				{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}
		};

		int result = solution(baseball);

		System.out.println(result);

	}//main

	public static int solution(int[][] baseball) {
		int answer = 0;

		BaseBall[] boxes = new BaseBall[baseball.length];

		// 입력받은 값의 숫자, Strike , Ball을 기록해둔다.
		for ( int i = 0 ; i < baseball.length; i++ ) {
			boxes[i] = new BaseBall(baseball[i]);
		}

		// 모든 숫자를 돌려서 , 주어진 숫자와 동일한 S,B이 나오는 경우에만 cnt해주면 된다.
		for ( int i = 123 ; i < 988; i++ ) {

			String stringI = String.valueOf(i);

			if ( stringI.contains("0") || stringI.charAt(0)==stringI.charAt(1) || stringI.charAt(1)==stringI.charAt(2) || stringI.charAt(0)==stringI.charAt(2)) continue;

			boolean check = true;

			for ( int j = 0 ; j < boxes.length; j ++ ) {

				int strike = 0 ;
				int ball = 0 ;

				BaseBall wkBox = boxes[j];

				String num = wkBox.ballNum;

				for ( int k = 0 ; k < 3; k ++ ) {
					for ( int l = 0 ; l < 3; l++ ) {
						if ( stringI.charAt(k) == num.charAt(l) ) {
							if ( k == l ) strike++;
							else ball++;
							break;
						}
					}
				}

				if ( wkBox.ball != ball || wkBox.strike != strike ) {
					check = false;
					break;
				}
			}
			if ( check ) answer ++;
		}

		return answer;
	}

	static class BaseBall{

		String ballNum = "";

		int strike = 0 ;
		int ball = 0 ;

		BaseBall(int[] checks){
			ballNum = String.valueOf(checks[0]);
			strike = checks[1];
			ball = checks[2];
		}
	}

}//class
