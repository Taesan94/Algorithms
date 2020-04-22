package Programmers.BackJoon.Search;

import java.util.*;

public class WhitBlock {
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		int r=0;
		for(int i=0; i<8; i++) {
			String a=s.next();
			for(int j=i%2; j<8; j+=2)if(a.charAt(j)=='F')r++;
		}
		System.out.print(r);
	}
}
