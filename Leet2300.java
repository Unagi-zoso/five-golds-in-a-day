class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] ans = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int s = spells[i];
            int leftIdx = bsL(potions, success, s);
            ans[i] = potions.length - leftIdx;
        }
        return ans;
    }

    public int bsL(int[] arr, long target, int s) {
        int low = 0, high = arr.length, mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if ((long) s * arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}

// bs 조건부에만 s 를 곱하는 기믹이 재밌다. 