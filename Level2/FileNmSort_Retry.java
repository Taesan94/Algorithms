package Programmers.Level2;

import java.util.Arrays;
import java.util.Comparator;

public class FileNmSort_Retry {

	public static void main(String[] args) {


		// 1. 그냥 sort하면 대문자가 먼저 정렬된다. ( ASCII코드가 앞번이라 그런 것 같다.. )
		String[] files = {
				"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"
				// "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"
				// "F-9","F-10","F-0011","F-012","F-12","F-13","F-014"
				//"MUZI01.zip", "muzi1.png"
				// "F15","F13","1foo010bar020.zip"
				// a, b, c => [a b c ]
				// "a1.zzz" , "A1.aaa"

		};

		String[] result = solution(files);

		System.out.println(" result : " + Arrays.toString(result));

	}

	public static String[] solution(String[] files) {
		
		System.out.println( "Before : " + Arrays.toString(files));
		
		Arrays.sort( files , new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				
				String a = o1.toString().split("[0-9]")[0];
				String b = o2.toString().split("[0-9]")[0];
				
				int result = a.toLowerCase().compareTo(b.toLowerCase());
				
				if( result==0 ) result = findNum(o1.replace(a, ""))-findNum(o2.replace(b, ""));
				
				return result;
			}
		});
		
		System.out.println( "After : " + Arrays.toString(files));
		
		return files;
	}
	
	private static int findNum(String s) {
		String result= "";
		
		for( char c : s.toCharArray() ) {
			if( Character.isDigit(c) && result.length() < 5 ) {
				result+=c;
			}else break;
		}
		
		System.out.println( " s  : " + s +", result : " + result );
		
		return Integer.valueOf(result);
	}

}
