class Solution {
    public int singleNumber(int[] nums) {
        // Set<Integer> s = new HashSet<>();
        // for (int n : nums) {
        //     if (s.contains(n)) s.remove(n);
        //     else s.add(n);
        // }
        // return s.iterator().next();
        // int[] count = new int[90000];
        // for (int n : nums) {
        //     n += 50000;
        //     if (count[n] == 1) count[n]--;
        //     else count[n]++;
        // }
        // for (int i = 0; i < count.length; i++) {
        //     if (count[i] == 1) return i-50000;
        // }
        // return 0;
        int onlyOne = 0;
        for (int n : nums) {
            onlyOne ^= n;
        }
        return onlyOne;
    }
}