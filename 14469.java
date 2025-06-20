import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] nums  = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int inTime = Integer.parseInt(input[0]);
            int execTime = Integer.parseInt(input[1]);

            nums[i][0] = inTime;
            nums[i][1] = execTime;
        }

        Arrays.sort(nums, (i, j) -> {
            if (i[0] != j[0]) return Integer.compare(i[0], j[0]);
            return Integer.compare(i[1], j[1]);
        });

        int ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((i, j) -> {
            if (i[0] != j[0]) return Integer.compare(i[0], j[0]);
            return Integer.compare(i[1], j[1]);
        });

        for (int[] num : nums) pq.offer(num);
        while (!pq.isEmpty()) {
            if (pq.peek()[0] <= ans) {
                int[] cur = pq.poll();
                ans += cur[1];
            } else {
                ans = pq.peek()[0];
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}