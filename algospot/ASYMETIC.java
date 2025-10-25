import java.io.*;
import java.util.*;

class Main {
    public static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    public static int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int C = Integer.parseInt(br.readLine());
        while (C-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] dp = new long[n+5];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;
            bw.write("" + (asymeric(n, dp, n)) + "\n");
        }
        bw.flush();
    }

    public static long tiling(int n, long[] dp, int cur) {
        if (cur < 0) return 0;

        if (dp[cur] != 0) return dp[cur];
        long ret = (tiling(n, dp, cur-1) + tiling(n, dp, cur-2)) % 1_000_000_007;
        dp[cur] = ret;
        return ret;
    }

    public static long asymeric(int n, long[] dp, int cur) {
        if (cur % 2 == 0) {
            long ret = tiling(n, dp, cur);
            ret = (ret - tiling(n, dp, cur/2) + MOD) % MOD;
            ret = (ret - tiling(n, dp, cur/2-1) + MOD) % MOD;
            return ret;
        } else {
            long ret = tiling(n, dp, cur);
            ret = (ret - tiling(n, dp, cur/2) + MOD) % MOD;
            return ret;
        }
    }
}