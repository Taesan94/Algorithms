package Programmers.KaKaoFinal_2017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class LittleFriendsGame {

	private static Map<Integer,List<String>> result = new TreeMap();
	private static int max = 0 ;

	public static void main(String[] args) {

		int m = 3 ;
		int n = 3 ;

		String[] board = {
				//"DBA", 
				//"C*A", 
				//"CDB"	
				"NRYN",
				"ARYA"
		};

		String result = solution(m,n,board);

		System.out.println(" Final result : " + result );

	}

	public static String solution(int m, int n, String[] board) {
		String answer = "IMPOSSIBLE";

		Set<Character> set = new TreeSet();

		for(String row : board ) {
			for( char c : row.toCharArray()) {
				if( c >= 'A' && c <= 'Z') {
					set.add(c);
				}
			}
		}

		max = set.size();

		int seq = 0;
		// 최초 수행.
		search(board,"",seq);

		seq++;

		if( result.size() < 1 ) return answer;
		else {
			System.out.println("result : " + result.toString());

			for( int i=0; i<max-1; i++) {
				
				List<String> r = result.get(seq-1);
				
				for(int j=0; j<r.size(); j++ ) {
					String word = r.get(j);
					String[] boardClone = board.clone();
					
					for( int k=0; k<word.length(); k++) {
						breakBoard(boardClone, word.charAt(k));
					}
					
					search(boardClone,word,seq);
				}
				
				if(result.get(seq)==null) {
					System.out.println("요기");
					return answer;
				}
				System.out.println("result : " + result.toString());
				seq++;
			}
		}

		System.out.println("result : " + result.toString());
		
		if(result.get(max-1) != null ) {
			answer = result.get(max-1).get(0);
		}

		return answer;
	}

	// 현재 board에서 뿌실 수 있는 대상을 찾는다.

	// 가능한 대상이 있다면 뿌시고, 재귀한다.

	// max만큼 문자열이 만들어진다면 String으로 붙여서 List에 넣어준다.

	private static void search(String[] board, String word , int seq ) {

		System.out.println(" word : " + word +", board : " + Arrays.toString(board));

		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length(); j++ ) {

				boolean find = false;
				char tile = board[i].charAt(j);
				// 현재 타일이 도달 가능한지 확인해야 한다. ㄱ,ㄴ 두 경우 ..

				if(tile=='.' || tile=='*') continue;

				System.out.println("i : " + i +", j : " + j + ", tile : " + tile );

				// ㄱ
				int nextCol = j+1;
				
				boolean last = false;
				
				while( !find && !last && nextCol < board[0].length() ) {
					char nextTile = board[i].charAt(nextCol);
					if( nextTile=='.' ) {
						int nextRow = i+1;
						while( nextRow < board.length ) {
							System.out.println(" word : "+ word + " nextRow : " + nextRow +", nextCol : " + nextCol + ", board : " + Arrays.toString(board) );
							nextTile = board[nextRow].charAt(nextCol);
							System.out.println(" nextTile : " + nextTile );
							if(tile==nextTile) {
								find=true ;
								break;
							}
							else if(nextTile=='.') {
								nextRow++;
							}
							else {
								nextCol++;
								break;
							}
						}
						if(nextRow >= board.length-1 ) {
							last=true;
						}
					}else if(tile==nextTile) {
						find=true;
						break;
					}else break;
				}
				// ㄴ
				int nextRow = i+1;
				
				last = false ;
				
				if(!find) {
					while( !find && !last && nextRow < board.length ) {
						char nextTile = board[nextRow].charAt(j);

						if( nextTile=='.' ) {
							nextCol= j;
							while( nextCol < board[0].length() ) {
								nextTile = board[nextRow].charAt(nextCol);
								if(tile==nextTile) {
									find=true;
									break;
								}
								else if(nextTile=='.') nextCol++;
								else {
									nextRow++;
									break;
								}
							}
							
							if(nextCol >= board[0].length()-1 ) {
								last=true;
							}
						}else if(tile==nextTile) {
							find=true;
							break;
						}else break;
					}
				}

				// 찾았으면
				if(find) {
					List<String> chars = result.getOrDefault(seq, new ArrayList());
					chars.add(word+String.valueOf(tile));
					result.put(seq, chars);
				}

			}
		}

		return ;
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
