import java.io.*;
import java.util.*;

public class AlgoFestival {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        
        int c = Integer.parseInt(br.readLine());
        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            List<Integer> nums = new ArrayList<Integer>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                nums.add(Integer.parseInt(st.nextToken()));
            }
            List<Integer> prefixSum = new ArrayList<Integer>();
            prefixSum.add(0);
            for (int j = 1; j <= n; j++) {
                prefixSum.add(prefixSum.get(j - 1) + nums.get(j - 1));
            }
            double ans = Double.MAX_VALUE;
            for (int j = l; j <= n; j++) {
                int sum = prefixSum.get(j);
                ans = Math.min(ans, (double)sum / j);
                for (int k = j; k < n; k++) {
                    sum += nums.get(k);
                    sum -= nums.get(k - j);
                    ans = Math.min(ans, (double)sum / j);
                }
            }
            bw.write(String.format("%.10f", ans) + "\n");
            bw.flush();
            
        }
        bw.close();
        br.close();             
    }
    
}
