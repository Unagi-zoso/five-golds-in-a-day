class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int ans = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) continue;
            if (i == 0) {
                if (i+1 < flowerbed.length) {
                    if (flowerbed[i+1] == 0) {
                        ans++;
                        flowerbed[i] = 1;
                    }
                } else {
                    ans++;
                    flowerbed[i] = 1;
                }
            } else if (i == flowerbed.length - 1) {
                if (flowerbed[i-1] == 0) {
                    ans++;
                    flowerbed[i] = 1;
                }
            } else {
                 if (flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                    ans++;
                    flowerbed[i] = 1;
                }
            }
        }
        return ans >= n;
    }
}