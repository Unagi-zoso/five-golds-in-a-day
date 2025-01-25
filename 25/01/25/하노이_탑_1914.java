import java.io.*;

public class 하노이_탑_1914 {
    static void rec(int from, int to, int val, BufferedWriter bw) throws Exception {
        if (val == 1) {
            bw.write("" + from + " " + to + "\n");
            return;
        }
        int nextEmpty = 6 - from - to;
        rec(from, nextEmpty, val - 1, bw);
        bw.write("" + from + " " + to + "\n");
        rec(nextEmpty, to, val - 1, bw);
    }

    static int onlyCount(int c) {
        if (1 == c) return 1;
        return 2 * onlyCount(c - 1) + 1;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        bw.write("" + onlyCount(n) + "\n");
        if (n <= 20) {
            rec(1, 3, n, bw);
        }
        bw.flush();
    }
}
