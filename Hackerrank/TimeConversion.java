package Programmers.Hackerrank;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TimeConversion {
	
    static String timeConversion(String s) {
    	
    	String[] arr = s.split(":");
    	
    	String hour = arr[0];
    	String minute = arr[1];
    	String second = arr[2].substring(0,2);
    	String amPm = arr[2].substring(2, arr[2].length());
    	
    	// System.out.printf("hour : %s , minute : %s, second : %s, amPm : %s\n",hour, minute, second, amPm);
    	
    	if(amPm.equals("PM")) {
    		int h = Integer.valueOf(hour); 
    		if (h < 12) {
    			hour = String.valueOf(h + 12);
    		}
    	} else {
    		if (hour.equals("12")) {
    			hour = "00";
    		}
    	}
    	// System.out.println(Arrays.toString(arr));
    	return hour +":" + minute +":"+second;

    }

    private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		
        String s = scan.nextLine();

        String result = timeConversion(s);
        
        System.out.println("result : " + result);

		
	}

}
