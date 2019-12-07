package Programmers.Level1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NoCompletePlayer {

	public static void main(String[] args) {

		String[] participant = {"mislav", "stanko", "mislav", "ana" };

		String[] completion = { "stanko","ana","mislav" } ;
		
		String answer = solution(participant,completion);
		
		System.out.println(answer);
		
	}//main
	
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String,Integer> m = new HashMap<String,Integer>();
        
        for ( String player : participant ) m.put( player, m.getOrDefault(player, 0) + 1);
        
        for ( String player : completion ) {
        	int cnt = m.get(player)-1;
        	if ( cnt == 0 ) m.remove(player);
        	else m.put(player,cnt);
        }
        
        Iterator<String> itr = m.keySet().iterator();
        
        answer = itr.next();
        
        return answer;
    }
}//class
