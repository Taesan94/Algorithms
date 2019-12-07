package Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class SkillTrees {

	public static void main(String[] args) {

		String skill = "CBD";
		String[] skill_trees = {
				"BACDE", "CBADF", "AECB", "BDA"
		};

		int answer = solution( skill , skill_trees);

		System.out.println(answer);

	}//main
	
	// 내풀이.. Queue를 이용했다..
	public static int solution(String skill, String[] skill_trees) {

		int answer = 0;
		
		char[] skillBox = skill.toCharArray();
		
		
		for ( int i = 0 ; i < skill_trees.length; i ++ ) {
			
			char[] skTr = skill_trees[i].toCharArray();
			
			Queue<Character> q = new LinkedList<Character>();
			
			for ( int r = 0 ; r < skillBox.length; r ++ ) {
				q.add(skillBox[r]);
			}
			
			boolean possible = true;
			
			// 배우는 스킬에 선행스킬이 있는지 확인한다.
			for ( int j = 0 ; j < skTr.length; j ++ ) {
				
				char s1 = skTr[j];
				
				for ( int k = 0 ; k < skillBox.length; k ++ ) {
					if( s1 == skillBox[k] && s1 != q.poll() ) {
						possible = false;
						break;
					}
				}
				if ( !possible ) break ;
			}
			
			if ( possible ) answer++;
		}
		
		return answer;

	}//soultion

	
	// indexOf와 replaceAll 그리고 정규표현식을 사용한 방법..
    public static int solution2(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
        //ArrayList<String> skillTrees = new ArrayList<String>();

        Iterator<String> it = skillTrees.iterator();

        while (it.hasNext()) {
        	
        	
            if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
                it.remove();
            }
        }
        answer = skillTrees.size();
        return answer;
    }
}//class
