package Programmers.Level3_Retry1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class ThanksGivingTraffic {

	public static void main(String[] args) {
		
		String[] lines1 = {
				"2016-09-15 01:00:04.001 2.0s",
				"2016-09-15 01:00:07.000 2s"
		};
		
		String[] lines2 = {
				"2016-09-15 01:00:04.002 2.0s",
				"2016-09-15 01:00:07.000 2s"
		};
		
		String[] lines3 = {
				"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s"
		};
		
		String[] lines4 = {
				"2016-09-15 01:00:07.000 2s",
				"2016-09-15 01:00:07.000 0.001s",
				"2016-09-15 01:00:07.000 0.001s",
				"2016-09-15 01:00:07.000 0.001s",
				"2016-09-15 01:00:10.000 3s",
		};

//		System.out.println("Result : " + solution(lines1));
//		 System.out.println("Result : " + solution(lines2));
		 System.out.println("Result : " + solution(lines3));
//		 System.out.println("Result : " + solution(lines4));
	}

	public static int solution(String[] lines) {

		SimpleDateFormat frmt = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss.SSS");

		List<Calendar> starts = new ArrayList<>();
		List<Calendar> ends = new ArrayList<>();

		for (String line : lines) {
			String[] arr = line.split(" ");
			try {
				Calendar start = Calendar.getInstance();
				Calendar end = Calendar.getInstance();
				start.setTime(frmt.parse(arr[0] + " " + arr[1]));
				end.setTime(frmt.parse(arr[0] + " " + arr[1]));
				int wkTime = (int)(Double.parseDouble(arr[2].substring(0, arr[2].length() - 1)) * -1000);
				start.add(Calendar.MILLISECOND, wkTime + 1);
				starts.add(start);
				ends.add(end);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		// Collections.sort(starts);

		int max = 0;
		for (int i = 0; i < starts.size(); i++) {
			long e = ends.get(i).getTimeInMillis() + 1000;
			int cnt = 0;
			for (int j = 0; j < ends.size(); j++) {
				long nextS = starts.get(j).getTimeInMillis();
				if (nextS < e) { // 60초에는 자기자신도 포함하니깐, =조건은 빠짐.
					System.out.println("endTime : " + frmt.format(ends.get(i).getTime()) +", startTime["+j+"] : " + frmt.format(starts.get(j).getTime()));
					cnt++;
				}
			}
			max = Math.max(cnt, max);
			System.out.println("i : " + i +"일 때 max : " + max);
		}
		return max;
	}

}
