package BOJ.Search;

public class Hansu {

	public static void main(String[] args) {
		
		int result = solution(1000);
		
		System.out.println(" result : " + result);
		
	}
	
	public static int solution(int N) {
		int answer = 0 ;
		
		for(int i = 1 ; i <= N; i ++ ) {
			
			if( i < 100 ) answer++;
			else {
				if(hansuCheck(i)) answer++;
			}
		}
		return answer;
	}
	
	private static boolean hansuCheck( int i ) {
		boolean result = true;
		
		char[] arr = String.valueOf(i).toCharArray();
		
		int minValue = arr[1]-arr[0];
		
		
		for(int j = 1 ; j < arr.length-1; j++) {
			
			int minValue2 = arr[j+1]-arr[j];
			if( minValue != minValue2 ) return false;
		}
		
		System.out.println( " i : " + i );
		
		return result;
	}

}
