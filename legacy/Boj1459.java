import java.lang.*;
import java.util.*;
import java.io.*;

public class Boj1459 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long w = Long.parseLong(st.nextToken());
        long s = Long.parseLong(st.nextToken());

        if (x < y) {
            long t = x;
            x = y;
            y = t;
        }

        Long minCross = Math.min((2L * y * w), (y * s));
        Long remainder = x - y;
        Long minStraight = Math.min((remainder * w), (((int) (remainder / 2)) * s * 2 + (remainder % 2 * w)));
        bw.write("" + (minCross + minStraight));
        bw.flush();
    }
    
}
