package Programmers.SummerWinter2018;

public class SkillTree {

	public static void main(String[] args) {
		
		String skill = "CBD";
		
		String[] skill_trees = {
			"BACDE", "CBADF", "AECB", "BDA"
		};
		
		System.out.println(" result : "+ solution(skill, skill_trees));

	}
	
	static String origin;
	
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        origin = skill;
        
        int len = skill_trees.length;
        
        for (int i = 0; i < len; i++) {
        	if (isPossible(skill_trees[i])) {
        		answer++;
        	}
        	
        }
        
        return answer;
    }
    
    static boolean isPossible(String s) {
    	
    	int originIdx = 0;
    	String[] arr = s.split("");
    	
    	for (int i = 0; i < s.length(); i++) {
    		
    		if (origin.contains(arr[i])) {
    			char c = origin.charAt(originIdx++ % origin.length());    			
    			if (c != s.charAt(i))
    				return false;    			
    		}
    	}        	
    	return true;
    }

}
