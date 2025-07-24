class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int mx = Integer.MIN_VALUE;
        for (int p : piles) mx = Math.max(mx, p);

        int low = 1, high = mx, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            long sum = 0;
            for (int i = 0; i < piles.length; i++) {
                sum += (piles[i] + mid - 1) / mid;
            }
            if (sum > h) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}