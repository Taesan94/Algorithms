package Programmers.AlgorithmBasic.BasicAlgorithm;

public class LineUp {
	
	// N명의 사람이 나란히 있을 때, 만들 수 있는 조합의 수를 구한다.

	static String[] peoples = {
		"A", "E", "I", "O", "U"
	};
	
	public static void main(String[] args) {
		
		boolean[] visit = new boolean[peoples.length];
		int[] position = new int[peoples.length];
		lineUp(position,visit,0);
	}
	
	static int cnt = 0 ;
	
	private static void lineUp(int[] position, boolean[] visit, int seq ) {
		
		if( seq == position.length) {
			cnt++;
			System.out.println("########## " + cnt+"번 째 조합 ########## ");
			
			for(int i=0; i < position.length; i++) {
				System.out.print(peoples[position[i]]+" ");
			}
			System.out.println("");
		}
		
		for( int i=0; i<position.length; i++ ) {
			if(!visit[i]) {
				visit[i]=true;
				position[seq]=i;
				lineUp(position,visit,seq+1);
				visit[i]=false;
			}
		}
	}

}
