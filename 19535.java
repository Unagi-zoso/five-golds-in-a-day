import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int[] cntDegree = new int[300005];
        List<int[]> edges = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            String[] input = br.readLine().split(" ");
            int n1 = Integer.parseInt(input[0]);
            int n2 = Integer.parseInt(input[1]);

            cntDegree[n1]++;
            cntDegree[n2]++;

            edges.add(new int[] {n1, n2});
        }

        long cntDigd = 0;
        for (int[] ed : edges) {
            cntDigd += (long)(cntDegree[ed[0]] - 1) * (cntDegree[ed[1]] - 1);
        }
        long cntJieut = 0;
        for (int i = 1; i <= n; i++) {
            int curCntDegree = cntDegree[i];
            
            if (curCntDegree >= 3) {
                cntJieut += ((long)curCntDegree * (curCntDegree-1) * (curCntDegree-2)) / 6;
            }
        }
        if (cntDigd > 3 * cntJieut) bw.write("D");
        else if (cntDigd < 3 * cntJieut) bw.write("G");
        else if (cntDigd == 3 * cntJieut) bw.write("DUDUDUNGA");
        bw.flush();
    }
}