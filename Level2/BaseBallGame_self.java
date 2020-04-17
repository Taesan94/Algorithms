package Programmers.Level2;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame_self {

	public static void main(String[] args) {
		int[][] baseball ={
				{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}
		};
		
		int result = solution(baseball);
		
		System.out.println(" result : " + result );

	}

	public static int solution(int[][] baseball) {
		int answer = 0;

		List<BaseBall> records = new ArrayList();
		
		// 입력받은 숫자의 strike, ball을 기억한다.
		for(int[] balls : baseball ) {
			records.add(new BaseBall(balls));
		}

		// 이제 records에 있는 대상들이 모두 성립하는 3자리 숫자를 찾는다.
		for ( int i = 123; i < 988; i++ ) {

			String strI = String.valueOf(i);

			char n1 = strI.charAt(0);
			char n2 = strI.charAt(1);
			char n3 = strI.charAt(2);

			if( n1==n2 || n2==n3 || n1==n3 || n1=='0' || n2=='0' || n3=='0' ) continue;
			else {
				
				boolean possible = true;
				
				for( int j = 0 ; j < records.size(); j++ ) {

					BaseBall b = records.get(j);

					String strNum = String.valueOf(b.num);

					int ball = 0 ;
					int strike = 0 ;

					for ( int k=0; k < 3; k++ ) {
						char c1 = strI.charAt(k);
						for( int r=0; r<3; r++ ) {
							char c2 = strNum.charAt(r);
							if( c1 == c2 ) {
								if( k==r ) strike++;
								else ball++;
							}
						}
					}
					if( strike != b.strike || ball != b.ball ) {
						possible = false;
						break;
					}
				}
				
				if(possible) {
					System.out.println( i + " 는 가능하다 ?! ");
					answer++;
				}
			}
		}
		return answer;
	}

	static class BaseBall {

		int num ;
		int strike;
		int ball ;

		BaseBall(int[] record){
			this.num = Integer.valueOf(record[0]);
			this.strike = Integer.valueOf(record[1]);
			this.ball = Integer.valueOf(record[2]);
		}

	}

}
