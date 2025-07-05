class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len-1;
        int max = Integer.MIN_VALUE;
        while (left < right) {
            max = Math.max(max, (right - left)*(Math.min(height[left], height[right])));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}