package Hackerrank;

import java.util.Arrays;

public class IceCreadmParlor {

	public static void main(String[] args) {
		
		int[] cost = {
			//  1, 4, 5, 3, 2	
			// 2,2,4,3
			//	7 ,2 ,5 ,4 ,11
				1,4,3,3,1,2,1
		};
		int money = 3;
		whatFlavors(cost, money);
	}
	
    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
    	
    	Pair[] infos = new Pair[cost.length];
    	
    	for (int i = 0; i < cost.length; i++) {
    		infos[i] = new Pair(cost[i] , i + 1); 
    	}
    	Arrays.sort(infos);
    	System.out.println(Arrays.toString(infos));
    	int l = 0;
    	int r = infos.length - 1;
    	
    	while (true) {
    		if (infos[l].cost + infos[r].cost > money)
    			r--;
    		else if (infos[l].cost + infos[r].cost < money)
    			l++;
    		else if (infos[l].cost + infos[r].cost == money) {
    			if (infos[l].idx < infos[r].idx)
    				System.out.println(infos[l].idx +" " + infos[r].idx);
    			else
    				System.out.println(infos[r].idx +" " + infos[l].idx);
    			break;
    		}
    	}
    }
    
    static class Pair implements Comparable<Pair> {
    	int cost;
    	int idx;
    	
    	public Pair(int cost, int idx) {
    		this.cost = cost;
    		this.idx = idx;
    	}
    	public int compareTo(Pair o) {
    		int result = this.cost - o.cost;
    		if (result == 0)
    			result = this.idx - o.idx;
    		return result;
    	}
		@Override
		public String toString() {
			return "Pair [cost=" + cost + ", idx=" + idx + "]";
		}
    }

}
