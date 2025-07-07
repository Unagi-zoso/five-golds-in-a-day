class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int mx = 0;
        int cntZ = 0;
        for (int right = 0; right < nums.length; right++) {
            int n = nums[right];
            if (n == 0) cntZ++;
            while (cntZ > k) {
                if (nums[left] == 0) cntZ--;
                left++;
            }
            mx = Math.max(mx, right - left + 1);
        }

        return mx;
    }
}