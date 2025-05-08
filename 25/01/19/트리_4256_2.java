import java.util.*;
import java.io.*;

public class 트리_4256_2 {
    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }
    }

    static int curPostIdx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine()); // 노드 개수

            int[] postorder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] inorder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            int[] mapInorderIndex = new int[10005];
            for (int i = 0; i < n; i++) {
                mapInorderIndex[inorder[i]] = i;
            }

            curPostIdx = n - 1;
            Node root = makeTree(postorder, inorder, mapInorderIndex, 0, n - 1);
            StringBuilder sb = new StringBuilder();
            makePostorderStr(sb, root);
            System.out.println(sb.toString());
        }

        bw.flush();
        bw.close();
    }

    static Node makeTree(int[] postorder, int[] inorder, int[] mapInorderIndex, int st, int lst) {
        if (st > lst) return null;

        int curValue = postorder[curPostIdx--];
        Node node = new Node(curValue);
        int inorderIdx = mapInorderIndex[node.value];
        node.right = makeTree(postorder, inorder, mapInorderIndex, inorderIdx + 1, lst);
        node.left = makeTree(postorder, inorder, mapInorderIndex, st, inorderIdx - 1);

        return node;
    }

    static void makePostorderStr(StringBuilder sb, Node node) {
        if (node == null) return;
        makePostorderStr(sb, node.left);
        makePostorderStr(sb, node.right);
        sb.append(node.value).append(" ");
    }
}

// preorder 의 순서는 그 트리의 루트를 첫 인덱스에서 다루며 inorder 에선 루트를 기준으로 서브트리 구조를 알 수 있다.
// preorder 순서로 접근하면 루트를 구할 수 있다.
// inorder 에서 루트를 알면 좌우 서브트리 여부를 알 수 있다.
// postorder inorder 조합으로도 가능하다. 중요한 것은 inorder 가 트리의 구조를 가지고 있고 정방향 preorder, 역방향 postorder 둘 중 하나로 
// 함수의 흐름과 서브트리 루트 접근 순서가 같다면 가능하다. 참 기묘한 문제다.. 기묘하다 정말..