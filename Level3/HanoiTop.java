package Programmers.Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HanoiTop {
	
	public static void main(String[] args) {
		solution(6);
	}
	static List<int[]> result = new ArrayList<>();
	
    public static int[][] solution(int n) {
    	
    	hanoi(n, 1, 3, 2);

    	for(int[] a : result) {
    		System.out.println(Arrays.toString(a));
    	}
        return null;
    }
    
    private static void hanoi(int n, int from, int to, int via) {
    	int[] move = {from, to};
    	// System.out.println(" n : " + n +", from : " + from +", to : " + to +", via : " + via);
    	
    	if (n == 1){
    		result.add(move);
    	}else{
    		//System.out.println((n - 1)+" 개의 블럭을 " + from + "에서, " + via+"로 이동");
    		hanoi(n - 1, from, via, to);
    		result.add(move);
    		hanoi(n - 1, via, to, from);
    	}
    }
}
