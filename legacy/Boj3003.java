import java.util.*;
import java.lang.*;
import java.io.*;

public class Boj3003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        List<Integer> targetAmount = List.of(1,1,2,2,2,8);


        for (int tA : targetAmount) {
            int curAmount = Integer.parseInt(st.nextToken());
            bw.write("" + (tA - curAmount) + " ");
        }
        bw.flush();
    }
    
}
