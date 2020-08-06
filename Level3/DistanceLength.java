package Programmers.Level3;

public class DistanceLength {

	public static void main(String[] args) {
		String dirs = "LLLLLLLLLLLLL";
		
		solution(dirs);
	}
	
	//상,하,우,좌
	static int[] X = {-1, 1, 0, 0};
	static int[] Y = {0, 0, 1, -1};
	static String XY = "UDRL";

    public static int solution(String dirs) {
        int answer = 0;
        
        int prevX = 5;
        int prevY = 5;
        
        boolean [][][][] visited = new boolean[11][11][11][11];
        
        for (int i = 0; i < dirs.length(); i++) {	

        	int command = 0;
        	
        	while (dirs.charAt(i) != XY.charAt(command)) {
        		command++;
        	}
        	
        	int nextX = prevX + X[command];
        	int nextY = prevY + Y[command];
        	
        	if (nextX >= 0 && nextX <= 10 && nextY >= 0 && nextY <= 10) {
        		if (!visited[prevX][prevY][nextX][nextY] && !visited[nextX][nextY][prevX][prevY]) {
        			visited[prevX][prevY][nextX][nextY] = true;
        			visited[nextX][nextY][prevX][prevY] = true;
        			answer++;
        		}
        		
        		prevX = nextX;
        		prevY = nextY;
        	}
        }
        System.out.println("answer : " + answer);
        return answer;
    }
    
    
}
