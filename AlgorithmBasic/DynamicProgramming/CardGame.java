package Programmers.AlgorithmBasic.DynamicProgramming;

import java.util.Arrays;

public class CardGame {
	
	static int[] sLeft ;
	static int[] sRight;
	private static int[][] memo; // memoization 테이블
	
	public static void main(String[] args) {

		int[] left = {
				//1,1,1,1,3
				3,2,5
		};

		int[] right = {
				//2,3,1,1,1
				2,4,1
		};

		int result = solution3(left,right);
		
		for( int[] m : memo ) {
			System.out.println(Arrays.toString(m));
		}
		
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


	public static int solution3(int[] left, int[] right) {

		memo = new int[left.length][right.length];
		sLeft = left;
		sRight = right;
		
		find(0,0);
		
		return memo[0][0];
		
	}
	
	static int seq ;
	// memo배열에 i,j번째 카드를 선택 했을 때, 최대 값을 구한다.
	// 즉, 가장 위의 카드 ( 0,0 ) 부터 선택했을 때의 최대 값이 답이 된다.
	public static int find(int leftInd, int rightInd) {
		
		// 3,2,5
		// 2,4,1
		
		// 둘중 하나의 카드를 모두 소진한 경우이다.
		if(leftInd==sLeft.length || rightInd==sRight.length) return 0;
		
		// 이전에 해당 카드에 대한 답을 구했다면, 기록한 값을 사용한다.
		if( memo[leftInd][rightInd] > 0 ) return memo[leftInd][rightInd];
		
		// 오른쪽 카드가 작은 경우에는, 오른쪽 카드를 한장 버리고 해당 값을 더해주면 된다.
		if ( sRight[rightInd] < sLeft[leftInd] ) {
			memo[leftInd][rightInd] = find(leftInd,rightInd+1) + sRight[rightInd];
		}
		else { 
			// 오른쪽 카드가 크거나 같은 경우에는, 카드2장을 모두버리거나, 오른쪽카드만 버리거나 할 수 있다.
			 // 2가지 경우를 모두 확인해서, 더 큰 값을 기록해준다.
			memo[leftInd][rightInd] = Math.max(find(leftInd+1,rightInd+1),find(leftInd+1,rightInd));
		}
		System.out.println(seq++ +", 번 째 값 : " + "memo["+leftInd+"]["+rightInd+"] : "+memo[leftInd][rightInd]);
		// 계산한 최적 값을 return해주어야, 재귀되면서 참조 할 수 있다.
		return memo[leftInd][rightInd];
	}
	
}
