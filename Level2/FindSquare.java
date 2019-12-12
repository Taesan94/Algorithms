package Programmers.Level2;

public class FindSquare {

	public static void main(String[] args) {

		int[][] board = {
				{1,1,1} , {1,0,1}
		};

		int result = solution(board);

		System.out.println(result);
	}//main

	public static int solution(int [][]board){
		
		// 우측하단부터 만들려고하는데, 길이가 1인경우에도 검사 될 수 있도록 크기가1더 큰 배열을 새로 만든다.
		int[][] newBoard = new int[board.length+1][board[0].length+1];
		
		for ( int i = 0 ; i < board.length; i++ ) {
			for ( int j = 0 ; j < board[0].length; j++ ) {
				newBoard[i+1][j+1] = board[i][j];
			}
		}
		
		int max = 0;
		
		// 모든 board를 확인한다.
		for ( int i = 1 ; i < newBoard.length; i ++ ) {
			for ( int j = 1 ; j < newBoard[i].length; j++ ) {

				// 2x2 사각형의 우측하단을 기준으로 정사각형이 되는 경우에는 변의 길이를 기록해간다.

				// 우측하단이 기준인 이유는 마지막 좌표의 값을 구하기전에는 나머지 board들은 계산이 끝나야하기 때문이다.

				// 변의 길이는 2x2 정사각형을 구성하는 변들의 최솟값이다.
				if ( newBoard[i][j] >= 1 ) {
					
					//좌측
					int left = newBoard[i-1][j];
					//상단
					int up = newBoard[i][j-1];
					//좌측상단(대각선)
					int leftDiagonal = newBoard[i-1][j-1];

					int min = Math.min(left, up);
					min = Math.min(min, leftDiagonal);

					newBoard[i][j] = min+1;

					max = Math.max(max, min+1);
				}
			}
		}

		return (int)Math.pow(max, 2);
	}

	private static int makeSquare( int[][] board , int row , int height ) {

		int y = 0 ;

		int tempY = height+1 ;

		// 우로 쭉 가면서 가로길이를 구해준다.
		while ( tempY < board[row].length && board[row][tempY] == 1 ) {
			tempY++;
			y++;
		}

		// 정사각형이 맞다면 true
		boolean squareYn = true;

		int endRow = row+y;
		int endHeight = height+y;

		if ( endRow >= board.length ) return 0;

		if ( board[endRow][endHeight] > 1 ) {
			row = endRow;
			height = endHeight;
			endRow = row+y;
			endHeight = height+y;
		}


		// 가로길이만큼 정사각형이 되는지 모두 확인해준다.
		for ( int i = row+1; i <= endRow; i++ ) {
			for ( int j = height; j <= endHeight; j++ ){
				if ( board[i][j] == 0 ) {
					squareYn = false;
					break;
				}
			}
			if ( !squareYn ) return 0 ;
		}

		int result = (int)Math.pow(y+1, 2);

		board[endRow][endHeight] = result;

		return result;
	}

	public static int solution2(int [][]board)
	{
		int answer = 0;

		int[][] arr = new int[board.length+1][board[0].length+1];

		for(int i = 0 ; i < board.length ; i++) {
			for(int j = 0 ; j <board[0].length ; j++) {
				if(board[i][j]==1)
					arr[i+1][j+1] = 1;
				else
					arr[i+1][j+1] = 0;
			}

		}

		for(int i = 1 ; i < arr.length; i++) {
			for(int j = 1 ; j < arr[0].length ; j++) {
				if(arr[i][j]==1) {
					int min = Math.min(arr[i-1][j], arr[i][j-1]);
					min = Math.min(min, arr[i-1][j-1]);

					arr[i][j] = min + 1;
					answer = Math.max(answer, arr[i][j]);
				}
			}
		}        
		return answer*answer;
	}

}//class
