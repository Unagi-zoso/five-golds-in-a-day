import java.io.*;
import java.util.*;

class Main {
    public static int[][] btnMap = {{0, 1, 2},
                                    {3, 7, 9, 11}, 
                                    {4, 10, 14, 15}, 
                                    {0, 4, 5, 6, 7}, 
                                    {6, 7, 8, 10, 12}, 
                                    {0, 2, 14, 15}, 
                                    {3, 14, 15}, 
                                    {4, 5, 7, 14, 15},
                                    {1, 2, 3, 4, 5},
                                    {3, 4, 5, 9, 13}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int C = Integer.parseInt(br.readLine());
        while (C-- > 0) {
            int[] clockStatus = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int ans = rec(clockStatus, 0, 0);
            bw.write("" + (ans == Integer.MAX_VALUE ? -1 : ans) + "\n");
        }
        bw.flush();
    }

    public static int rec(int[] clockStatus, int depth, int cntPress) {
        if (depth == 10) {
            if (check(clockStatus)) return cntPress;
            else return Integer.MAX_VALUE;
        }
        int ret = Integer.MAX_VALUE;
        for (int i = 1; i <= 4; i++) {
            press(clockStatus, depth);
            ret = Math.min(ret, rec(clockStatus, depth+1, cntPress + (i % 4)));
        }
        
        return ret;
    }

    public static boolean check(int[] clockStatus) {
        for (int c : clockStatus) 
            if (c != 12) return false;
        return true;
    }

    public static void press(int[] clockStatus, int depth) {
        for (int clockId : btnMap[depth]) {
            clockStatus[clockId]--;
            clockStatus[clockId] = (clockStatus[clockId] + 3) % 12;
            clockStatus[clockId]++;
        }
    }
}