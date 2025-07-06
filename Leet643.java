class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int idx = 0;
        int max = 0;
        for (; idx < k; idx++) {
            sum += nums[idx];
        }
        max = sum;
        for (; idx < nums.length; idx++) {
            sum = sum - nums[idx - k] + nums[idx];
            max = Math.max(max, sum);
        }
        return (double) max / k;
        
    }
}