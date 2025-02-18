class Solution {
    public void traversal(List<Integer> log, TreeNode p) {
        if (p == null) log.add(-99999999);
        else {
            log.add(p.val);
            traversal(log, p.left);
            traversal(log, p.right);
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> aLog = new ArrayList<>();
        traversal(aLog, p);
        List<Integer> bLog = new ArrayList<>();
        traversal(bLog, q);

        System.out.println(aLog);
        System.out.println(bLog);
        if (aLog.size() != bLog.size()) return false;
        for (int i = 0; i < aLog.size(); i++) {
            if (!aLog.get(i).equals(bLog.get(i))) {
                return false;
            }
        }
        return true;
    }
}