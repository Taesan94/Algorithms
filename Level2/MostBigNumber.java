package Programmers.Level2;

public class MostBigNumber {

	public static void main(String[] args) {

		String[] phone_book = { "123", "456" ,"789"};

		boolean answer = solution( phone_book );

		System.out.println(answer);

	}//main
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        for ( int i = 0 ; i < phone_book.length-1; i++ ) {
        	for ( int j = i+1 ; j < phone_book.length; j++ ) {
        		// 접두어가 있으면
        		if ( phone_book[i].startsWith(phone_book[j]) ) return false;
        		if ( phone_book[j].startsWith(phone_book[i]) ) return false;
        	}
        }
        return answer;
    }
}//class
