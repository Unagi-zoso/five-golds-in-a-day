import java.util.*;
import java.lang.*;
import java.io.*;

public class Boj1904 {
    public static void main(String[] args) throws Exception {
        int[] dp = new int[1000005];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < 1000005; i++) {
            dp[i] += (dp[i - 2] + dp[i - 1]) % 15746;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        bw.write("" + dp[n]);
        bw.flush();
    }
}
