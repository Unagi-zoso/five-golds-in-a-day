import java.io.*;
import java.util.*;

class Main {
    public static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int C = Integer.parseInt(br.readLine());
        while (C-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] board = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j <= i; j++) {
                    board[i][j] = Integer.parseInt(input[j]);
                }
            }
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
            int ans = Math.max(rec(board, n, 1, 0, dp), rec(board, n, 1, 1, dp)) + board[0][0];
            bw.write("" + ans + "\n");
        }
        bw.flush();
    }

    public static int rec(int[][] board, int n, int cur, int j, int[][] dp) {
        int ret = 0;
        if (n == cur) return 0;
        if (dp[cur][j] != -1) return dp[cur][j];
        ret = Math.max(rec(board, n, cur + 1, j, dp), rec(board, n, cur + 1, j+1, dp)) + board[cur][j];
        dp[cur][j] = ret;
        return ret;
    }
}
