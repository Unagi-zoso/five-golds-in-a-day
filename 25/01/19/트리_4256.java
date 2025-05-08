import java.util.*;
import java.io.*;

public class 트리_4256 {
    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }
    }

    static int curPreIdx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine()); // 노드 개수

            int[] preorder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] inorder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            int[] mapInorderIndex = new int[10005];
            for (int i = 0; i < n; i++) {
                mapInorderIndex[inorder[i]] = i;
            }

            curPreIdx = 0;
            Node root = makeTree(preorder, inorder, mapInorderIndex, 0, n - 1);
            StringBuilder sb = new StringBuilder();
            makePostorderStr(sb, root);
            System.out.println(sb.toString());
        }

        bw.flush();
        bw.close();
    }

    static Node makeTree(int[] preorder, int[] inorder, int[] mapInorderIndex, int st, int lst) {
        if (st > lst) return null;

        int curValue = preorder[curPreIdx++];
        Node newNode = new Node(curValue);
        int inorderIdx = mapInorderIndex[curValue];
        
        newNode.left = makeTree(preorder, inorder, mapInorderIndex, st, inorderIdx - 1);
        newNode.right = makeTree(preorder, inorder, mapInorderIndex, inorderIdx + 1, lst);

        return newNode;
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