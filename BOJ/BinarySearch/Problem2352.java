package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2352 {

    static int N;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.valueOf(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        int[] result = new int[N];
        result[0] = arr[0];
        int idx = 1;

        for (int i = 1; i < N; i++) {

            if (result[idx - 1] < arr[i]) // 뒤로 이어붙이는 경우.
                result[idx++] = arr[i];
            else if (result[0] > arr[i]) // 맨 앞의 숫자가 바뀌는 경우.
                result[0] = arr[i];
            else { // result의 중간값으로 들어가야하는 경우. (변경)
                int changeIdx = Arrays.binarySearch(result, 0, idx, arr[i]); // 배열의 범위에서 arr[i]의 값 이상이 처음 존재하는 위치를 반환한다.
                changeIdx = (changeIdx < 0) ? -changeIdx - 1 : changeIdx; // lower bound 를 return 한 경우... check
                result[changeIdx] = arr[i];
            }
        }
        System.out.println(idx);
    }
 }
