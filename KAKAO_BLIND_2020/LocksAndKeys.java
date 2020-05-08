package Programmers.KAKAO_BLIND_2020;

import java.util.ArrayList;
import java.util.List;

public class LocksAndKeys {

	static List<MapInfo> result = new ArrayList<>();
	static List<MapInfo> keys = new ArrayList<>();
	static List<MapInfo> moveKeys = new ArrayList<>();

	public static void main(String[] args) {
		int[][] key = {
				{0, 0, 0}, {1, 0, 0}, {0, 1, 1}
		};

		int[][] lock = {
				{1, 1, 1}, {1, 1, 0}, {1, 0, 1}
		};
		
		boolean result = solution(key,lock);

		System.out.println(" result : " + result);

	}


	public static boolean solution(int[][] key, int[][] lock) {
		boolean answer = false;

		for( int i=0; i<lock.length; i++ ) {
			for( int j=0; j<lock[i].length; j++ ) {
				if(lock[i][j]==0) result.add(new MapInfo(i,j));
			}
		}
        
		if(result.size() < 1 ) return answer;

		// 90,180,270,360도씩 회전하면서 확인.
		for( int i=0; i<4; i++) {
            
			key = spin(key);
			if( keys.size() > 0 ) {
				for ( int j=0; j< keys.size(); j++ ) {
					answer = moveAndPossible(keys.get(j),lock);
					if(answer) return answer;
				}
			}
		}
		return answer;
	}

	// 회전하면서 열쇠의 좌표를 기록.
	// 열쇠의 좌표 시작점마다 자물쇠에 연결가능한지를 봐야한다.
	private static int[][] spin( int[][] key ) {

		keys= new ArrayList<MapInfo>();

		int len = key.length;
		int[][] spinKey = new int[len][len];

		len--;

		for(int i=0; i<key.length; i++ ) {
			for( int j=0; j<key[i].length; j++ ) {
				spinKey[j][len-i] = key[i][j] ;
				if( key[i][j] == 1 ) keys.add(new MapInfo(i,j));
			}
		}
		
		return spinKey;
	}

	// 해당 문자열을 자물쇠에 맞는 좌표로 옮긴다.
	private static boolean moveAndPossible(MapInfo point, int[][] lock) {
		
		boolean answer = false;
		
		for( int i=0; i<result.size(); i++ ) {
			
			moveKeys = new ArrayList<MapInfo>();
			MapInfo firstInfo = result.get(i);
			int diffX = firstInfo.x - point.x;
			int diffY = firstInfo.y - point.y;
			
			for( int j=0; j< keys.size(); j++ ) {
				MapInfo m = keys.get(j);
				moveKeys.add(new MapInfo(m.x+diffX,m.y+diffY));
			}
			answer = possible(lock);
			if(answer) return answer;
		}
		
		return answer;
	}

	private static boolean possible(int[][] lock) {
		
		if( moveKeys.size() < result.size() ) return false ;

		// 자물쇠를 열 수 있는지 확인.
		for(int i=0; i< result.size(); i++) {
			MapInfo loc = result.get(i);
			
			boolean visit = false;
			
			for( int j=0; j< moveKeys.size(); j++ ) {
				MapInfo key = moveKeys.get(j);
				if( loc.check(key) ) visit = true;
			}
			if(!visit) return false;
		}

		// 자물쇠랑, 열쇠의 돌기가 부딪히는 경우를 체크한다.
		for( int i=0; i<moveKeys.size(); i++ ) {

			MapInfo key = moveKeys.get(i);

			if( key.x>=0 && key.y>=0 && key.x<lock.length && key.y<lock[0].length ) {
				if( lock[key.x][key.y] == 1 ) {
					System.out.println("아얏");
					return false;
				}
			}
		}
		return true;
	}

	static class MapInfo{

		int x;
		int y;

		MapInfo(){}

		MapInfo(int x, int y ){
			this.x=x;
			this.y=y;
		}

		public boolean check(MapInfo m) {
			return ( this.x==m.x && this.y==m.y);
		}

		@Override
		public String toString() {
			return "Map [x=" + x + ", y=" + y + "]";
		}
	}

}
