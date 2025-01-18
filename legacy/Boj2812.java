import java.util.*;
import java.io.*;

public class Boj2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String nums = br.readLine();

        StringBuilder sb = new StringBuilder("abc");
        sb.insert(1, "def");
        System.out.println(sb);

        for (int i = 0; i < n; i++) {
            while (sb.length() > 0 && k > 0 && sb.charAt(sb.length() - 1) < nums.charAt(i)) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(nums.charAt(i));
        }

        while (k-- > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        bw.write(sb.toString());
        bw.flush();
    }
}