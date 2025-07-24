class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = {false, false, false, false, false, false, false, false, false, false, false };
        rec(k, n, 0, 0, used, new ArrayList<>(), 0, ans);
        return ans;
    }

    void rec(int k, int n, int prev, int lev, boolean[] used, List<Integer> temp, int tempSum, List<List<Integer>> ans) {
        if (lev == k) {
            if (tempSum == n) {
                List<Integer> cloned = new ArrayList<>(temp);
                ans.add(cloned);
            }
            return;
        }
        for (int i = prev+1; i <= 9; i++) {
            if (used[i]) continue;
            used[i] = true;
            tempSum += i;
            temp.add(i);
            if (tempSum <= n) rec(k, n, i, lev+1, used, temp, tempSum, ans);
            temp.remove(temp.size()-1);
            tempSum -= i;
            used[i] = false;
        }
    }
}