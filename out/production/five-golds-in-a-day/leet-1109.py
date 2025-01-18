class Solution:
    def corpFlightBookings(self, bookings: List[List[int]], n: int) -> List[int]:
        nujeokSum = [0] * (n + 2)
        for f, l, s in bookings:
            nujeokSum[f] += s
            nujeokSum[l + 1] -= s
        
        for i in range(1, n + 1):
            nujeokSum[i] += nujeokSum[i - 1]
        
        return nujeokSum[1: n + 1]
# cumulative sum 누적합 O(N), O(N)