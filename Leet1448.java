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
    public int goodNodes(TreeNode root) {
        return rec(root, root.val);
    }

    public int rec(TreeNode root, int rootVal) {
        int ret = 0;
        if (root.val >= rootVal) {
            ret++;
            
        }
        if (root.left != null) ret += rec(root.left, Math.max(rootVal, root.val));
        if (root.right != null) ret += rec(root.right, Math.max(rootVal, root.val));
        return ret;
    }
}