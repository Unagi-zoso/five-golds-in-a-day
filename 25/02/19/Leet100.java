class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;

        if (p != null && q != null && q.val == p.val) {
            return isSameTree(q.left, p.left) && isSameTree(q.right, p.right);
        }
        
        return false;
    }
}