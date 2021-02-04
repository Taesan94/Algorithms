package Basic.AlgorithmBasic.Graph.exam00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BestAlbum {

	public static void main(String[] args) {

		String[] genres = {
				"classic", "pop", "classic", "classic", "pop"	
		};

		int[] plays = {
				500,600,150,800,2500
		};

		int[] result = solution(genres, plays);

		System.out.println(Arrays.toString(result));
	}

	public static int[] solution(String[] genres, int[] plays) {
		int[] answer = {};
		
		// 1. 장르 별 재생횟수 기록
		Map<String,Integer> total = new HashMap<>();
		
		// 2. < 장르 , (고유번호, 재생횟수) >
		Map<String,List<int[]>> data = new HashMap<>();
		
		for( int i=0; i<genres.length; i++ ) {

			total.put(genres[i],total.getOrDefault(genres[i], 0)+plays[i]);
			
			List<int[]> d = data.getOrDefault(genres[i], new ArrayList<>());
			d.add( new int[] {i , plays[i]} );
			data.put(genres[i], d);
		}
		
		Iterator genres2 = total.keySet().iterator();
		
		// 총 재생횟수 순서대로 출력
		Map<Integer,String> total2 = new TreeMap<>(Collections.reverseOrder());
		
		// 1-2. 횟수별, 장르  오름차순으로 기록
		while( genres2.hasNext() ) {
			String g = (String)genres2.next();
			total2.put(total.get(g),g);
		}
		
		// 2. 많이 재생된 순서대로 최대 2개씩. 뽑기.
		Iterator genres3 = total2.values().iterator();
		
		List<Integer> result = new ArrayList<>();
		
		while( genres3.hasNext() ) {
			
			String genere = (String)genres3.next();
			
			List<int[]> list = data.get(genere);
			
			list.sort(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					int result = o2[1]-o1[1];
					if( result == 0 ) return o1[0]-o2[0];
					return result;
				}
			});
			
			for( int i=0; i<list.size(); i++ ) {
				if( i > 1 ) break;
				result.add(list.get(i)[0]);
			}
		}
		
		answer = new int[result.size()];
		for( int i=0; i<result.size(); i++ ) {
			answer[i] = result.get(i);
		}
		return answer;
	}

}
