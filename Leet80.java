class Solution {
    public int removeDuplicates(int[] nums) {
        int[] freq = new int[500000];
        int idxToIndex = 1;
        freq[nums[0]+20000]++;
        for (int i = 1; i < nums.length; i++) {
            if (freq[nums[i]+20000] >= 2 && nums[i-1] == nums[i]) continue;
            freq[nums[i]+20000]++;
            nums[idxToIndex++] = nums[i];
        }
        return idxToIndex;
    }
}