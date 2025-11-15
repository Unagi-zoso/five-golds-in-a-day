class Solution {
    public int removeDuplicates(int[] nums) {
        int prevFreq = 1;
        int prev = nums[0];
        int idxToIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (prevFreq >= 2 && nums[i-1] == nums[i]) continue;
            if (prev == nums[i]) {
                prevFreq++;
            } else {
                prevFreq = 1;
                prev = nums[i];
            }
            nums[idxToIndex++] = nums[i];
        }
        return idxToIndex;
    }
}