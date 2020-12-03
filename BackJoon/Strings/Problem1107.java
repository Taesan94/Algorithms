package Programmers.BackJoon.Strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1107 {

	static String n;
	static boolean[] remocon;
	static int num;
	static int start;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		remocon = new boolean[10];
		Arrays.fill(remocon, true);

		n = br.readLine();
		num = Integer.valueOf(n);
		int m = Integer.valueOf(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		if (num == 100) {
			System.out.println(0);
			return;
		}
		for (int i = 0; i < m; i++) {
			remocon[Integer.valueOf(st.nextToken())] = false;
		}
		// 위아래 버튼으로만 해서 가는 경우
		int min = Math.abs(num - 100);
		
		if (m == 10)
		{
			System.out.println(min);
			return ;
		}

		// 한번에 갈 수 있는지?
		boolean oneQ= true;

		char[] arr = n.toCharArray();
		for (char c : arr) {
			int btn = c - '0';
			if (!remocon[btn]) {
				oneQ = false;
				break;
			}
		}
		if (oneQ)
			min = Math.min(min, n.length());
		start = n.length() - 1;
		min = Math.min(min, findMin(arr, min, n.length() - 1));
		
		if (n.length() == 1) {
			char[] arr2 = new char[2];
			arr2[1] = arr[0];
			arr2[0] = '0';
			start = 1;
			min = Math.min(min, findMin(arr2, min, 1));
		}
		
		if (n.length() == 2) {
			for (int i = 9; i >= 0; i--) {
				if (remocon[i])
				{
					min = Math.min(min, (num - i) + 1);
					break ;
				}
			}
		}
		
		if (n.length() >= 3) {
			n = n.substring(1, n.length());
			start = n.length() - 1;
			arr = n.toCharArray();
			min = Math.min(min, findMin(arr, min, n.length() - 1));
		}

		System.out.println(min);
		
	}
	
	static int findMin(char[] arr, int min, int cnt) {
		List<Integer> list = new ArrayList<>();
		for (char c : arr) {
			int btn = c - '0';
			System.out.println("## btn : " + btn);
			// 현재 번호를 바로 눌를 수 있는 경우.
			if (remocon[btn]) {
				setList(list, cnt, (int)(Math.pow(10, cnt) * btn));
			}

			boolean lPos = false;
			int lIdx = btn - 1;
			int lCnt = 0;
			// 현재 번호에서 좌측으로 최소
			while (lIdx >= 0) {
				lCnt++;
				if (remocon[lIdx]) {
					lPos = true;
					break ;
				}
				lIdx--;
			}
			boolean rPos = false;
			int rIdx = btn + 1;
			int rCnt = 0;
			while (rIdx < 10) {
				rCnt++;
				// System.out.println("remocon[" +rIdx+"] : "+  remocon[rIdx]);
				if (remocon[rIdx]) {
					rPos = true;
					break;
				}
				rIdx++;
			}
			System.out.printf("lCnt : %d , lIdx : %d, rCnt : %d, rIdx : %d\n",lCnt,lIdx,rCnt,rIdx);
			// System.out.println("l :" + lPos +", r : " + rPos);

			if (lPos && !rPos) {
				setList(list, cnt, (int)(Math.pow(10, cnt) * lIdx));
			} else if (!lPos && rPos) {
				setList(list, cnt, (int)(Math.pow(10, cnt) * rIdx));
			} else if (rCnt == lCnt) {
				List<Integer> one = new ArrayList<>();
				one.addAll(list);
				setList(one, cnt, (int)(Math.pow(10, cnt) * lIdx));
				List<Integer> two = new ArrayList<>();
				two.addAll(list);
				setList(two, cnt, (int)(Math.pow(10, cnt) * rIdx));
				list.clear();
				list.addAll(one);
				list.addAll(two);
			} else if (rCnt < lCnt){
				setList(list, cnt, (int)(Math.pow(10, cnt) * rIdx));
			} else if (lCnt < rCnt){
				setList(list, cnt, (int)(Math.pow(10, cnt) * lIdx));
			}
			cnt--;
		}
		System.out.println(list.toString());
		for (int value : list) {
			min = Math.min(min, (Math.abs(num - value) + n.length()));
		}
		return min;
	}

	static void setList(List<Integer> list, int cnt, int value) {
		if (cnt == start) {
			System.out.println("here");
			list.add(value);
		}
		else {
			for (int i = 0; i < list.size(); i++) {
				list.set(i, list.get(i) + value);
			}
		}
	}

}
