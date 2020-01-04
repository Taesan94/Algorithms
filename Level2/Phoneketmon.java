package Programmers.Level2;

import java.util.HashSet;
import java.util.Set;

public class Phoneketmon {

	public static void main(String[] args) {
		
		int[] nums = {
			3,3,3,2,2,4
		};
		
		int answer = solution(nums);
		
		System.out.println(answer);

	}
	
    public static int solution(int[] nums) {
        int answer = 0;
        
        Set<Integer> s = new HashSet<Integer>();
        
        for ( int pocketmon : nums ) {
        	s.add(pocketmon);
        }
        
        int maxGet = nums.length/2;
        
        int pockets = s.size();
        
        answer = pockets >= maxGet ? maxGet : pockets;
        
        return answer;
    }

}
