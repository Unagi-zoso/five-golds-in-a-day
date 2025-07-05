class Solution {
    public void moveZeroes(int[] nums) {
        int cntNonZero = 0;
        for (int num : nums) {
            if (num != 0) cntNonZero++;
        }

        int insertionIdx = 0;
        int nonZeroIdx = 0;

        int cntProcessed = 0;
        while (cntProcessed != cntNonZero) {
            while (nonZeroIdx < nums.length && nums[nonZeroIdx] == 0) {
                nonZeroIdx++;
            }
            if (nonZeroIdx < nums.length) {
                nums[cntProcessed++] = nums[nonZeroIdx++];
            }
        }
        for (int i = cntNonZero; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}