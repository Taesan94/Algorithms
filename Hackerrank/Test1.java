package Programmers.Hackerrank;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test1 {

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.HOUR, 9);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println(df.format(cal.getTime()));
	}
}
