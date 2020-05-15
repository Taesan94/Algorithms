package Programmers.AlgorithmBasic.DynamicProgramming;

import java.util.Arrays;

public class CardGame {

	public static void main(String[] args) {

		int[] left = {
				1,1,1,1,3
				//3,2,5
		};

		int[] right = {
				2,3,1,1,1
				//2,4,1
		};

		int result = solution3(left,right);

		System.out.println(" Result : " + result );


	}

	public static int solution(int[] left, int[] right) {
		int answer = 0;

		int indexR = 0;
		int indexL = 0;

		while( indexL < left.length && indexR < right.length ) {

			int tempL = indexL ;

			// 오른쪽 카드가 더 큰 경우
			if( right[indexR] > left[indexL] ) {

				boolean possible = false;
				// 왼쪽에 오른쪽 카드보다 큰 경우가 있다면, 왼쪽카드는 모두제거해도 된다.
				while( tempL < left.length ) {
					if( left[tempL] > right[indexR] ) {
						possible = true;
						break;
					}
					tempL++;
				}
				// 왼쪽에서 더 큰 카드를 찾은 경우.
				if(possible) indexL = tempL;
				else {// 그렇지 않다면 모두 제거한다.
					indexR++;
					indexL++;
				}
			}else if ( right[indexR] > left[indexL] ) indexL++;
			else {
				// 오른쪽 카드를 버릴 수 있는 경우.
				while ( indexR < right.length && left[indexL] > right[indexR] ) {
					answer+=right[indexR];
					indexR++;
				}
				// 오른쪽 카드를 다버렸으면, 이제 왼쪽카드는 오른쪽 카드보다 작거나, 같은경우가 됬을 것이다.        		
			}
		}
		return answer;
	}

	// 이해안됨
	public static int solution2( int[] left, int[] right ) {
		int[][] dp = new int[left.length + 1][right.length + 1];

		for (int i = left.length - 1; i >= 0; i--) {
			for (int j = right.length - 1; j >= 0; j--) {
				if (left[i] > right[j]) dp[i][j] = dp[i][j + 1] + right[j]; //오른쪽 카드가 더 작다
				else dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]); 
			}
		}
		return dp[0][0];
	}

	static int[] sLeft ;
	static int[] sRight;
	private static int[][] memo; // memoization 테이블

	public static int solution3(int[] left, int[] right) {

		memo = new int[left.length][right.length];
		for (int i = 0; i < left.length; i++) {
			Arrays.fill(memo[i], -1);
		}

		sLeft = left;
		sRight = right;
		return helper(0,0);
	}

	public static int helper(int leftInd, int rightInd) {


		if (sLeft.length == leftInd || sRight.length == rightInd) {
			return 0;
		}
		if (memo[leftInd][rightInd] != -1) {
			System.out.println(leftInd + ", " + rightInd +"는 이미 구했당께요 ");
			//이미 최적값을 찾은 상태
			return memo[leftInd][rightInd];
		} 
		if (sRight[rightInd] < sLeft[leftInd]) {
			// 오른쪽 카드가 더 작다면 오른쪽 카드를 버리고 더해준다
			int currAns = helper(leftInd, rightInd+1) + sRight[rightInd];

			// 계산한 값을 memoization 테이블에 저장
			memo[leftInd][rightInd] = currAns;
			System.out.println( " Left : " + leftInd +", Right : " + rightInd + ", # currAns : " + currAns);
			return currAns;
		}
		else {
			// 왼쪽카드만 버리거나 오른쪽카드와 왼쪽카드를 둘다 버리고 그 둘중 최적값을 계산
			int currAns = Math.max(helper(leftInd + 1, rightInd + 1),helper(leftInd + 1, rightInd));

			System.out.println( " Left : " + leftInd +", Right : " + rightInd + ", ## currAns : " + currAns);
			// 최적값을 memoization 테이블에 저장
			memo[leftInd][rightInd] = currAns;
			return currAns;
		}
	}



}
