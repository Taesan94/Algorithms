package Programmers.Level2;

public class IronBar {

	public static void main(String[] args) {

		String arrangement = "()(((()())(())()))(())";
		
		int answer = solution(arrangement);
		
		System.out.println(answer);


	}//main
	
    public static int solution(String arrangement) {
        int answer = 0;
        
        // 먼저 레이저를 구분해 준다.
        arrangement = arrangement.replace("()", "U");
        
        // 대상을 처리하면서 막대기 갯수를 세어준다.
        int pipe = 0 ;
        
        char[] pipes = arrangement.toCharArray();
        
        for ( int i = 0 ; i < pipes.length; i++ ) {
        	
        	if ( pipes[i] == '(' ) pipe++; // pipe의 갯수를 새준다.
        	else if ( pipes[i] == ')') { // 닫혔을때는 pipe 하나 빼주고, 잘린거 추가해준다.
        		pipe--;
        		answer++;
        	}else if ( pipes[i] == 'U' ) { // 레이저인경우 pipe개수만큼 출력해준다.
        		answer += pipe;
        	}
        }
        
        return answer;
    }

}//class
