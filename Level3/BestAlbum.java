package Programmers.Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
		
		int[] result = solution(genres,plays);
		
		System.out.println(Arrays.toString(result));
		
	}
	
    public static int[] solution(String[] genres, int[] plays) {
        
        Map<String,List<Genre>> map = new HashMap<>();
        Map<String,Integer> sums = new HashMap<>();
        
        for(int i=0; i<genres.length; i++ ) {
        	String gene = genres[i];
        	int time = plays[i];
        	List<Genre> musics = map.getOrDefault(gene, new ArrayList<Genre>());
        	musics.add(new Genre(i,time));
        	map.put(gene, musics);
        	
        	int sum = sums.getOrDefault(gene, 0);
        	sums.put(gene, sum+time);
        }
        
        // 모든 장르는 재생된 횟수가 다르다
        Map<Integer,String> sums2 = new TreeMap<>(Collections.reverseOrder());
        
        Iterator sumKeys = sums.keySet().iterator();
        
        while(sumKeys.hasNext()) {
        	String gene = (String)sumKeys.next();
        	int sum = sums.get(gene);
        	sums2.put(sum, gene);
        }
        
        Iterator sums2Keys = sums2.values().iterator();
        List<Integer> result = new ArrayList<>();
        
        while(sums2Keys.hasNext()) {
        	String key = (String)sums2Keys.next();
        	List<Genre> musics = map.get(key);
        	Collections.sort(musics);
        	
        	int cnt=0;
        	
        	for( Genre music : musics ) {
        		result.add(music.index);
        		cnt++;
        		if(cnt==2) break;
        	}
        }
        
        int[] answer = new int[result.size()];
        
        int i = 0;
        
        for( int index : result ) answer[i++]=index;
        
        return answer;
    }
    
    static class Genre implements Comparable<Genre> {
    	
    	int index;
    	int time;
    	
    	Genre(int index, int time){
    		this.index=index;
    		this.time=time;
    	}

		@Override
		public String toString() {
			return "Genre [index=" + index + ", time=" + time + "]";
		}

		@Override
		public int compareTo(Genre o) {
			int value = o.time-time;
			if(value==0) value = index-o.index;
			return value;
		}
    }
}
