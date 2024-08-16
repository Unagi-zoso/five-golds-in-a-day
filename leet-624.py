from itertools import combinations
class Solution:
    def maxDistance(self, arrays: List[List[int]]) -> int:

        dist = -1
        minSoFar, maxSoFar = arrays[0][0], arrays[0][-1]
        for arr in arrays[1:]:
            dist = max(dist, abs(arr[-1] - minSoFar), abs(maxSoFar - arr[0]))
            minSoFar = min(minSoFar, arr[0])
            maxSoFar = max(maxSoFar, arr[-1])
        return dist

# tc : O(N)
# sc : O(1)
