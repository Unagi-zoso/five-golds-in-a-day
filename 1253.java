import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int j = 0;
            int k = n - 1;
            while (j < k) {
                if (j == i) { 
                    j++;
                    continue;
                }
                if (k == i) {
                    k--;
                    continue;
                }
                if (nums[j] + nums[k] == nums[i]) {
                    ans++;
                    break;
                } else if (nums[j] + nums[k] > nums[i]) {
                    k--;
                } else if (nums[j] + nums[k] < nums[i]) {
                    j++;
                }
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}