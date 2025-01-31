import java.util.*;

class Solution {
    public int[] getOrder(int[][] tasks) {
        int ENROLLTIME = 0, PRCTIME = 1, INDEX = 2;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if (a[PRCTIME] != b[PRCTIME]) return Integer.compare(a[PRCTIME], b[PRCTIME]);
                return Integer.compare(a[INDEX], b[INDEX]);
            }
        );

        int[][] inputs = new int[tasks.length][3];
        for (int i = 0; i < tasks.length; i++) {
            inputs[i][ENROLLTIME] = tasks[i][0];
            inputs[i][PRCTIME] = tasks[i][1];
            inputs[i][INDEX] = i;
        }

        Arrays.sort(inputs, (a, b) -> {
                if (a[ENROLLTIME] != b[ENROLLTIME]) return Integer.compare(a[ENROLLTIME], b[ENROLLTIME]);
                if (a[PRCTIME] != b[PRCTIME]) return Integer.compare(a[PRCTIME], b[PRCTIME]);
                return Integer.compare(a[INDEX], b[INDEX]);
            }
        );

        List<Integer> ans = new ArrayList<>();

        long curTime = inputs[0][ENROLLTIME];
        int inputIdx = 0;
        while (inputIdx < inputs.length || !pq.isEmpty()) {
            if (pq.isEmpty() && curTime < inputs[inputIdx][ENROLLTIME]) {
                curTime = inputs[inputIdx][ENROLLTIME];
            }
            while (inputIdx < inputs.length && inputs[inputIdx][ENROLLTIME] <= curTime) {
                int[] info = {-1, inputs[inputIdx][PRCTIME], inputs[inputIdx][INDEX]};
                pq.offer(info);
                inputIdx++;
            }
            
            int[] curTask = pq.poll();
            curTime += curTask[PRCTIME];
            ans.add(curTask[INDEX]);
        }
        int[] arrans = ans.stream().mapToInt(Integer::intValue).toArray();
        return arrans;
    }
}