class Solution {
    public int solution(int n, int[] tops) {
        int MOD = 10007;
        int len = 2 * n + 1;

        int[][] board = new int[2][len];
        board[1][0] = 1;
        for (int i = 1; i < len; i++) {
            if (i % 2 == 1) {
                board[1][i] = -1;
                if ((i - 1) / 2 < tops.length && tops[(i - 1) / 2] == 1) {
                    board[0][i] = 1;
                } else {
                    board[0][i] = 0;
                }
            } else {
                board[1][i] = 1;
                board[0][i] = 0;
            }
        }

        int[] dp = new int[len + 1];
        
        dp[len] = 1;

        for (int idx = len - 1; idx >= 0; idx--) {
            int currentWays = 0;

            if (idx + 1 <= len) {
                currentWays = (currentWays + dp[idx + 1]) % MOD;
            }

            if (idx < len && board[1][idx] == -1 && board[0][idx] == 1) {
                if (idx + 1 <= len) {
                    currentWays = (currentWays + dp[idx + 1]) % MOD;
                }
            }

            if (idx + 2 <= len && board[1][idx] == 1 && board[1][idx + 1] == -1) {
                currentWays = (currentWays + dp[idx + 2]) % MOD;
            }

            if (idx + 2 <= len && board[1][idx] == -1 && board[1][idx + 1] == 1) {
                currentWays = (currentWays + dp[idx + 2]) % MOD;
            }
            
            dp[idx] = currentWays;
        }
        
        return dp[0];
    }
}