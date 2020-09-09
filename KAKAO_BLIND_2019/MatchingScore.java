package Programmers.KAKAO_BLIND_2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MatchingScore {

	public static void main(String[] args) {

		String word = "Muzi";

		String[] pages = {
				"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"
		};

		System.out.println("result : " + solution(word, pages));
	}

	public static int solution(String word, String[] pages) {
		int answer = 0;

		// 1. <index, scores 정보>
		Map<String, Score> pageInfos = new HashMap<>();

		// 2. <pageUrl, 이 페이지를 참조하고 있는 page url 정보.>
		Map<String, List<String>> hrefUrlInfos = new HashMap<>();        

		for(int i = 0; i < pages.length; i++) {


			String pageUrl = "";
			String page = pages[i];
			String[] arr = page.split("https://");
			int hrefCnt = 0;
			int basicCnt = 0;
			String content = page.split("<body>")[1].split("</body>")[0].toLowerCase();

			word = word.toLowerCase();
			StringBuilder sb = new StringBuilder("");

			for (int k = 0; k < content.length(); k++) {

				if (!(content.charAt(k) >= 'a' &&  content.charAt(k) <= 'z')) {
					if (sb.toString().equals(word)) {
						basicCnt++;
					}
					sb = new StringBuilder("");
				}else {
					sb.append(content.charAt(k));
				}
			}

			for (int j = 0; j < arr.length; j++) {

				if (j > 0) {
					if (pageUrl.equals("") && arr[j - 1].contains("<meta property")) {
						pageUrl = arr[j].split("\"")[0];
					} else if (arr[j - 1].contains("<a href")) {
						String forignUrl = arr[j].split("\"")[0];
						List<String> list = hrefUrlInfos.getOrDefault(forignUrl, new ArrayList<>());
						list.add(pageUrl);
						hrefCnt++;
						hrefUrlInfos.put(forignUrl, list);
					}
				}
			}

			System.out.println(answer++ + "의  basicCnt : " + basicCnt +", hrefCnt : " + hrefCnt);        	

			// 기본 점수
			// 외부 링크 수
			pageInfos.put(pageUrl, new Score(i, basicCnt, hrefCnt, ((double)basicCnt / hrefCnt)));
		}

		int index = 0;
		Score[] scores = new Score[pageInfos.size()];
		Iterator itr= pageInfos.keySet().iterator();

		while(itr.hasNext()) {

			double linkScore = 0;
			String url = (String)itr.next();
			
			Score score = pageInfos.get(url);
			score.finalScore = score.basic;

			if (hrefUrlInfos.get(url) != null) {
				List<String> list = hrefUrlInfos.get(url);

				for (int i = 0; i < list.size(); i++) {
					linkScore += pageInfos.get(list.get(i)).linkScore;
				}
				score.finalScore += linkScore;
			}
			
			scores[index++] = score;
		}


		System.out.println("scores : " + Arrays.toString(scores));

		Arrays.sort(scores, new Comparator<Score>() {

			@Override
			public int compare(Score o1, Score o2) {
				return o2.finalScore == o1.finalScore ? o1.index - o2.index : (int)(o2.finalScore - o1.finalScore);
			}
		});

		return scores[0].index;
	}

	static class Score {

		int index;
		int basic = 0;
		int hrefCnt = 0;
		double linkScore = 0;
		double finalScore = 0;

		Score(int index, int basic, int hrefCnt, double linkScore){
			this.index = index;
			this.basic = basic;
			this.hrefCnt = hrefCnt;
			this.linkScore = linkScore;
		}

		public String toString() {
			return "basic : " + basic + ", hrefCnt : " + hrefCnt +", linkScore : " + linkScore +", finalScore : " + finalScore;
		}
	}
}
