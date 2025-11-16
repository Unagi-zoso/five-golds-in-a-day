import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> freqHM = new HashMap<>();
        for (int n : nums) {
            int curFreq = freqHM.getOrDefault(n, 0);
            if (curFreq >= nums.length/2) return n;
            freqHM.put(n, curFreq+1);
        }
        return 0;
    }
}