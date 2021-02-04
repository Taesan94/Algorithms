package Basic.AlgorithmBasic.BasicAlgorithm;

import java.util.Arrays;

public class PowerSet {

	public static void main(String[] args) {

		String[] inputs = { "a" , "b" , "c" } ;

		// 포함하는 경우, 포함하지 않는 경우를 구분한다.
		int[] flag = new int[inputs.length];

		int answer = makePowerSet(inputs,flag,0);


	}
	
	
	static int makePowerSet(String[] inputs, int[] flag , int index) {

		int answer = 0 ;
		
		System.out.println(" flag : " + Arrays.toString(flag) + " index : " + index );
		
		if( index == inputs.length ) {

			for ( int i = 0 ; i < flag.length; i++ ) {
				// flag는 1일때만 출력한다.
				if(flag[i] == 1 ) System.out.print(inputs[i]+" ");
			}
			System.out.println();
			return 1 ;
		}

		// 핵심은 포함 유,무를 int[]배열에서 1,0으로 구분한다.
		// 인자 값으로 index값을 하나씩 늘려가면서 재귀로 전체탐색이 가능하도록 의도한다.
		System.out.println(inputs[index] + "를 포함하는 경우 ");
		// 포함하는 경우와
		flag[index] = 1 ; // 포함한다 !
		answer += makePowerSet(inputs, flag, index+1); // input는 출력해주기위한용도고 , flag는 index값에따라 포함체크해주고 , index는 length까지되면 return처리해준다.
		
		System.out.println(inputs[index] + "를 포함하지 않는 경우 ");

		// 포함하지 않는 경우
		flag[index] = 0 ; // 포함하지 않는다 !
		answer += makePowerSet(inputs, flag, index+1);

		return answer;
	}

}
