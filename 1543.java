import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        char[] doc = br.readLine().toCharArray();
        char[] target = br.readLine().toCharArray();
        
        int ans = 0;
        for (int i = 0; i < doc.length - target.length + 1;) {
            boolean flag = true;
            for (int j = 0; j < target.length; j++) {
                if (doc[i + j] != target[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans++;
                i += target.length; 
            } else {
                i++;
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}