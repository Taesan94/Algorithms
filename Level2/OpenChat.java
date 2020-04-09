package Programmers.Level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OpenChat {

	public static void main(String[] args) {
		
		String[] record = {
				"Enter aa Muzi", "Enter aA Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"
		};
		
		String[] result = solution(record);
		
		System.out.println(" result : " + Arrays.toString(result) );
		
		
	}//main
	

    public static String[] solution(String[] record) {
        String[] answer = {};
        
        Map<String,String> nickNms = new HashMap<String,String>();

        int cnt = 0 ;
        for ( int i = 0 ; i < record.length; i++ ) {
        	
        	String[] arr = record[i].split(" ");
        	
        	String action = arr[0];
        	String userId = arr[1];
        	String nickNm = "";
        	
        	if ( arr.length > 2 )
        		nickNm = arr[2];
        	
        	if(action.equals("Enter")){
        		nickNms.put(userId, nickNm);
        		cnt++;
        	}else if(action.equals("Change")) {
        		nickNms.put(userId, nickNm);
        	}else if(action.equals("Leave")) {
        		cnt++;
        	}
        }
        
        answer = new String[cnt];
        int index = 0 ;
        
        for ( int i = 0 ; i < record.length; i++ ) {
        	
        	String[] arr = record[i].split(" ");
        	
        	String action = arr[0];
        	String userId = arr[1];
        	
        	if(action.equals("Enter")) {
        		answer[index] = nickNms.get(userId)+"님이 들어왔습니다.";
        		index++;
        	}else if(action.equals("Leave")) {
        		answer[index] = nickNms.get(userId)+"님이 나갔습니다.";
        		index++;
        	}
        }
        
        return answer;
    }
}//class
