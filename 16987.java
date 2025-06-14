import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[][] eggs = new int[n][2]; // 내구 강
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            eggs[i][0] = Integer.parseInt(inputs[0]);
            eggs[i][1] = Integer.parseInt(inputs[1]);
        }

        int[] ans = {Integer.MIN_VALUE};
        rec(n, 0, eggs, 0, ans);
        bw.write(String.valueOf(ans[0]));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void rec(int target, int cur, int[][] temp, int tempAns, int[] ans) {
        if (cur == target) {
            ans[0] = Math.max(ans[0], tempAns);
            return;
        }
        if (temp[cur][0] <= 0) {
            rec(target, cur + 1, temp, tempAns, ans);
            return;
        }
        boolean noAction = true;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i][0] <= 0 || cur == i) continue;
            noAction = false;
            temp[i][0] -= temp[cur][1];
            temp[cur][0] -= temp[i][1];
            if (temp[i][0] <= 0) tempAns++;
            if (temp[cur][0] <= 0) tempAns++;
            rec(target, cur + 1, temp, tempAns, ans);
            if (temp[i][0] <= 0) tempAns--;
            if (temp[cur][0] <= 0) tempAns--;
            temp[i][0] += temp[cur][1];
            temp[cur][0] += temp[i][1];
        }
        if (noAction) rec(target, cur + 1, temp, tempAns, ans);
    }
}

