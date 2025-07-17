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
    public int longestZigZag(TreeNode root) {
        return rec(root, 0, 0);
    }

    public int rec(TreeNode node, int prevDir, int lev) {
        int maxLev = lev;
        if (node.left != null) {
            int nextLev = lev;
            if (lev == 0) nextLev = 1;
            else if (prevDir == 2) nextLev++;
            else if (prevDir == 1) nextLev = 1;
            maxLev = Math.max(maxLev, rec(node.left, 1, nextLev));
        }
        if (node.right != null) {
            int nextLev = lev;
            if (lev == 0) nextLev = 1;
            else if (prevDir == 1) nextLev++;
            else if (prevDir == 2) nextLev = 1;
            maxLev = Math.max(maxLev, rec(node.right, 2, nextLev));
        }
        return maxLev;
    }
}