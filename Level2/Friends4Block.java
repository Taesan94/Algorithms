package Programmers.Level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Friends4Block {

	static int[] x = {0,1,0,1};
	static int[] y = {0,0,1,1};

	public static void main(String[] args) {

		int m = 6;
		int n = 2;
		String[] board = {
				//"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"
				//"CCBDE","AAADE","AAABF","CCBBF"
				//"ABCD", "BACE", "BCDD", "BCDD"
				// "CC","AA","AA","CC"
				// "FF","AA","CC","AA","AA","CC","DD","FF"
				"AA","AA","CC","AA","AA","DD"
		};

		int result = solution(m,n,board);

		System.out.println(" result : " + result );

	}

	public static int solution(int m, int n, String[] board) {
		int answer = 0;

		int[][] visit = new int[m][n];
		char[][] boardArr = new char[m][n];

		int i = 0 ;
		for(String s : board ) {
			boardArr[i] = s.toCharArray();
			i++;
		}
		
		return check(m,n,boardArr,visit);
	}

	private static int check(int m, int n , char[][] board, int[][] visit ) {

		// 재정렬 작업을 수행한다.
		// 다 본거는 Empty로 해준다.
		makeBoard(board,visit);

		int answer = 0 ;
			
		for ( int i = 0 ; i < m-1; i ++ ) {
			char[] row = board[i];
			// col
			for( int j = 0 ; j < n-1; j ++ ) {
				// 현재 그림을 기준으로 2*2가 성립하는지 확인한다.
				boolean possible = possible(i,j,board,visit);

				// 가능한 경우에는 모두 방문을 해준다.
				if( possible ) {
					for ( int k=0; k < 4; k++ ) {
						int nextI = i+x[k];
						int nextJ = j+y[k];

						if(visit[nextI][nextJ] == 0) {
							visit[nextI][nextJ]=1;
							answer++;
						}
					}
				}
			}
		}

		System.out.println( " answer : " + answer );

		if( answer != 0 ) return answer+=check(m,n,board,visit );

		return answer;
	}

	private static boolean possible(int i, int j , char[][] board, int[][] visit) {
		
		char current = board[i][j];
		
		for ( int k=0; k < 4; k++ ) {
			int nextI = i+x[k];
			int nextJ = j+y[k];

			int nextC = board[nextI][nextJ];
			// 안되는 경우
			if ( nextC != current || nextC=='E' ) {
				return false;
			}
		}
		return true;
	}

	private static void makeBoard(char[][] boardArr, int[][] visit) {

		for(int i = 0 ; i < visit[0].length; i++ ) { // col
			Queue<Integer> q = new LinkedList<Integer>();
			
			for(int j = visit.length-1; j>=0; j-- ) { // row
				if(visit[j][i] == 1 ) {
					q.add(j); // 비어있는 index;
				}else {
					if(!q.isEmpty()) {
						int emptyIndex = q.poll();
						// 방문한자리에 0의 값을 넣어주고.
						boardArr[emptyIndex][i] = boardArr[j][i];
						visit[emptyIndex][i] = 0 ;
						// 원래 자리에는 'Empty'를 표시해준다.
						boardArr[j][i] = 'E';
						visit[j][i] = 1 ;
					}
				}
			}
			
			// q에남은거 마저 처리해주기.
			while( !q.isEmpty() ) {
				int emptyIndex = q.poll();
				boardArr[emptyIndex][i] = 'E';
			}
			
		}
		
		for ( char[] board : boardArr ) {
			System.out.println(Arrays.toString(board));
		}
	}
}
