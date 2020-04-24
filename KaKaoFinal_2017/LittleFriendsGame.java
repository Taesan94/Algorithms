package Programmers.KaKaoFinal_2017;

import java.util.Set;
import java.util.TreeSet;

public class LittleFriendsGame {

	public static void main(String[] args) {

		int m = 3 ;
		int n = 3 ;

		String[] board = {
				"DBA", 
				"C*A", 
				"CDB"	
		};

		String result = solution(m,n,board);

		System.out.println(" result : " + result );

	}

	public static String solution(int m, int n, String[] board) {
		String answer = "";

		Set<Character> set = new TreeSet();

		for(String row : board ) {
			for( char c : row.toCharArray()) {
				if( c >= 'A' && c <= 'Z') {
					System.out.println("c : "+ c);
					set.add(c);
				}
			}
		}

		System.out.println(set.toString());

		int max = set.size();
		

		// 뿌실 수 있는거 뿌신다........

		// 주어진 배열을 기준으로, 뿌실 수 있는 걸 보관.

		// 보관 된 거를 순서대로 뿌시면서 뿌셔질 때 마다 cnt를 증가.

		// 종료 될 때 cnt가 max면 return하자.





		return answer;
	}
	
	// 현재 board에서 뿌실 수 있는 대상을 찾는다.
	private static void search(String[] board, int row,int col) {

		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++ ) {
				char tile = board[row].charAt(j);

				// 현재 타일이 도달 가능한지 확인해야 한다. ㄱ,ㄴ 두 경우 ..

				// ㄱ
				int nextCol = j+1;

				while( nextCol < board[0].length() ) {
					char nextTile = board[row].charAt(nextCol);

					if( nextTile=='.' ) {
						int nextRow = i+1;
						while( nextRow < board.length ) {
							nextTile = board[nextRow].charAt(nextCol);
							if(tile==nextTile) break ;
							else if(tile=='.') nextRow++;
							else break;
						}
					}else if(tile==nextTile) return;
					else break;
				}
				// ㄴ
				int nextRow = i+1;

				while( nextRow < board.length ) {
					char nextTile = board[nextRow].charAt(j);

					if( nextTile=='.' ) {
						nextCol= j;
						while( nextCol < board[0].length() ) {
							nextTile = board[nextRow].charAt(nextCol);
							if(tile==nextTile)break;
							else if(tile=='.') nextCol++;
							else break;
						}
					}else if(tile==nextTile)return;
					else break;
				}
			}
		}
	}


}
