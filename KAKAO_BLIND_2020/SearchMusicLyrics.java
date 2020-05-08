package Programmers.KAKAO_BLIND_2020;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SearchMusicLyrics {
	
	public static void main(String[] args) {
		
		String[] words = {
				"frodo", "front", "frost", "frozen", "frame", "kakao"
		};
		
		String[] queries = {
				"fro??", "????o", "fr???", "fro???", "pro?"
		};
		
		int[] result = solution(words,queries);
		
		System.out.println(Arrays.toString(result));
		
	}
	
    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        
        
        Map<String,Integer> m = new HashMap<>();
        
        m.put("A", 5);
        m.computeIfAbsent("B", value -> 10 );
        
        System.out.println(m.get("B"));
        
        return answer;
    }

}
