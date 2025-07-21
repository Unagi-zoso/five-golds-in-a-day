class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        for (int i : nums) pq.offer(i);
        int ans  = pq.peek();
        for (int i = 0; i < k; i++) ans = pq.poll();
        return ans;
    }
}