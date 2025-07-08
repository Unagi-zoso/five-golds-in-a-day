class Solution {
    public int largestAltitude(int[] gain) {
        int[] heights = new int[gain.length+1];
        int mx = 0;
        for (int i = 1; i < heights.length; i++) {
            heights[i] = gain[i-1] + heights[i-1];
            mx = Math.max(mx, heights[i]);
        }
        return mx;
    }
}
