import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int target = 2 * n + 1;
        int m = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();

        int[] cnts = new int[m];

        cnts[0] = input[0] == 'I' ? 1 : 0;

        int ans = 0;
        for (int i = 1; i < m; i++) {
            char curCh = input[i];
            char prevCh = input[i-1];

            if (curCh != prevCh) {
                if (cnts[i-1] >= target && curCh == 'O') cnts[i] = cnts[i-1] - 1;
                else cnts[i] = cnts[i-1] + 1;
                if (cnts[i] >= target) ans++;
            }
            else cnts[i] = input[i] == 'I' ? 1 : 0;
        }
        
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}

/*
 * n 주어지고 몇개나 포함되는지 찾으면 그만?
 * N은 백만으로 좀 크고 글자 길이도 백만으로 좀 크다. 무식하게 비교는 삼가.
 * KMP라면 무난하게 풀듯. 구현하긴 싫당
 * DP로 간단히 풀 수 있을거 같은데 
 * 2를 뺴고 진행해버리면 되나? 이어지는 구간에서 0, 1을 반드시 체크
 */