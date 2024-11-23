// 시간복잡도 O(2|N|) 공간복잡도 O(2|N|)  다른 알고리즘과의 차이를 나타내기위해 양수 계수 살렸음

// import java.io.*;

// public class Boj1788 {
//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//         int n = Integer.parseInt(br.readLine());

//         int halfSize = 1000005;
//         int[] dp = new int[2 * halfSize];
//         int bias = halfSize - 1;

//         dp[bias] = 0;
//         dp[bias - 1] = 1;
//         for (int i = bias - 2; i >= 0; i--) {
//             dp[i] += ((long) dp[i + 2] - dp[i + 1]) % 1000000000;
//         }

//         dp[bias + 1] = 1;
//         dp[bias + 2] = 1;
//         for (int i = bias + 3; i < dp.length; i++) {
//             dp[i] += ((long) dp[i - 1] + dp[i - 2]) % 1000000000;
//         }
        
//         int sign = 0;
//         if (dp[n + bias] < 0) sign = -1;
//         else if (dp[n + bias] > 0) sign = 1;
        
//         bw.write("" + sign + "\n" + Math.abs(dp[n + bias]));
//         bw.flush();
//     }
// }

// O(|N|) O(|N|) 
// 아싸리 귀납적으로 접근하는게 간단할 수 있다.
// 기존 양의 피보나치 패턴 0  1  1  2  3  5  8 (idx 0 -> |N|)
//     음의 피보나치 패턴 0  1 -1  2 -3  5 -8 (idx 0 -> -|N|)
import java.io.*;

public class Boj1788 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int size = 1000005;
        int[] dp = new int[size];

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000000;
        }
        
        int dir = 1;
        if (n < 0) dir = -1;

        n = Math.abs(n);
        if (dir == -1 && n % 2 == 0) dp[n] *= -1;

        int sign = 0;
        if (dp[n] < 0) sign = -1;
        else if (dp[n] > 0) sign = 1;
        
        bw.write("" + sign + "\n" + Math.abs(dp[n]));
        bw.flush();
    }
}