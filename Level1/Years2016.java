package Programmers.Level1;

import java.util.Calendar;
import java.util.Locale;

public class Years2016 {

	public static void main(String[] args) {

		int a = 5;
		int b = 24;


		String day= solution ( a,b );
		
		String day2 = getDayName( a,b );

		System.out.println(" 정답은 ?? " + day);
		
		System.out.println( "Calendar를 이용한 답은 ? : " + day2);

	}//main

	public static String solution(int a, int b) {
		String answer = "";

		int[] date = { 31,29,31,30,31,30,31,31,30,31,30,31 };

		String[] days = { "THU" , "FRI" , "SAT" ,"SUN" ,"MON", "TUE", "WED" ,} ;

		if ( a > 1 ) {
			for ( int i=0; i < a-1 ; i ++ ) {
				b+=date[i];
			}
		}
		
		answer = days[ b % 7 ];

		return answer;
	}
	
    public static String getDayName(int month, int day){
        Calendar cal = new Calendar.Builder().setCalendarType("iso8601").setDate(2016, month - 1, day).build();
        return cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("ko-KR")).toUpperCase();
    }

}//class
