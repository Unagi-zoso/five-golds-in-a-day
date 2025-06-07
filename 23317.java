import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[][] dp = new long[35][35];
        for (int i = 0; i < 35; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for (int i = 2; i < 35; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        int[][] queries = new int[m][2];
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            queries[i][0] = Integer.parseInt(input[0]);
            queries[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(queries, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        // 같은 행에 여러 쿼리 체크
        for (int i = 1; i < queries.length; i++) {
            if (queries[i][0] == queries[i-1][0] && queries[i][1] != queries[i-1][1]) {
                bw.write("0");
                bw.newLine();
                bw.flush();
                return;
            }
        }

        
        for (int i = 0; i < m; i++) {
            int r = queries[i][0];
            int c = queries[i][1];
            
            // dp 테이블 수정: r행의 c위치로 경로 제한
            long target = dp[r][c];
            
            // r행부터 끝까지의 dp 값들을 재계산
            for (int j = r; j < n; j++) {
                if (j == r) {
                    // r행에서는 c위치만 target 값을 가지고 나머지는 0
                    for (int k = 0; k < 35; k++) {
                        if (k == c) {
                            dp[j][k] = target;
                        } else {
                            dp[j][k] = 0;
                        }
                    }
                } else {
                    // r행 이후는 일반적인 파스칼 삼각형 규칙으로 재계산
                    for (int k = 0; k < Math.min(35, j + 1); k++) {
                        long newVal = 0;
                        if (k > 0) newVal += dp[j-1][k-1];
                        if (k < 34) newVal += dp[j-1][k];
                        dp[j][k] = newVal;
                    }
                }
            }
            
        }

        long result = 0;
        for (int i = 0; i <  n; i++) {
            result += dp[n-1][i];
        }
        
        bw.write(String.valueOf(result));
        bw.newLine();
        bw.flush();
    }
}