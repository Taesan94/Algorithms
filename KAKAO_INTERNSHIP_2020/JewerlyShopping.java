package Programmers.KAKAO_INTERNSHIP_2020;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class JewerlyShopping {

	public static void main(String[] args) {
		
		String[] gems = {
				// "AA","AB","AC","AA","AC"
				// "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"
				// "XYZ", "XYZ", "XYZ"
				"ZZZ", "YYY", "NNNN", "YYY", "BBB"
		};
		
		int[] result = solution(gems);
		
		System.out.println("result : " + Arrays.toString(result));
	}
	
    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        int min = 100001;
       
        Set<String> gemSorts = new HashSet<>();
        
        for (String g : gems) {
        	gemSorts.add(g);
        }
        
        int size = gemSorts.size();
        
        Map<String, Integer> map = new LinkedHashMap<>();
        
        for (int i = 0; i < gems.length; i++) {
        	
        	String gem = gems[i];
        	
        	if (map.get(gem) != null)
        		map.remove(gem);
        	
        	
        	map.put(gem, i);
        	
        	if (map.size() == size) {
        		
        		String start = map.keySet().iterator().next();
        		
        		int len = map.get(gem) - map.get(start);
        		
        		if (len < min) {
        			min = len;
        			answer[0] = map.get(start) + 1;
        			answer[1] = map.get(gem) + 1;
        		}
        	}
        }
        
        return answer;
    }

}
