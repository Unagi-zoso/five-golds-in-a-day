import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int m = Integer.parseInt(inputs[0]);
        int n = Integer.parseInt(inputs[1]);

        int[][] spaceFantasy = new int[m][n];
        for(int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < inputs.length; j++) {
                spaceFantasy[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        int[] ans = {0};
        comb(0, 0, spaceFantasy, new int[2], ans);
        bw.write("" + ans[0]);
        bw.flush();
    }

    public static void comb(int cur, int start, int[][] spaceFantasy, int[] result, int[] ans) {
        if (cur >= 2) {
            if (isEval(spaceFantasy[result[0]], spaceFantasy[result[1]], ans)) {
                ans[0]++;
            }
            return;
        }
        for (int i = start; i < spaceFantasy.length; i++) {
            result[cur] = i;
            comb(cur + 1, i + 1, spaceFantasy, result, ans);
        }
    }

    public static boolean isEval(int[] a, int[] b, int[] ans) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] - a[j] < 0 && b[i] - b[j] >= 0) return false;
                if (a[i] - a[j] == 0 && b[i] - b[j] != 0) return false;
                if (a[i] - a[j] > 0 && b[i] - b[j] <= 0) return false;
            }
        }
        return true;
    }
}
/**
 * M 개 우주 있고 각 우주에는 N 개의 행성이 있다. 매트릭스
 * 균등한 우주가 몇쌍인지? 구성이 같은데 순서만 다른 우주의 쌍은 한 번만 (조합으로 해결한다?)\
 * 두 행성이 있을 때 각 우주의 모든 행성을 따졌을 때 
 * n^2 으로 다 따져야한다?
 * 
 * 2 <= ㅡ <= 100
 * 3 <= N <= 10,000
 * 
 * 100C2 * 10,000 ^ 2
 */