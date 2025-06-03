import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Map<Integer, Integer> cnts = new HashMap<>();
        for (int num : nums) {
            cnts.put(num, cnts.getOrDefault(num, 0)+1);
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            cnts.put(nums[i], cnts.get(nums[i])-1);
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                cnts.put(nums[j], cnts.get(nums[j])-1);
                if (cnts.getOrDefault(nums[i] - nums[j], 0) > 0) {
                    ans++;
                    cnts.put(nums[j], cnts.get(nums[j])+1);
                    break;
                }
                cnts.put(nums[j], cnts.get(nums[j])+1);
            }
            cnts.put(nums[i], cnts.get(nums[i])+1);
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    
}