import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int len = input.length();
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j + i < len; j++) {
                if (i == 0) {
                    dp[j][j+i] = true;
                } else if (i == 1) {
                    dp[j][j+i] = input.charAt(j) == input.charAt(j + i);
                } else {
                    dp[j][j + i] = dp[j+1][j + i - 1] && (input.charAt(j) == input.charAt(j + i));
                }
            }
        }
        
        int[] mins = new int[len];
        for (int i = 0; i < len; i++) {
            mins[i] = i + 1;
            for (int j = 0; j <= i; j++) {
                if (dp[j][i]) {
                    if (j == 0) mins[i] = 1;
                    else mins[i] = Math.min(mins[i], mins[j-1] + 1);
                }
            }
        }
        bw.write(String.valueOf(mins[len-1]));
        bw.flush();
    }
}