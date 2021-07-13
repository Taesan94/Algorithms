package Programmers;

import java.util.*;

class Temp {

    static String[] arr = {
            "무지", "콘", "어피치", "제이지", "프로도", "네오", "튜브", "라이언"
    };

    static void debug(List<Integer> list, Stack<int[]> stack, int k) {
        System.out.println("=== print ===");
        for (int i = 0; i < list.size(); i++) {
            if (i == k)
                System.out.printf("%d : [%s]\n", i, arr[list.get(i)]);
            else
                System.out.printf("%d : %s\n", i, arr[list.get(i)]);
        }

        Iterator itr = stack.iterator();
        System.out.println("--- remove data ---");
        while (itr.hasNext()) {
            int[] data = (int[])itr.next();
            System.out.printf("[%d , %s]\n", data[0], arr[data[1]]);
        }
        System.out.println("--- ----- ---- ---");

    }

    static int atoi(String s) {
        int value = 0;
        for (int i = 2; i < s.length(); i++) {
            value = (value * 10) + (s.charAt(i) - '0');
        }
        return value;
    }

    public static String solution(int n, int k, String[] cmd) {

        StringBuilder sb = new StringBuilder();
        Stack<int[]> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            sb.append('O');
            list.add(i);
        }
        for (String s : cmd) {
            // System.out.printf("inst : %s, k : %d\n" ,s, k);

            if (s.charAt(0) == 'U') {
                k -= atoi(s);
            } else if (s.charAt(0) == 'D') {
                k += atoi(s);
            } else if (s.charAt(0) == 'C') {
                stack.add(new int[] {k, list.get(k)});
                list.remove(k);
                if (k >= list.size() && list.size() > 0) {
                    k = list.size() - 1;
                }
            } else if (s.charAt(0) == 'Z' && !stack.isEmpty()) {
                int[] data = stack.pop();
                list.add(data[0], data[1]);
                if (data[0] <= k)
                    k++;
            }
            // debug(list, stack, k);
            // System.out.println(list.toString());
        }

        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop()[1], 'X');
            // System.out.println(Arrays.toString(stack.pop()));
        }
        return sb.toString();
    }

    static void node_back(int n) {
        for (int i = 0; i < n; i++) {
            ptr = ptr.prev;
        }
    }

    static void node_front(int n) {
        for (int i = 0; i < n; i++) {
            ptr = ptr.next;
        }
    }

   static Node ptr;

    public static String solution2(int n, int k, String[] cmd) {

        StringBuilder sb = new StringBuilder();
        Stack<Node> stack = new Stack<>();

        Node prev = new Node(0, null, null);
        Node ptr = prev;

        sb.append('O');
        for (int i = 1; i < n; i++) {
            sb.append('O');
            Node curr = new Node(i, prev, null);
            prev.next = curr;
            if (i == k)
                ptr = curr;
            prev = curr;
        }
        System.out.println(ptr.toString());
        for (String s : cmd) {
            // System.out.printf("inst : %s, k : %d\n" ,s, k);

            if (s.charAt(0) == 'U') {
                node_front(atoi(s));
            } else if (s.charAt(0) == 'D') {
                node_back(atoi(s));
            } else if (s.charAt(0) == 'C') {
                stack.add(ptr);
                if (ptr.prev != null)
                    ptr.prev.next = ptr.next;
                if (ptr.next != null)
                    ptr.next.prev = ptr.prev;
                ptr = ptr.next != null ? ptr.next : ptr.prev;
            } else if (s.charAt(0) == 'Z' && !stack.isEmpty()) {
                Node data = stack.pop();
                if (data.prev != null)
                    data.prev.next = data;
                if (data.next != null)
                    data.next.prev = data;
            }
        }
        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop().data, 'X');
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // String[] arr = {"C", "C", "D 1", "C", "Z", "C"};
        String[] arr = {"C", "C", "C", "Z", "C"};

        System.out.println("answer : " + solution(4, 3, arr));

        System.out.println("answer : " + solution2(4, 3, arr));

        //        String[] arr2 = {"D 3", "C", "U 100" ,"C"};
        //        System.out.println("answer : " + solution(300000, 0, arr2));
    }

    static class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            if (prev != null)
                sb.append("prev=").append(prev.data).append(", ");
            sb.append("data=").append(data);
            if (next != null)
                sb.append(", next=").append(next.data);
            sb.append("}");
            return sb.toString();
        }
    }
}