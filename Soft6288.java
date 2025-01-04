import java.io.*;
import java.util.*;

public class Soft6288 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] wN = br.readLine().split(" ");
        int w = Integer.parseInt(wN[0]);
        int n = Integer.parseInt(wN[1]);

        int[] jL = new int[10001];
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            int m = Integer.parseInt(inputs[0]);
            int p = Integer.parseInt(inputs[1]);
            jL[p] += m;
        }

        int ans = 0;
        for (int i = 10000; i > 0; i--) {
            if (w <= 0) break;
            if (jL[i] == 0) continue;
            if (w >= jL[i]) {
                ans += i * jL[i];
                w -= jL[i];
            } else {
                ans += i * w;
                w = 0;
            }
        }

        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("" + ans);
        bw.flush();
    }
}
