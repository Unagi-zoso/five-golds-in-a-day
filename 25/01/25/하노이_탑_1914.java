import java.io.*;
import java.math.*;

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

    static BigInteger onlyCount(int c) {
        if (1 == c) return BigInteger.ONE;
        return onlyCount(c - 1).multiply(BigInteger.TWO).add(BigInteger.ONE);
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
        bw.close();
    }
}
