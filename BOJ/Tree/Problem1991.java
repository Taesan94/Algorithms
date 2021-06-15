package BOJ.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem1991 {

    static int N;
    static Node[] Tree;
    static StringBuilder sb = new StringBuilder();

    static void preorder(int v) {
        sb.append((char)('A' + v));
        if (Tree[v].left != '.')
            preorder(Tree[v].left - 'A');
        if (Tree[v].right != '.')
            preorder(Tree[v].right - 'A');
    }

    static void inorder(int v) {
        if (Tree[v].left != '.')
            inorder(Tree[v].left - 'A');
        sb.append((char)('A' + v));
        if (Tree[v].right != '.')
            inorder(Tree[v].right - 'A');
    }

    static void postorder(int v) {
        if (Tree[v].left != '.')
            postorder(Tree[v].left - 'A');
        if (Tree[v].right != '.')
            postorder(Tree[v].right - 'A');
        sb.append((char)('A' + v));
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.valueOf(br.readLine());
        Tree = new Node[N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            int  v1 = s.charAt(0) - 'A';
            char v2 = s.charAt(2);
            char v3 = s.charAt(4);

            Tree[v1] = new Node(v2, v3);
        }
        preorder(0);
        sb.append('\n');

        inorder(0);
        sb.append('\n');

        postorder(0);
        sb.append('\n');

        System.out.print(sb.toString());

    }

    static class Node {
        char left;
        char right;

        public Node(char left, char right) {
            this.left = left;
            this.right = right;
        }
    }
}
