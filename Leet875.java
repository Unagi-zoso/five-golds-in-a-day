class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int mx = Integer.MIN_VALUE;
        for (int p : piles) mx = Math.max(mx, p);

        int low = 1, high = mx, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            long sum = 0;
            for (int i = 0; i < piles.length; i++) {
                sum += (piles[i] + mid - 1) / mid;
            }
            if (sum > h) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}

// piles 범위는 h 기준을 초과한다해도 bs 과정 중에서 검증 가능 따라서 최대값 그냥 사용하면 된다.
// mid 는 divide 로 적용된다.
// 배열 접근 아닌 원소직접접근이라 닫힌 범위
// ceil 을 수학적으로 처리한 것도 재밌 (target + div -1) / div