import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int oper = Integer.parseInt(br.readLine());
            if (oper == 0) {
                if (pq.isEmpty()) {
                    bw.write("0");    
                } else {
                    bw.write(String.valueOf(pq.poll()[1]));
                }
                bw.newLine();
            } else {
                pq.offer(new int[] {Math.abs(oper), oper});
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}