class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 1) return 1;
        int curDir = 0; // 0 : 초기화 전, 1 : 우상향, 2 : 우하향
        int ans = 1;
        int curSize = 1;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int prev = nums[i - 1];

            if (prev < cur) {
                if (curDir == 1) {
                    curSize++;
                } else if (curDir == 2) {
                    curSize = 2;
                    curDir = 1;
                } else {
                    curDir = 1;
                    curSize++;
                }
            } else if (prev > cur) {
                if (curDir == 1) {
                    curSize = 2;
                    curDir = 2;
                } else if (curDir == 2) {
                    curSize++;
                } else {
                    curDir = 2;
                    curSize++;
                }
            } else {
                curDir = 0;
                curSize = 1;
            }
            ans = Math.max(ans, curSize);
        }
        return ans;
    }
}