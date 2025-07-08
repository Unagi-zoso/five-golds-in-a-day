class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        boolean[] n1used = new boolean[2005];
        boolean[] n2used = new boolean[2005];
        for (int n : nums1) {
            n1used[n + 1000] = true;
        }
        for (int n : nums2) {
            n2used[n + 1000] = true;
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int n : nums1) {
            if (n2used[n + 1000]) continue;
            set1.add(n);
        }
        for (int n : nums2) {
            if (n1used[n + 1000]) continue;
            set2.add(n);
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(set1));
        result.add(new ArrayList<>(set2));
        return result;
    }
}