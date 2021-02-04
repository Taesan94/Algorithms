package BOJ.Search;

import java.util.Scanner;

public class MovieDirector {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int r=666;
		while(n>0) {
			if(String.valueOf(r).contains("666"))n--;
			r++;
		}
		System.out.print(--r);
	}

}
