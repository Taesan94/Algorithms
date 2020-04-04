package Programmers.Level2;

import java.util.Arrays;

public class Nlcm {

	public static void main(String[] args) {
		
		int[] arr = { 2,6,8,14 };
		
		int result1 = solution(arr);
		
		int result2 = solution2(arr);
		
		System.out.println("result1 : " + result1+", result2 : " + result2);
		
		
	}
	
	// 최초풀이방식
    public static int solution(int[] arr) {
        
        Arrays.sort(arr);
        
        int cnt=1;                  
        while ( true ){          
        
            int max = arr[arr.length-1];      
            max*=cnt;          
            boolean success = true;
            
              for ( int j = 0 ; j < arr.length-1; j++ ){                    
                  if( max % arr[j] != 0 ) {
                      success = false;   
                      break;
                  }                    
              }
                         
            if(success) return max;       
          
            cnt++;
        }
    }
    
    // 풀이를 보고 다시 풀어본 방식.
    public static int solution2(int[] arr) {
    	
    	if(arr.length < 2 ) return arr[0];
    	
    	int max = arr[0]*arr[1] / gcd(arr[0],arr[1]);
    	
    	for ( int i = 2 ; i < arr.length; i++ ) {
    		max = max*arr[i] / gcd(max,arr[i]);
    	}
    	
    	return max;
    }
    
    private static int gcd(int a, int b) {
    	return a%b==0 ? b : gcd(b,a%b);
    }

}
