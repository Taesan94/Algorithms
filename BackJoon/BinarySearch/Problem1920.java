package Programmers.BackJoon.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem1920 {

	static int[] arr;
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int n = Integer.valueOf(scan.nextLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(scan.nextLine());

		int i = 0;
		while(st.hasMoreTokens()) {
			arr[i++] = Integer.valueOf(st.nextToken());
		}
		// 2진 탐색을 하기위해서는 반드시 데이터가 정렬되어있어야 한다.
		// 또는, 어느정도 정렬이 되어있어야 높은 효율로 탐색할 수 있다.
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));

		int m = Integer.valueOf(scan.nextLine());
		st = new StringTokenizer(scan.nextLine());

		while(st.hasMoreTokens()) {
			System.out.println(binarySearch(0, n - 1, Integer.valueOf(st.nextToken())));
		}

	}

	static int binarySearch(int start, int end,  int num) {

		// start ~ end 범위를 계속 바꿔나갈껀데,
		while (start <= end) { // start는 end보다 반드시 작아야한다. 같아지는 경우에도 한번도 찾는 num이 맞는지를 확인한다.
			
			int mid = (start + end) / 2; // 해당 범위의 가운데 위치 index를 구한다.
			int value = arr[mid];  // 중간 범위의 값을 pivot으로 잡는다 !
			
			// System.out.printf("start : %d, end : %d , num : %d, value : %d , mid : %d\n" , start, end , num, value, mid);
			
			if (num < value) { // 찾고자 하는 값보다 pivot값이 크다면, 찾고자하는 값은 더 좁은 범위에 존재한다.
				end = mid - 1; // 범위를 start~ 중간으로 변경. 
			} else if (num > value) { // 찾고자 하는 값이 더 작다면, 더 큰 범위에 존재한다.
				start = mid + 1; // 범위를 중간 ~ end로 변경. 
			} else if (num == value) {  // 찾았다면 ! 있다고 1을 return해준다.
				return 1;
			}
		}
		return 0;
	}

}
