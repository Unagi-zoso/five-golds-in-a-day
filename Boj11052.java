import java.lang.*;
import java.util.*;
import java.io.*;

public class Boj11052 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> nums = new ArrayList<Integer>();
        nums.add(0);

        while (st.hasMoreTokens()) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = nums.get(i);
            for (int j = 0; j <= i; j++) {
                if (j > i) break;
                dp[i] = Math.max(dp[i], dp[i - j] + dp[j]);
            }
        }

        bw.write("" + dp[n]);
        bw.flush();
        // 1 2       3                      4
        // 1 (11, 2) 111 12(최고값은 전에꺼) 3  1111 112 22 13 4
        //           1 ... n 까지            0 1 2
        //           2     0                4 3 2
    }
}
