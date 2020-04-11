package Programmers.Level2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FileNmSort {

	public static void main(String[] args) {
		

		// 1. 그냥 sort하면 대문자가 먼저 정렬된다. ( ASCII코드가 앞번이라 그런 것 같다.. )
		String[] files = {
				// "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"
				// "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"
				// "F-9","F-10","F-0011","F-012","F-12","F-13","F-014"
				//"MUZI01.zip", "muzi1.png"
				 "F15","F13","1foo010bar020.zip"
				 // a, b, c => [a b c ]
				// "a1.zzz" , "A1.aaa"

		};

		String[] result = solution2(files);

		System.out.println(" result : " + Arrays.toString(result));

	}

	public static String[] solution(String[] files) {

		Arrays.sort(files, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				
				String h1 = o1.split("[0-9]")[0];
				String h2 = o2.split("[0-9]")[0];
				
				int result = h1.toLowerCase().compareTo(h2.toLowerCase());

				if ( result == 0 ) {
					
					// 문자열이 같은 경우 숫자를 비교한다.
					result = findNum(o1,h1)-findNum(o2,h2);
					System.out.println(" findNum(o1) : " +  findNum(o1,h1) + " , findNum(o2 ) : " +  findNum(o2,h2));
					
					/* 이 조건을 넣고, 안넣고 결과가 틀렸다...
					 * 잘 모르면 함부로 넣지말자 ㅠㅠ
					 * 
					// o2가 큰경우, o1이 우선순위가 높다.
					if( result < 0 ) return -1;
					// o2가 작거나 같은경우, 숫자도 같을때도, 먼저들어온 o1이 먼저다.
					else if ( result >= 0 ) return 1;
					*/
				}
				return result;
			}
		});
		
		return files;
	}

	private static int findNum( String s, String h ) {
		
		s = s.replace(h, "");
		
		String result ="";
		
		for( char c : s.toCharArray()) {
			if( Character.isDigit(c) && result.length() < 5 ) {
				result+=c;
			}else
				break;
		}

		return Integer.valueOf(result);
	}
	
	private static String[] solution2(String[] files) {
		
	    Arrays.sort(files, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	            // 첫번째 오브젝트 head, num 추출
	            String head1 = s1.split("[0-9]")[0];
	            
	            System.out.println( " # : " +  Arrays.toString(s1.split("[0-9]")));
	            
	            s1 = s1.replace(head1, "");
	            head1 = head1.toUpperCase();
	            
	            String tempNum = "";
	            for(char c : s1.toCharArray()) {
	                if(Character.isDigit(c) && tempNum.length() < 5) {
	                    tempNum += c;
	                } else {
	                    break;
	                }
	            }
	            int num1 = Integer.parseInt(tempNum);
	            
	            // 두번째 오브젝트 head, num 추출
	            String head2 = s2.split("[0-9]")[0];
	            s2 = s2.replace(head2, "");
	            head2 = head2.toUpperCase();
	            
	            tempNum = "";
	            for(char c : s2.toCharArray()) {
	                if(Character.isDigit(c) && tempNum.length() < 5) {
	                    tempNum += c;
	                } else {
	                    break;
	                }
	            }
	            int num2 = Integer.parseInt(tempNum);
	            
	            // 비교 처리
	            return head1.equals(head2) ? num1 - num2 : head1.compareTo(head2); 
	        }
	    });
	    
	    return files;
	}

}
