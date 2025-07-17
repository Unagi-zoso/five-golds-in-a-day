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
    int[] levSum = new int[1005];
    int maxLev = 0;
    public int maxLevelSum(TreeNode root) {
        rec(root, 0);
        int ansIdx = 0;
        int ansSum = levSum[0];
        for (int i = 1; i < maxLev; i++) {
            if (levSum[i] > ansSum) {
                ansIdx = i;
                ansSum = levSum[i];
            }
        }
        return ansIdx+1;
    }

    public void rec(TreeNode node, int lev) {
        maxLev = Math.max(maxLev, lev);
        if (node == null) return;
        levSum[lev] += node.val;
        rec(node.left, lev+1);
        rec(node.right, lev+1);
    }
}