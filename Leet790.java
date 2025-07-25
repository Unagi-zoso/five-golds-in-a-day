class Solution {
    public int numTilings(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        if (n == 1) return dp[n];
        dp[2] = 2;
        if (n == 2) return dp[n];
        dp[3] = 5;
        if (n == 3) return dp[n];
        int[] prefixSum = new int[n+1];
        prefixSum[0] = 1;
        prefixSum[1] = 1;
        prefixSum[2] = 3;
        prefixSum[3] = 6;
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i] + dp[i-1]) % 1000000007; 
            dp[i] = (dp[i] + dp[i-2]) % 1000000007; 
            dp[i] = (dp[i] + prefixSum[i-3]) % 1000000007; 
            dp[i] = (dp[i] + prefixSum[i-3]) % 1000000007;
            dp[i] = (dp[i] + prefixSum[i-4]) % 1000000007;
            dp[i] = (dp[i] + prefixSum[i-4]) % 1000000007;
            prefixSum[i] = (prefixSum[i-2] + dp[i]) % 1000000007;
        }
        return dp[n];
    }
    // ||||
    // |--|
    // --||
    // ^^^|
    // &&&|
    // ||--
    // ----
    // |^^^
    // |&&&
}