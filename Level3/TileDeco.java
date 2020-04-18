package Programmers.Level3;

public class TileDeco {

	public static void main(String[] args) {
		
		int N = 3;
		
		long result = solution(N);
		
		System.out.println(" result : " + result );
	}
	
    public static long solution(int N) {
        result = new long[N+2];
        
        if( N==1 ) return 4;
        if( N==2 ) return 6;
        
        fibonachi(N+1);
        
        return result[N+1]*2 + result[N]*2;
    }
    
    static long[] result ;
    
    private static long fibonachi(int N) {
    	if( N==1 || N==2 ) return 1;
    	if(result[N] != 0) return result[N];
    	else return result[N] = fibonachi(N-1) + fibonachi(N-2);
    }

}
