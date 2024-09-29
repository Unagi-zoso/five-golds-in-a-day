import java.util.*;

class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        int[][] cache = new int[n][n + 1];
        int[] suffixSum = Arrays.copyOf(piles, n);

        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] += suffixSum[i + 1];
        }

        return rec(0, 1, n, cache, suffixSum);
    }

    private int rec(int i, int m, int n, int[][] cache, int[] suffixSum) {
        if (i + 2 * m >= n) return suffixSum[i];
        
        if (cache[i][m] != 0) return cache[i][m];

        for (int j = 1; j <= 2 * m; j++) {
            cache[i][m] = Math.max(cache[i][m], suffixSum[i] - rec(i + j, Math.max(m, j), n, cache, suffixSum));       
        }

        return cache[i][m];
    }
}


class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        int[][] cache = new int[n][n + 1];
        int[] suffixSum = Arrays.copyOf(piles, n);

        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] += suffixSum[i + 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= n; j++) {
                if (i + 2 * j >= n) {
                    cache[i][j] = suffixSum[i];
                } else {
                    for (int k = 1; k <= 2 * j; k++) {
                        cache[i][j] = Math.max(cache[i][j], suffixSum[i] - cache[i + k][Math.max(j, k)]);
                    }
                }
            }
        }

        return cache[0][1];
    }
}