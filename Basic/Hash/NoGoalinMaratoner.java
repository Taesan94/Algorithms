package Basic.Hash;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class NoGoalinMaratoner {

	public static void main(String[] args) {
		
		String[] participant = {
				"mislav", "stanko", "mislav", "ana"	
		};
		
		String[] completion = {
				"stanko", "ana", "mislav"
		};
		
		String result = solution(participant,completion);
		
		System.out.println("result : " + result );
	}

    public static String solution(String[] participant, String[] completion) {
        
        // 참가자를 map에 보관, String, int
        Map<String,Integer> p = new TreeMap<>();
        
        for( String human : participant ) {
        	p.put(human,p.getOrDefault(human, 0)+1);
        }
        // completion을 돌면서, 0이되면 삭제
        for ( String human : completion ) {
        	int n = p.getOrDefault(human, 0);
        	n--;
        	if( n == 0 ) p.remove(human);
        	else if( n > 0 ) {
        		p.put(human, n);
        	}else return human;
        }
        
        Iterator itr = p.keySet().iterator();
        
        return (String)itr.next();
    }
	
}
