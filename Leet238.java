class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] ans = new int[nums.length];
        int leftProd = 1;
        for (int i = 0; i < nums.length; i++) {
           if (i-1 >= 0) leftProd *= nums[i-1];
           ans[i] = leftProd;
        }
        int rightProd = 1;
        for (int i = nums.length-1; i >= 0; i--) {
           if (i+1 <= nums.length-1) rightProd *= nums[i+1];
           ans[i] *= rightProd;
        }
        return ans;
    }
}