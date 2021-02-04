package Basic.AlgorithmBasic.Graph.exam00;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test1 {

	public static void main(String[] args) {
		int[] answer = {};

		int[][] v = {
				{1,4},
				{3,4},
				{3,10}
		};

		Map<Integer,Integer> x = new HashMap<>();
		Map<Integer,Integer> y = new HashMap<>();

		for( int[] pos : v ){

			int posX = pos[0];
			int posY = pos[1];

			if( (x.getOrDefault(posX,0)+1 ) == 2 ) x.remove(posX);   
			else x.put(posX,1);

			if( (y.getOrDefault(posY,0)+1 ) == 2 ) y.remove(posY);   
			else y.put(posY,1);
		}
		
		answer = new int[]{ x.keySet().iterator().next(), y.keySet().iterator().next() };
		
		System.out.println(Arrays.toString(answer));

	}

}
