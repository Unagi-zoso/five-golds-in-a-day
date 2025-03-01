import java.util.*;
import java.io.*;

public class Boj10819 {
    static boolean[] dupFlag = new boolean[10];
    static int ans = -100000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        
        int[] li = new int[n];
        for (int i = 0; i < n; i++) {
            li[i] = Integer.parseInt(input[i]);
        }

        rec(li, 0, new ArrayList<Integer>());
        bw.write("" + ans);
        bw.flush();
    }

    public static void rec(int[] li, int cur, ArrayList<Integer> lli) {
        if (cur == li.length) {
            int sum = 0;
            for (int i = 0; i < li.length - 1; i++) {
                int idx = lli.get(i);
                int nextIdx = lli.get(i + 1);
                sum += Math.abs(li[idx] - li[nextIdx]);
            }
            ans = Math.max(ans, sum);
        }
        for (int i = 0; i < li.length; i++) {
            if (dupFlag[i]) continue;
            dupFlag[i] = true;
            lli.add(i);
            rec(li, cur + 1, lli);
            lli.remove(lli.size()-1);
            dupFlag[i] = false;
        }
    }
}
