class Solution {
    

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return List.of();

        List result = new ArrayList<Integer>();

        inorderTraversal(root, result);

        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root, List<Integer> result) {
        if (root.left != null) {
            inorderTraversal(root.left, result);
        }
        
        result.add(root.val);

        if (root.right != null) {
            inorderTraversal(root.right, result);
        }

        return result;
    }
}
