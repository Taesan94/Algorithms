package Programmers.Level1;

public class PandYCnt {

	public static void main(String[] args) {
		
		String s = "pyY";
		
		boolean result = solution(s);
		
		System.out.println(result);

	}//main

    static boolean solution(String s) {
        boolean answer = true;
        
        s= s.toUpperCase();
        
        int pCnt = 0 ;
        int yCnt = 0 ;

        String[] sS = s.split("");
        
        for ( int i = 0 ; i < s.length(); i++ ) {
        	
        	if(sS[i].equals("P")) pCnt ++;
        	else if(sS[i].equals("Y")) yCnt++;
        	
        }
        
        answer = (pCnt == yCnt) ;
        
        return answer;
    }

}//class
