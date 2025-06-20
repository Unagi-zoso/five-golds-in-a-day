import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();

        int[][][] cowInfo = new int[52][2][2]; // cow 식별자,순환분기, (시작끝)
        for (int[][] cowInfo1 : cowInfo) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    cowInfo1[j][k] = -1;
                }
            }
        }

        for (int idx = 0; idx < input.length; idx++) {
            char c = input[idx];
            int curCow = c - 'A';
            boolean isFirst = cowInfo[curCow][0][0] == -1;
            if (isFirst) {
                cowInfo[curCow][0][0] = idx;
                cowInfo[curCow][1][0] = idx + 52;
            } else {
                cowInfo[curCow][0][1] = idx;
                cowInfo[curCow][1][1] = idx + 52;
            }
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                if (i == j) continue;
                int[][] left = cowInfo[i]; // 순환분기, (시작끝)
                int[][] right = cowInfo[j]; // 순환분기, (시작끝)
                if (left[0][0] > right[0][0]) {
                    int[][] temp = left;
                    left = right;
                    right = temp;
                }
                
                if (left[0][1] < right[0][0] && right[0][1] < left[1][0]) continue;
                if (right[0][1] < left[0][1] && left[1][0] < right[1][0]) continue;
                ans++;
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}

/**
 * 두 구간 사이의 정방, 역방을 비교하는 문제
 * a 의 정방
 * (0, 4) , (52, 56)
 * a 의 역방
 * (4, 52) 
 * 
 * b 의 정방
 * (1, 5)
 * b 의 역방
 * (5, 53)
 * 
 * [완전 포함하거나 일부만 겹치도록]
 * 정정
 * 0a 1b 4a 5b
 * 정역
 * 0a 4a 5b 52a 53b 56a
 * 역정
 * 1b 4a 5b 52a
 * 역역
 * 5b 52a 53b 56a
 */
