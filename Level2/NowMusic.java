package Programmers.Level2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NowMusic {

	public static void main(String[] args) {

		String[] musicinfos = {
				"04:00,04:02,ZERO,#BCC", "15:00,15:02,FIRST,#BCC", "04:00,04:02,SECOND,#BCC", "04:00,04:03,THIRD,#BCC"
		};

		String m = "CC";

		String result;
		try {
			result = solution(m,musicinfos);
			System.out.println("result : " + result );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public static String solution(String m, String[] musicinfos) throws Exception {
		String answer = "(None)";

		m = m.replaceAll("C#","c");
		m = m.replaceAll("D#","d");
		m = m.replaceAll("F#","f");
		m = m.replaceAll("G#","g");
		m = m.replaceAll("A#","a");

		System.out.println(" m : "+ m );

		int max = -1 ;

		for ( int i = 0;  i < musicinfos.length; i++ ) {

			String[] music = musicinfos[i].split(",");

			SimpleDateFormat f = new SimpleDateFormat("HH:mm", Locale.KOREA);

			Date start = f.parse(music[0]);
			Date end = f.parse(music[1]);
			long diff = end.getTime() - start.getTime() ;
			long minute = diff / (1000*60);
			System.out.println(" minute : " + minute );

			String musicInfo = music[3];

			musicInfo = musicInfo.replaceAll("C#","c");
			musicInfo = musicInfo.replaceAll("D#","d");
			musicInfo = musicInfo.replaceAll("F#","f");
			musicInfo = musicInfo.replaceAll("G#","g");
			musicInfo = musicInfo.replaceAll("A#","a");

			StringBuilder sb = new StringBuilder();
			boolean contains = false;

			int size = musicInfo.length();

			// 분이 더 짧다면 조금만돌아야한다.
			for ( int j = 0; j < minute; j++ ) {

				// 2번만 붙여도 가능한지 여부를 알 수 있다.
				if ( sb.toString().length() >= m.length()*2 && j >= musicInfo.length()*2 ) break;

				sb.append(musicInfo.charAt(j%size));
				if ( sb.toString().length() >= m.length() && sb.toString().contains(m) ){
					contains=true;
					break;
				}
			}

			System.out.println(" 1 "  + sb.toString());

			if ( contains ) {
				if ( max == (int)minute ) continue;
				// 조건이 일치하는 음악이 여러 개일때는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다.
				if ( (int)minute > max ) {
					max = (int)minute;
					answer = music[2];
				}

				System.out.println("answer : " + answer );
			}
		}
		return answer;
	}

}
