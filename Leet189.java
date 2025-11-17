class Solution {
    public void rotate(int[] nums, int k) {
        int[] copied = new int[nums.length];
        for (int i = 0; i < nums.length; i++) copied[i] = nums[i];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = copied[(nums.length - (k%nums.length) + i) % nums.length];
            
        }
    }
}