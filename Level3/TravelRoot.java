package Programmers.Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TravelRoot {

	public static void main(String[] args) {

		String[][] tickets = {
				//  {"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}
				// {"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}
				// {"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}
				// {"ICN" ,"COO" }, {"COO" , "ICN"} , {"ICN" , "COO"},{"COO","ABC"}
				 {"ICN","BOO" }, { "ICN", "COO" }, { "COO", "DOO" }, {"DOO", "COO"}, { "BOO", "DOO"} ,{"DOO", "BOO"}, {"BOO", "ICN" }, {"COO", "BOO"}
		};

		String[] result = solution(tickets);
		System.out.println( " result : " + Arrays.toString(result));
	}

	public static String[] solution(String[][] tickets) {

		for ( int i = 0 ; i < tickets.length; i++ ) {

			boolean[] visit = new boolean[tickets.length];
			
			String s = tickets[i][0];
			String e = tickets[i][1];
			
			// 최초 시작점이 여러개일 경우, 각 경우에 dfs를 순회하도록한다.
			// 가능한 모든경우는 list에 add한다, 이후에 오름차순해서 가장 첫번째 대상을 가지고온다.
			if(s.equals("ICN")) {
				visit[i] = true ;
				result = "ICN,";
				dfs(tickets,visit,e,1);
			}
		}
		Collections.sort(resultBox);
		
		return resultBox.get(0).split(",");
	}

	static List<String> resultBox = new ArrayList<String>();
	static String result = "";
	
	private static void dfs(String[][] tickets, boolean[] visit, String end, int cnt) {
	
		result+=end+",";
		
		if(cnt==tickets.length) {
			resultBox.add(result);
			return;
		}
		
		for( int i = 0 ; i < tickets.length; i++ ) {
			
			String s = tickets[i][0];
			String e = tickets[i][1];
			
			if( s.equals(end) && !visit[i] ) {
				visit[i] = true;
				dfs(tickets,visit,e,cnt+1);
				visit[i] = false;
				result=result.substring(0,result.length()-4);
			}
			
		}
	}

}
