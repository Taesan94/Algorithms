package Programmers.Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TravelRoot {
	
	static List<String> result = new ArrayList<String>();
	static int max = 0;
	
	public static void main(String[] args) {

		String[][] tickets = {
				// {"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"} , {"IAD","ICN"} , {"ICN","JFK"}
				// {"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}
				// {"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}
				 {"ICN" ,"COO" }, {"COO" , "ICN"} , {"ICN" , "COO"},{"COO","ABC"}
				// {"ICN","BOO" }, { "ICN", "COO" }, { "COO", "DOO" }, {"DOO", "COO"}, { "BOO", "DOO"} ,{"DOO", "BOO"}, {"BOO", "ICN" }, {"COO", "BOO"}
		};

		String[] result = solution(tickets);
		System.out.println( " result : " + Arrays.toString(result));
	}

	public static String[] solution(String[][] tickets) {
		Map<String,List<String>> m = new LinkedHashMap<String,List<String>>();
		
		// tickets를 Map에 넣어준다.
		for ( String[] ticket : tickets ) {
			String from = ticket[0];
			String to = ticket[1];

			List<String> arrivalLocs = m.getOrDefault(from, new ArrayList<String>());
			arrivalLocs.add(to);
			m.put(from, arrivalLocs);
		}
		
		max = tickets.length+1;
		
		System.out.println( " befor M : " + m.toString());
		String startKey = tickets[0][0];
		result.add(startKey);
		
		dfs(m,startKey);

		String[] answer = new String[result.size()];
		
		for ( int i = 0 ; i < result.size(); i++ ) {
			answer[i]= result.get(i);
		}
		System.out.println( " After M : " + m.toString());
		
		return answer;
	}
	
	private static void dfs(Map<String,List<String>> m, String key ) {
		
		
		
	}
	

}
