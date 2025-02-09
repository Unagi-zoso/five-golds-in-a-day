import java.util.*;

class Solution {
    public long countBadPairs(int[] nums) {
        if (nums.length == 1) return 0;

        Map<Integer, Integer> m = new HashMap<>();
        m.put(nums[0] - 0, 1);
        long cnt = 0;
        for (int i = 1; i < nums.length; i++) {
            int found = m.getOrDefault(nums[i] - i, 0);
            cnt += found;
            m.put(nums[i] - i, found + 1);
        }
        return 1L * nums.length * (nums.length - 1) / 2 - cnt;
    }
}