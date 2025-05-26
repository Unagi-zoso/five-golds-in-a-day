import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();

        int[][][] dp = new int[105][105][105];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                for (int k = 1; k <= s3.length(); k++) {
                    if (s1.charAt(i-1) == s2.charAt(j-1) && s2.charAt(j-1) == s3.charAt(k-1)) {
                        dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
                    } else {
                        dp[i][j][k] = Arrays.stream(new int[] {dp[i-1][j][k], dp[i][j-1][k], dp[i][j][k-1]}).max().orElse(0);
                    }
                }
            }
        }

        bw.write(String.valueOf(dp[s1.length()][s2.length()][s3.length()]));
        bw.flush();
    }
}
/**
 * i j k 같은게 일치한다는 뜻
 */