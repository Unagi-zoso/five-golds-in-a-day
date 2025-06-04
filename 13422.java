import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);
            int k = Integer.parseInt(inputs[2]);
            int[] money = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int ans = 0;
            long window = 0;
            for (int i = 0; i < m; i++) {
                window += money[i];
            }
            if (window < k) ans++;

            if (n != m) {
                for (int i = 1; i < n; i++) {
                    window -= money[i-1];
                    window += money[(i + m - 1) % n];
                    if (window < k) ans++;
                }
            } 
            bw.write(String.valueOf(ans) + "\n");
        }
        bw.flush();
    }
}

// 단순 윈도우 아닌 이웃간 조합 문제