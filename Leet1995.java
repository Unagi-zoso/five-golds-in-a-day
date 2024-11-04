class Solution {
    public int countQuadruplets(int[] nums) {
        int length = nums.length;
        int[] indice = IntStream.rangeClosed(0, length - 1).toArray();

        int[] res = new int[] { 0 };
        rec(res, 0, 0, 0, length, indice, nums);
        return res[0];
    }

    public void rec(int[] res, int sum, int cur, int idx, int length, int[] indice, int[] nums) {

        for (int i = idx; i < length; i++) {
            if (cur != 3) {
                rec(res, sum + nums[i], cur + 1, i + 1, length, indice, nums);
            } else {
                if (sum == nums[i]) {
                    res[0]++;
                }
                continue;
            }
        }
    }
}