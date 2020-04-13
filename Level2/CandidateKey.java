package Programmers.Level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CandidateKey {

	static List<String> candidateKey = new ArrayList<String>();

	public static void main(String[] args) {

		String[][] relation = {
				//{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}
				{"b","2","a","a","b"},{"b","2","7","1","b"},{"1","0","a","a","8"},{"7","5","a","a","9"},{"3","0","a","f","9"}
		};

		solution(relation);

	}

	// TODO Auto-generated method stub


	public static int solution(String[][] relation) {

		//가능한 모든조합을 구한다, 이미나온 후보키가 포함되는 경우는 버린다.
		int[] flag = new int[relation[0].length];

		powerSet(relation,flag,0);

		System.out.println(candidateKey.toString());

		return candidateKey.size();
	}

	private static void powerSet(String[][] relation, int[] flag, int index) {

		if( index == flag.length ) {

			String s = "";

			for ( int i = 0 ; i < flag.length; i++ ) {
				if(flag[i] == 1 ) {
					s+=String.valueOf(i);
				}
			}

			String[] arrS = s.split("");

			if(s.equals("") || s.equals(null)) return;
			// 후보키가 될 수 없는경우.
			if ( !candidateKey.isEmpty() ) {
				for ( int i = 0; i < candidateKey.size(); i++ ) {
					// 후보키 꺼내서 비교
					String candiKey = candidateKey.get(i);
					boolean possible = false;
					for ( char c : candiKey.toCharArray()) {
						if( !s.contains(String.valueOf(c)) ) {
							possible=true;
							break;
						}
					}
					if( !possible ) return;
				}
			}

			// 후보키가 되는지 확인한다.
			Map<String,Integer> duplicateCheck = new HashMap<String,Integer>();

			for ( int j = 0 ; j < relation.length; j++ ) {
				String s2 = "";
				for ( int i = 0 ; i < arrS.length; i++ ) {
					s2 += relation[j][Integer.valueOf(arrS[i])];
				}
				if ( duplicateCheck.get(s2) == null ) duplicateCheck.put(s2,1);
				else return;
			}
			// 위에서 return 되지않았다면 후보키를 추가해준다.
			candidateKey.add(s);

			return;
		}

		flag[index] = 0 ;
		powerSet(relation,flag,index+1);

		flag[index] = 1;
		powerSet(relation,flag,index+1);

	}

}
