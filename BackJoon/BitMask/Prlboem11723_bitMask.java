package Programmers.BackJoon.BitMask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prlboem11723_bitMask {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.valueOf(br.readLine());
		int visited = 0;

		for (int i=0; i < n; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();

			if(command.equals("add")) {
				int num = Integer.valueOf(st.nextToken());
				if ((visited & (1 << num)) == 0)
					visited |= (1 << num);
			}else if(command.equals("remove")) {
				int num = Integer.valueOf(st.nextToken());
				if ((visited & (1 << num)) > 0)
					visited &= ~(1 << num);
			}else if(command.equals("check")) {
				int num = Integer.valueOf(st.nextToken());
				if ((visited & 1 << num) == 0)
					sb.append(0 + "\n");
				else
					sb.append(1 + "\n");
			}else if(command.equals("toggle")) {
				int num = Integer.valueOf(st.nextToken());
				visited ^= (1 << num);
			}else if(command.equals("all")) {
				visited = (1 << 21) -1 ;
			}else if(command.equals("empty")) {
				visited = 0;
			}
		}
		System.out.println(sb);
	}
}
