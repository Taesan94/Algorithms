package Basic.AlgorithmBasic.Greedy;

public class MakeBigNumber {

	public static void main(String[] args) {
		
		String number ="4177252841";
		int k = 4;
		
		String result = solution(number,k);
		
		System.out.println(" result : " + result );
		
	}
	
    public static String solution(String number, int k) {
        
    	StringBuilder answer = new StringBuilder();
        
        // 만들어야 하는 자릿수는 len개이다.
        int len = number.length()-k;
        

		int start = -1;
        // 선택되는 start를 범위내에서 정해준다.
        // 범위의 마지막 index는 커져야 한다.
        for(int i=len; i>0; i-- ) {
        	
        	int end=number.length()-i;
        	int max = 0;
        	start++;
        	
        	for( int j=start; j<=end; j++ ) {
        		int n = number.charAt(j)-'0';
        		if( n > max ) {
        			max = n;
        			start = j ;
        		}
        	}
        	answer.append(String.valueOf(max));
        }
        return answer.toString();
    }

}
