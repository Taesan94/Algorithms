package Programmers.AlgorithmBasic.DynamicProgramming;

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
	
	public static int solution3(int[] left, int[] right) {
		
		int answer = 0 ;
		
		sLeft = left;
		sRight = right;
		
		answer = recursive(0,0);
		
		return answer ;
	}
	
	private static int recursive(int r, int l) {
		
		int answer = 0;
		
		if( r >= sRight.length || l >= sLeft.length ) return 0;
		
		int indexR = r;
		int indexL = l;

		// 카드를 2장버리거나, 왼쪽카드만 버리거나.
		if( sRight[indexR] >= sLeft[indexL] ) {
			
			// 2장버리는 경우
			int n1 = recursive(indexR+1,indexL+1);
			
			// 왼쪽카드만 버리는 경우
			int n2 = recursive(indexR,indexL+1);
			
			answer += Math.max(n1, n2);
			
		}else {
			// 오른쪽 카드를 버릴 수 있는 경우.
			while ( indexR < sRight.length && sLeft[indexL] > sRight[indexR] ) {
				answer+=sRight[indexR];
				indexR++;
			}
			// 오른쪽 카드를 다버렸으면, 이제 왼쪽카드는 오른쪽 카드보다 작거나, 같은경우가 됬을 것이다.
			answer += recursive(indexR,indexL);
		}
		return answer;
	}
	
	
}
