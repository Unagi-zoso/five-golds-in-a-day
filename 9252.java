import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int n = str2.length();
        int m = str1.length();

        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str2.charAt(i-1) == str1.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        
        
        int cY = n;
        int cX = m;
        int ansVal = dp[n][m];
        StringBuilder ansStr = new StringBuilder();
        while (cY > 0 && cX > 0) {
            if (str2.charAt(cY-1) == str1.charAt(cX-1)) {
                ansStr.append(str2.charAt(cY-1));
                cX--;
                cY--;
            }
            else {
                if (dp[cY][cX-1] >= dp[cY-1][cX]) {
                    cX--;
                } else {
                    cY--;
                }
            }
        }
        
        bw.write(String.valueOf(ansVal) + "\n");
        if (ansVal != 0) bw.write(ansStr.reverse().toString());
        bw.flush();
    }
}