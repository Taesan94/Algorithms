package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Problem12738 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        int[] nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.valueOf(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();

        list.add(nums[0]);
        for (int i = 1; i < n; i++) {
            System.out.println(list.toString());
            int num = nums[i];
            if (num > list.get(list.size() - 1))
                list.add(num);
            else {
                int l = 0;
                int r = list.size() - 1;

                while (l < r) {
                    int mid = (l + r) / 2;
                    if (list.get(mid) >= num)
                        r = mid;
                    else
                        l = mid + 1;
                }
                /*
                 - 결국, 작은 값이 뒤에나오면 해당 값을 list에 적절한 위치에 넣어주는게 ..
                   - 이전의 최댓 값(list.size() - 1)보다 작거나 같은 경우에, list의 값을 변경한다.
                   - case1 => 6, 10 7 8 1 2 3
                 - 위 케이스 돌려보면 조금이해가 된다.
                   - 마지막 값보다 작은 값들로 list를 재구성한다.
                   - 여기서, 재구성한 list가 실제 증가수열의 답을 의미하는것이아니다. 크기를 계산하기 위함에 집중하자.
                   - 보면 7,8의 리스트가 1,8로 바뀐다.
                   - 실제로 1부터 시작하는 부분증가수열은 [1, 8]이아니다.
                     ㅇ 만약 숫자, 여기서 끝났다고 생각해보자.(4, 10 7 8 1이였다면)
                     ㅇ 종료된 리스트의 값은 [1, 8]이 된다. 실제로 [1, 8]이 증가수열의 정확한 데이터를 의미하지는 않는다.
                     ㅇ 하지만, 이전 증가수열에서 구한 크기가 최대 값임을 알 수 있다.
                   - 이어서, 2가 삽입되면서 [1, 2]로 바뀐다. 같은 크기의 증가수열이지만 값이 바뀌어 재구성되었다.
                   - 이후에 3이들어왔을 때는, 마지막 증가수열보다 크기 때문에 붙여주기만하면 된다.
                 */
                list.set(r, num); // 지우면 틀림.
            }
        }
        System.out.println(list.toString());
        System.out.println(list.size());
    }
}