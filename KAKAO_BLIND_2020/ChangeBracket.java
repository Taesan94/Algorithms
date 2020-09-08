package Programmers.KAKAO_BLIND_2020;

public class ChangeBracket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String p = "()))((()";//"()))((()"; //
		
		System.out.println("result : " + solution(p));
	};
	
    public static String solution(String p) {
        String answer = "";
        
        // 1.
        if (p.length() == 0) {
        	return answer;
        }
        
        // 2. 처음 균형잡인 문자열을 u에, 나머지를 v로 분리
        int cnt = 0;
        
        if(p.charAt(0) == '(')
        	cnt++;
        else
        	cnt--;

        int i = 1;
        
        while (i < p.length() && cnt != 0) {
        	
        	System.out.println("cnt : " + cnt);
        	
            if(p.charAt(i++) == '(')
            	cnt++;
            else
            	cnt--;
        }
        String u = p.substring(0, i);
        String v = p.substring(i );
        
        System.out.println(" u : " + u +", v : " + v);
        
        // 3. u가 올바르냐 ? => v에 대해 1단계부터 수행 후
        // 	3-1) 결과를 u에 이어 붙인 후 반환.
        if (correctU(u)) {
        	return u + solution(v);
        } else { // 4. u가 올바르지 않냐 ?
        	
            StringBuilder sb = new StringBuilder("");
        	// 4-1 ) "("
        	sb.append("(");
        	sb.append(solution(v));
        	sb.append(")");
        	
        	if (u.length() >= 2) {
        		u = u.substring(1, u.length() - 1);
        	}
        	return sb.append(changeU(u)).toString();
        }
        
    }
    
    static boolean correctU(String u) {
    	
    	int cnt = 0;
    	
    	for (char c : u.toCharArray()) {
    		if (c == '(')
    			cnt++;
    		else
    			cnt--;
    		
    		if (cnt < 0)
    			return false;
    	}
    	return true;
    }
    
    static String changeU(String u) {
    	
    	StringBuilder sb = new StringBuilder("");
    	
    	for (char c : u.toCharArray()) {
    		if (c == '(')
    			sb.append(")");
    		else
    			sb.append("(");
    	}
    	
    	return sb.toString();
    }

}
