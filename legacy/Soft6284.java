import java.io.*;
import java.util.*;

public class Soft6284 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strIn = br.readLine().split(" ");

        long mod = 1000000007;
        long k = Long.parseLong(strIn[0]) % mod;
        long p = Long.parseLong(strIn[1]) % mod;
        long n = Long.parseLong(strIn[2]) % mod;

        long res = 1;
        for (int i = 0; i < n; i++) {
            res = (res * p) % mod;
        }

        long ans = (k * res) % mod;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("" + ans);
        bw.flush();

        
        
    }
}
