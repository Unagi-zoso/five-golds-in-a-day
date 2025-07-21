class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            arr.add(new int[] {nums2[i], nums1[i]});
        }
        arr.sort((i, j) -> j[0] - i[0]);
        
        long sum = 0;
        long ans = Long.MIN_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        for (int[] ar : arr) {
            pq.add(ar[1]);
            sum += ar[1];
            if (pq.size() > k) {
                sum -= pq.poll();
            }
            if (pq.size() == k) {
                ans = Math.max(ans, sum * ar[0]);
            }
        }
        return ans;
    }
}