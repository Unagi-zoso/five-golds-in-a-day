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

        StringBuilder ansStr = new StringBuilder();
        int target = dp[str2.length()-1][str1.length()-1];
        int ansVal = target;
        int cY = str2.length()-1;
        int cX = str1.length()-1;
        while (target > 0) {
            while (true) {
                while (cY >= 0 && cX >= 0 && dp[cY][cX] == target) {
                    int nY = cY - 0;
                    int nX = cX - 1;
                    
                    if (nX < 0) break;
                    if (dp[nY][nX] != target) break;
                    cX = nX;
                }
                while (cY >= 0 && cX >= 0 && dp[cY][cX] == target) {
                    int nY = cY - 1;
                    int nX = cX;
                    
                    if (nY < 0) break;
                    if (dp[nY][nX] != target) break;
                    cY = nY;
                }
                if (cY - 1 >= 0 && cX - 1 >= 0 && dp[cY-1][cX] != target && dp[cY][cX-1] != target) {
                    ansStr.append(str2.charAt(cY));
                    target--;
                    cY--;
                    cX--;
                    break;
                } else if (cY == 0 && cX > 0 && dp[cY][cX-1] != target) {
                    ansStr.append(str2.charAt(cY));
                    target--;
                    cX--;
                    break;
                } else if (cY > 0 && cX == 0 && dp[cY-1][cX] != target) {
                    ansStr.append(str2.charAt(cY));
                    target--;
                    cY--;
                    break;
                } else {
                    ansStr.append(str2.charAt(cY));
                    target--;
                    break;
                }
            }
        }
        String reversed = ansStr.toString();
        StringBuilder corAnsStr = new StringBuilder();

        for (int i = reversed.length()-1; i >= 0; i--) {
            corAnsStr.append(reversed.charAt(i));
        }
        bw.write(String.valueOf(ansVal) + "\n");
        if (ansVal != 0) bw.write(corAnsStr.toString());
        bw.flush();
    }
}