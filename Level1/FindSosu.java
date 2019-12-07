package Programmers.Level1;

public class FindSosu {

	public static void main(String[] args) {

		int n = 1000000 ;

		int result = solution(n);

		System.out.println(result);

	}//main

	public static int solution(int n) {
		
		   int answer = 0;
		   
		   //일단2는 소수이다.
		   
		   //2의 배수는 소수가 안된다고 check 해준다.
		   
		   //3은 소수이다. 3의 배수는 소수가 안된다고 check 해준다.
		   
		   //4는 체크됬다.
		   
		   //5는 소수이다. 5의 배수는 소수가 안된다고 check 해준다.
		   
		   //6은 체크됬다.
		   
		   //7은 소수이다. 7의 배수는 소수가 안된다고 check 해준다.
		   
		   //최초2부터 n까지 배수들을 걸러내면 이후에 나오는 값들은 무조건 소수만 나온다.
		   
		   int[] prime = new int[n+1];
		   
		   // 0이면 소수 , 1이면 소수가 아니다.
		   
		   for ( int i = 2; i <= n ; i++ ) {
			   
			   if ( prime[i] == 1 ) continue;
			   
			   for ( int j = i*2 ; j <= n; j+=i ) {
				   prime[j] = 1;
			   }
			   
			   answer++;
		   }
		   
	       return answer;
	      }

}//class
