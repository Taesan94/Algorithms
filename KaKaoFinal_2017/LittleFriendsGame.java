package Programmers.KaKaoFinal_2017;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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

		System.out.println(" Final result : " + result );

	}

	public static String solution(int m, int n, String[] board) {
		
		String result = checkBreak(board);
		
		System.out.println(" result : " + result );
		
		String[] r = result.split(",");
		
		Arrays.sort(r);
		System.out.println(Arrays.toString(r));
		
		BFS(board,result);

		// 회전 !

		// ㄱ,ㄴ 모두봐서 가능한 문자열이 있다면  뿌시고, 재귀한다.

		// 이 때 가능한 모든 문자열의 기본 board는 동일해야 한다.

		// 재귀하면서는 변경되어야 한다.



		return "";
	}
	
	private static String BFS(String[] board, String s) {
		
		String result ="";
		
		String[] sS = s.split(",");
		
		// Queue에 넣는다.
		Queue<String> q = new LinkedList<String>();
		
		for(String r : sS ) {
			q.add(r);
		}
		// 뽑은 대상으로 breakBoard,checkBreak 를 재귀한다.
		while(q.isEmpty()) {
			
			String str = (String)q.poll();
			result += str ;
			
			char c = str.charAt(str.length()-1);
			
			String[] cloneBoard = board.clone();
			breakBoard(cloneBoard,c);
			String ret = checkBreak(cloneBoard);
			BFS(cloneBoard,ret);
			
		}
		
		System.out.println(" resultssst : " + result );
		
		return result ;
		
	}

	private static String checkBreak(String[] board) {

		String result="";

		for(int i=0; i<board.length; i++) {
			String row = board[i];
			for( int j=0; j<row.length(); j++ ) {

				char tile = row.charAt(j);
				boolean find = false;


				// 뿌실 수 있는 문자열이 아니다.
				if( tile=='.' || tile =='*') continue;

				// ㄱ일때를 본다.
				for ( int r=j+1; r<row.length(); r++ ) {

					char nextTile = row.charAt(r);

					// 문자열 비교 수행.
					if( tile == nextTile ) {
						find = true;
						// 같은 경우에는 기록해준다.
						result+=String.valueOf(tile)+",";
					}

					if( !find ) {
						// 아닌 경우에는 nextTile 뭔지에 따라서 다르다.
						if( nextTile == '*' ) { // 우측으로 더이상 갈 수 없다.
							continue;
						}else if( nextTile == '.') { // 비어있는 경우이다.
							// 아래로 훑어준다.
							int down=i+1;
							while( down < board.length ) {
								
								char downTile = board[down].charAt(j);
								
								if( tile==downTile ) {
									find = true;
									result+=String.valueOf(tile)+",";
									break;
								}else if( downTile == '*' ) {
									// 아래로 더이상 갈 수 없다.
									// ㄱ을 보는 상황이니 j값을 ++해주고 종료시킨다.
									break;
								}else if( downTile == '.' ) {
									down++;
								}
							}
						}
					}
				} // ㄱ for

				if( !find ) {
					// ㄴ일때를 본다.
					for ( int s=i+1; s<board.length; s++ ) {

						char nextTile = board[s].charAt(j);

						// 문자열 비교 수행.
						if( tile == nextTile ) {
							find = true;
							result+=String.valueOf(tile)+",";
						}

						if( !find ){
							// 아닌 경우에는 nextTile 뭔지에 따라서 다르다.
							if( nextTile == '*' ) { // 우측으로 더이상 갈 수 없다.
								continue;
							}else if( nextTile == '.') { // 비어있는 경우이다.
								// 오른쪽으로 훑어준다.
								int right=j+1;

								while( right < row.length() ) {
									
									char rightTile = board[s].charAt(right);
									
									if( tile==rightTile ) {
										find = true;
										result+=String.valueOf(tile)+",";
										break;
									}else if( rightTile == '*' ) {
										// 아래로 더이상 갈 수 없다.
										// ㄱ을 보는 상황이니 j값을 ++해주고 종료시킨다.
										break;
									}else if( rightTile == '.' ) {
										right++;
									}
								}
							}
						}
					} // ㄴ for
				}// if( !find )
			}
		}
		return result;
	}


	private static void breakBoard(String[] board, char breakChar ) {

		for( int i=0; i<board.length; i++) {
			StringBuilder sb = new StringBuilder(board[i]);
			for( int j=0; j<sb.length(); j++) {
				if(sb.charAt(j)==breakChar) {
					sb.setCharAt(j, '.');
				}
			}
			board[i] = sb.toString();
		}

	}

}
