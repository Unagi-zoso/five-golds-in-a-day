class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        int left = 0;
        int right = costs.length - 1;
        long totalCost = 0;

        for (int i = 0; i < candidates; i++) {
            if (left <= right) {
                pq.offer(new int[]{costs[left], left});
                left++;
            }
            if (left <= right) {
                pq.offer(new int[]{costs[right], right});
                right--;
            }
        }

        for (int i = 0; i < k; i++) {
            if (pq.isEmpty()) {
                break;
            }
            
            int[] hired = pq.poll();
            totalCost += hired[0];
            int hiredIndex = hired[1];

            if (left <= right) {
                if (hiredIndex < left) {
                    pq.offer(new int[]{costs[left], left});
                    left++;
                } else {
                    pq.offer(new int[]{costs[right], right});
                    right--;
                }
            }
        }
        
        return totalCost;
    }
}

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        long total = 0L;
        int left = 0, right = costs.length-1;
        while (k-- > 0) {
            while (left <= right && pq1.size() < candidates) pq1.offer(costs[left++]);
            while (left <= right && pq2.size() < candidates) pq2.offer(costs[right--]);

            int p1 = !pq1.isEmpty() ? pq1.peek() : Integer.MAX_VALUE;
            int p2 = !pq2.isEmpty() ? pq2.peek() : Integer.MAX_VALUE;

            if (p1 <= p2) total += pq1.poll();
            else total += pq2.poll();
        }
        return total;
    }
}