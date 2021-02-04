package BOJ.BitMask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Prlboem11723 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();

		int n = Integer.valueOf(br.readLine());
		int[] S = new int[20];

		for (int i=0; i < n; i++) {

			String input[] = br.readLine().split(" ");

			if (input.length > 1) {

				String command = input[0];
				int num = Integer.valueOf(input[1]);
				int num_i = num - 1;
				boolean exist = false;
				
				if (S[num_i] != 0)
					exist = true;
				if (command.equals("add") && !exist) {
					S[num_i] = 1;
				}else if (command.equals("remove") && exist) {
					S[num_i] = 0;
				}else if (command.equals("check")) {
					if (exist)
						bw.write(1 +"\n");
						//sb.append(1 +"\n");
					else
						bw.write(0 +"\n");
						//sb.append(0 +"\n");
				}else if (command.equals("toggle")) {
					if (exist)
						S[num_i] = 0;
					else
						S[num_i] = 1;
				}
			}else {
				if (input[0].equals("all")) {
					for(int j = 1; j < 21; j++) {
						S[j - 1] = j;
					}
				}else if (input[0].equals("empty")) {
					S = new int[20];
				}
			}
		}
		br.close();
		bw.flush();
		bw.close();
		System.out.println(sb);
	}
}
