package Programmers.KaKaoFinal_2017;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GroupPicture {

	public static void main(String[] args) {
		int n = 2 ;
		String[] data = {
				"N~F=0", "R~T>2"
		};
		int result = solution(n,data);
		System.out.println(" result : " + result );
	}
	
	public static int solution(int n, String[] data) {
		int answer = 0;

		// 8개의 문자로 만들 수 있는 모든 조합을 구한다.

		// A,C,F,J,M,N,R,T 순서대로 해당 캐릭터가 몇번째에 서있는지 ??
		int[] position = new int[8];
		boolean[] visit = new boolean[8];
		
		characters.put('A', 0);
		characters.put('C', 1);
		characters.put('F', 2);
		characters.put('J', 3);
		characters.put('M', 4);
		characters.put('N', 5);
		characters.put('R', 6);
		characters.put('T', 7);
		
		originData = data; 
		
		makePermutation(position,visit,0);

		return result;
	}
	
	static String[] originData ;
	static int result = 0 ;
	static Map<Character, Integer> characters = new HashMap();

	private static void makePermutation(int[] position, boolean[] visit, int seq) {
		
		// 모든 번호를 할당해 준 경우.
		if(seq==8) {
			for(int i=0; i<originData.length; i++) {
				System.out.println(Arrays.toString(position));
				String data = originData[i];
				int pos1 = position[characters.get(data.charAt(0))];
				int pos2 = position[characters.get(data.charAt(2))];
				
				int diff = Math.abs(pos1-pos2)-1;
						
				char operation = data.charAt(3);
				
				int n = data.charAt(4)-'0';
				
				if( (operation=='>' && !(diff>n)) || ( operation=='<' && !(diff<n)) || (operation=='=' && diff != n)) {
					return;
				}
			}
			result++;
			
			return;
		}
		
		// i번째 자리에 올 수 있는 캐릭터는 8개이다.
		// i번째에 seq번째 캐릭터를 하나씩 배치하면서 모든 조합을 찾는다.
		for(int i=0; i<8; i++) {
			if(!visit[i]) {
				visit[i] = true;
				// i번째에  seq번째 캐릭터를 위치시킨다.
				position[seq] = i;
				makePermutation(position,visit,seq+1);
				// 여기를 탄다는것은, 1번의 조합이 끝났고, 이제는 i번째 자리에 다른 캐릭터를 채워넣겠다는 뜻이다.
				visit[i] = false;
			}
		}
	}



}
