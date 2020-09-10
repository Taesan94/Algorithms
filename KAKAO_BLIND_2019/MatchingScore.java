package Programmers.KAKAO_BLIND_2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class MatchingScore {

	public static void main(String[] args) {

		String word = "blind";

		String[] pages = {
				"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"

		};

		System.out.println("result : " + solution(word, pages));
	}
	
	static String getMetaUrl(String page) {
		int metaS = page.indexOf("<meta property=\"");
		int metaE = page.indexOf("/>", metaS);
		String meta = page.substring(metaS, metaE);
		String url = meta.substring(meta.lastIndexOf("https://"), meta.length() -1);
		
		return url;
	}
	
	static int getBasicCnt(String body, String word) {
		int cnt = 0;
		
		StringBuilder sb = new StringBuilder("");
		for (char c : body.toCharArray()) {
			if (!(c >= 'a' && c <= 'z')) {
				if (sb.toString().equals(word)) {
					cnt++;
				}
				sb = new StringBuilder("");
			} else
				sb.append(c);
		}
		
		return cnt;
	}
	
	static Stack<String> getHrefs(String body){
		
		Stack<String> hrefs = new Stack<String>();
		
		int hrefS = body.indexOf("<a href=\"https://");
		
		
		while (hrefS != -1) {
			int hrefE = body.indexOf("\">", hrefS + 1);
			String href = body.substring(hrefS, hrefE).substring(9);
			hrefs.add(href);
			body = body.substring(hrefE);
			hrefS = body.indexOf("<a href=\"https://");
		}
		
		return hrefs;
	}
	

	public static int solution(String word, String[] pages) {
		int answer = 0;
		
		Map<String, Integer> infos = new HashMap<>();
		List<Page> list = new ArrayList<>();
		
		for (int i = 0; i < pages.length; i++) {
			String page = pages[i];
			
			String url = getMetaUrl(page);
			
			String body = page.split("<body>")[1].split("</body>")[0].toLowerCase();
			
			// 1. word와 매치되는 것 찾기
			int basic = getBasicCnt(body, word.toLowerCase());
			
			// 2. href 찾기
			Stack<String> hrefs = getHrefs(body);
			Page addPage = new Page(url, i, basic, hrefs);
			infos.put(url, i);
			list.add(addPage);
		}
		
		for (int i = 0; i < list.size(); i++) {
			
			Page current = list.get(i);
			Stack<String> hrefs = current.outers;
			
			while (hrefs.isEmpty()) {
				String hrefUrl = hrefs.pop();
				
				if (infos.containsKey(hrefUrl)) {
					int hrefP = infos.get(hrefUrl);
					list.get(hrefP).finalScore += (double)current.basic / current.outerCnt;
				}
			}
		}
		
		Collections.sort(list, new Comparator<Page>() {
			@Override
			public int compare(Page o1, Page o2) {
				return o2.finalScore == o1.finalScore ? o1.index - o2.index : Double.compare(o2.finalScore, o1.finalScore);
			}
		});
		
		 return list.get(0).index;
	}
	
	static class Page {
		
		int index;
		int basic = 0;
		int outerCnt = 0;
		double finalScore = 0;
		Stack<String> outers = new Stack<>();
		String url = "";
		
		Page (String url, int index, int basic, Stack<String> outers){
			this.url = url;
			this.index = index;
			this.finalScore = basic;
			this.basic = basic;
			this.outers = outers;
			this.outerCnt = outers.size();
		}
		
		public String toString() {
			return "index : " + index +", basic : "+ basic + ", outerCnt : " + outerCnt +", finalScore : " + finalScore +"\n";
		}
		
		
		
		
	}

}
