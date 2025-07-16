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
    public int pathSum(TreeNode root, int targetSum) {
        return rec(root, new ArrayList<>(), targetSum);
    }

    public int rec(TreeNode node, List<Integer> hist, int targetSum) {
        if (node == null) return 0;
        long curSum = node.val;
        int ret = curSum == targetSum ? 1 : 0;
        for (int i = hist.size()-1; i >= 0; i--) {
            curSum += hist.get(i);
            ret += curSum == targetSum ? 1 : 0;
        }
        hist.add(node.val);
        if (node.left != null) ret += rec(node.left, hist, targetSum);
        if (node.right != null) ret += rec(node.right, hist, targetSum); 
        hist.remove(hist.size()-1);
        return ret;
    }
}