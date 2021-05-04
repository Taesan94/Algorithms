package Basic.Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class QuickSort {

    private static void quickSort(int[] arr, int start, int end, int orderBy) {

        // 이거 안해줘서 .. 고생했다.....
        // 2분할이라서 start는 계속0 , 끝은 length-1이라고 생각했는데 그러면 안된다.
        // 처음 시작점이 중간에 6번째 로들어왔으면
        // 6~10에서 분할이들어가고, 6~10내에서 또 분할이 일어나야된다.. 이걸 간과하지말자..!!

        int beforeS = start;
        int beforeE = end;

        int pivot = arr[(start + end) / 2];

        // pivot값을 기준으로 정렬한다.
        // start == end인경우는 모두 pivot에 도착했다는 의미이다.다
        // 이 때는 while은 타지않고 아래 조건에서 index위치만 ++, --해주게 된다.
        while (start <= end) {

            if (orderBy == 2) {
                while (arr[start] > pivot) start++;
                while (arr[end] < pivot) end--;
            } else {
                while (arr[start] < pivot) start++;
                while (arr[end] > pivot) end--;
            }

            if (start <= end) {
//                if (start == end) // start == end 인경우가, 모두 pivot값에 도달 한 경우이다.
//                    System.out.printf("pivot : %d, arr[start && end] : %d\n", pivot, arr[start]);
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        // 정렬이 끝난후 start, end로 무엇을해야 할까..
        // -> 어긋낫을 때 종료되니깐 ... e, s ... 이 상태로 끝나 있다.
        // ... e, s ..를 기준으로 분할을 어떻게 해야할지 고민해보자. (e는 좌측 배열의 끝을, s는 우측배열의 시작을 의미하게 됨)
        // 2분할 한다
        if (beforeS < end)
            quickSort(arr, beforeS, end, orderBy);
        if (start < beforeE)
            quickSort(arr, start, beforeE, orderBy);
    }

    public static void main(String[] args) throws Exception {

        /*
         * Quick정렬이란 ?
         *
         * pivot값을 기준으로 작은값은 왼쪽,큰값은 오른쪽으로 partition을 나눠가면서 정렬하는 방법이다.
         *
         * 평균속도 N logN
         * 최악속도 N^2 이다. => pivot값이 계속 최소, 최대값이 선택되는 경우
         *
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("배열의 크기는 ?");
        int n = Integer.valueOf(br.readLine());

        int[] arr = new int[n];
        System.out.println("배열을 입력해 주세요\nRex) \"1 2 3 4 5\"");
        StringTokenizer st = new StringTokenizer(br.readLine());
        if (st.countTokens() != n) {
			System.out.println("Warning ! 배열의 크기만큼 입력해 주세요");
			return ;
		}

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }
        System.out.println("오름차순 : [1], 내림차순 : [2]");
        int orderBy = Integer.valueOf(br.readLine());

        System.out.println("before : " + Arrays.toString(arr));
        quickSort(arr, 0, n - 1, orderBy);
        System.out.println("after : " + Arrays.toString(arr));

    }//main


}//class
