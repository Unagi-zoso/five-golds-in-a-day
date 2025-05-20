class Solution {
    public int solution(int n, int[] tops) {
        int len = 2 * n + 1;
        int[] dp = new int[200_005];
        
        dp[0] = 1;
        dp[1] = 2;
        if (tops[0] == 1) dp[1]++;
        
        for (int i = 2; i < len; i++) {
            dp[i] = (dp[i] + dp[i - 1]) % 10_007;
            if (i % 2 == 1 && tops[(i - 1) / 2] == 1) {
                dp[i] = (dp[i] + dp[i - 1]) % 10_007;
            }
            
            dp[i] = (dp[i] + dp[i - 2]) % 10_007;
            
        }
        return dp[2 * n];
    }
}