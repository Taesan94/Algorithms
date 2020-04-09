package Programmers.Level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

public class NewsClustering {

	// 허용 가능한 문자열의 종류와, 해당 종류가 몇번씩 반복되는지를 기록한다.
	static Map<String,Integer> wordRecord = new HashMap<String,Integer>();
	static Map<String,Integer> wordRecord2 = new HashMap<String,Integer>();

	public static void main(String[] args) {

		String str1 = "aaaaaaaaaaaaaaa";
		String str2 = "abcabcabc";
//		String str1 = "aa1+aa2";
//		String str2 = "AAAA12";
		int result = solution(str1,str2);

		System.out.println(" result : " + result );
		
		int result2 = solution2(str1,str2);
		System.out.println(" result : " + result2 );

	}

	public static int solution(String str1, String str2) {

		calc(str1, wordRecord);
		calc(str2, wordRecord2);
		
		System.out.println(wordRecord.toString());
		System.out.println(wordRecord2.toString());

		if(wordRecord.isEmpty() && wordRecord2.isEmpty() ) return 65536;

		int intersectionCnt = 0 ;
		int unionCnt = 0 ;

		Iterator itr = wordRecord.keySet().iterator();

		while(itr.hasNext()) {

			String key = (String)itr.next();
			int value1 = wordRecord.get(key);
			int value2 = wordRecord2.getOrDefault(key, 0);
			
			System.out.println(key + "의 value1 : " + value1 + ", value2 : " + value2 );
			
			if( value2 == 0 ) {
				// 처음에 그냥 unionCnt++했었는데.. 그렇게되면 중복허용집합특성상 union의 갯수가 정확하게 카운트 되지 않았다... ㅠㅠ
				unionCnt+=value1;
			}else {
				
				int big = value1 > value2 ? value1 : value2  ;
				int small = value1 <= value2 ? value1 : value2 ;
				int minus = big-small;

				if( minus == 0 ) {
					intersectionCnt+=small;
					unionCnt+=small;
				}else{
					intersectionCnt += small;
					unionCnt+=big;
				}
				
				wordRecord2.remove(key);
			}
		}
		
		// 처음에 그냥 wordRecord2.size()로했었는데.. 그러면 key값의 갯수만큼+되서 제대로 카운트 되지않았다... ㅠㅠ
		Iterator itr2 = wordRecord2.keySet().iterator();

		while(itr2.hasNext()) {
			unionCnt+=wordRecord2.get(itr2.next());
		}
		
		System.out.println(" intersectionCnt : " + intersectionCnt +", unionCnt : " + unionCnt );

		if ( unionCnt == 0 )
			return 65536;
		else if ( intersectionCnt == 0 )
			return 0;

		double result = (double)intersectionCnt/(double)unionCnt;

		return (int)(result * 65536);

	}

	private static void calc(String str, Map<String,Integer> records) {
		
		for ( int i = 0 ; i < str.length()-1; i++ ) {
			String word = str.substring(i,i+2).toLowerCase();
			boolean check = Pattern.matches("^[a-z]*$", word);

			if(check) {
				records.put(word, records.getOrDefault(word, 0)+1);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 public static int solution2(String str11, String str22) {
	        String str1 = str11.toLowerCase();
	        String str2 = str22.toLowerCase();
	        int answer = 0;
	        HashMap<String, Integer> map1 = new HashMap();
	        HashMap<String, Integer> map2 = new HashMap();
	        ArrayList<String> nList = new ArrayList<>(); //교집합
	        ArrayList<String> uList = new ArrayList<>(); //합집합
	        String mapKey1;
	        String mapKey2;
	        int i = 0;
	        //str1 초기화
	        while (i != str1.length() - 1) {
	            mapKey1 = str1.substring(i, i + 2);
	            if (isEng(mapKey1)) {
	                map1.put(mapKey1, map1.getOrDefault(mapKey1, 0) + 1);
	            }
	            i++;
	        }
	        //str2 초기화
	        i = 0;
	        while (i != str2.length() - 1) {
	            mapKey2 = str2.substring(i, i + 2);
	            if (isEng(mapKey2)) {
	                map2.put(mapKey2, map2.getOrDefault(mapKey2, 0) + 1);
	            }
	            i++;
	        }
	        Iterator<Map.Entry<String, Integer>> entries1 = map1.entrySet().iterator();
	        while (entries1.hasNext()) {
	            Map.Entry<String, Integer> entry = entries1.next();

	            // str1 만 값 갖고있거나 더 많이 혹은 똑같이 갖고 있는 경우
	            if (entry.getValue() >= map2.getOrDefault(entry.getKey(), 0)) {
	                // 합집합 처리(더많은기준으로)
	                for (i = 0; i < entry.getValue(); i++) {
	                    uList.add(entry.getKey());
	                }
	                // 교집합 처리(더적은거 기준으로, 겹치는거없으면 0)
	                for (i = 0; i < map2.getOrDefault(entry.getKey(), 0); i++) {
	                    nList.add(entry.getKey());
	                }
	                if (map2.getOrDefault(entry.getKey(), 0) != 0) {
	                    map2.remove(entry.getKey());
	                }
	            } else { // str2 가 str1 보다 해당 값 더 많이 갖고 있는 경우
	                // 합집합 처리
	                for (i = 0; i < map2.get(entry.getKey()); i++) {
	                    uList.add(entry.getKey());
	                }
	                // 교집합 처리
	                for (i = 0; i < entry.getValue(); i++) {
	                    nList.add(entry.getKey());
	                }
	                if (map2.getOrDefault(entry.getKey(), 0) != 0) {
	                    map2.remove(entry.getKey());
	                }
	            }
	        }
	        //남은 map2 꺼 합집합에 추가(str2만 갖고있는 값)
	        Iterator<Map.Entry<String, Integer>> entries2 = map2.entrySet().iterator();
	        while (entries2.hasNext()) {
	            Map.Entry<String, Integer> entry = entries2.next();
	            for(i=0; i<entry.getValue(); i++){
	                uList.add(entry.getKey());
	            }
	        }
	        //자카드 유사도
	        if (uList.size() == 0) {
	            return 65536;
	        } else {
	        	
	        	System.out.println( "#### 교집합 : "+ nList.size()+ ", 합집합 : "+ uList.size());
	        	
	            answer = (int) ((double) nList.size() / uList.size()*65536);;
	            return answer;
	        }

	    }

	    private static boolean isEng(String str) {
	        boolean flag = Pattern.matches("^[a-zA-Z]*$", str);
	        return flag;
	    }

}
