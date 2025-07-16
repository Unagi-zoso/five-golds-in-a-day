/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> r1LeafCont = new ArrayList<>();
        List<Integer> r2LeafCont = new ArrayList<>();
        rec(root1, r1LeafCont);
        rec(root2, r2LeafCont);
        return r1LeafCont.equals(r2LeafCont);
    }

    public void rec(TreeNode n, List<Integer> cont) {
        if (n.left == null && n.right == null) {
            cont.add(n.val);
            return;
        }
        if (n.left != null) rec(n.left, cont);
        if (n.right != null) rec(n.right, cont);
    }
}