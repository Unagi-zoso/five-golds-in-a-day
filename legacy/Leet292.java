import java.io.*;
import java.util.*;

class Solution {
    public boolean canWinNim(int n) {      
        return n % 2 != 0;
    }
}

public class Leet292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        Solution s = new Solution();
        while (st.hasMoreTokens()) {
            bw.write(s.canWinNim(Integer.parseInt(st.nextToken())) + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}