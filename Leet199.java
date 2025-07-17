class Solution {
    List<Integer> li = new ArrayList<>();
    int[] check = new int[105];
    public List<Integer> rightSideView(TreeNode root) {
        rec(root, 0);
        return li;
    }

    public void rec(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        if (check[val]++ == 0) li.add(root.val);
        rec(root.right, val+1);
        rec(root.left, val+1);
    }
}