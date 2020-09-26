package Programmers.KAKAO_BLIND_2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileNameSort {

	public static void main(String[] args) {
		
		String[] files = {
				//"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"
				"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"

		};
		
		System.out.println("result : " +  Arrays.toString(solution(files)));
		
	}
	
    public static String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        int fileCnt = 0;
        
        List<FileInfo> list = new ArrayList<>();
        for (String f : files) {
        	
        	int i = 0;
        	
        	StringBuilder head = new StringBuilder("");
        	
        	while (i < f.length() && !(f.charAt(i) >= '0' && f.charAt(i) <= '9')) {
        		head.append(f.charAt(i));
        		i++;
        	}
        	
        	StringBuilder number = new StringBuilder("");
        	int cnt = 0;
        	while (i < f.length() && f.charAt(i) >= '0' && f.charAt(i) <= '9' && cnt < 5) {
        		number.append(f.charAt(i));
        		i++;
        		cnt++;
        	}
        	list.add(new FileInfo(head.toString().toLowerCase(), Integer.valueOf(number.toString()), fileCnt++));
        }
        
        Collections.sort(list);
        
        for (int i = 0; i < list.size(); i++) {
        	answer[i] = files[list.get(i).idx];
        }
        
        return answer;
    }
    
    static class FileInfo implements Comparable<FileInfo>{
    	
    	String head;
    	int number;
    	int idx;
    	
    	FileInfo (String head, int number, int idx){
    		this.head = head;
    		this.number = number;
    		this.idx = idx;
    	}
    	
    	@Override
    	public int compareTo(FileInfo o) {
    		
    		int result = this.head.compareTo(o.head);
    		
    		if (result == 0)
    			result = this.number - o.number;
    		
    		return result == 0 ? this.idx - o.idx : result;
    	}
    	
    }

}
