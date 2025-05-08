class Solution:
    def findLucky(self, arr: List[int]) -> int:
        freq = [0] * 501
        for i in arr:
            freq[i] += 1
        
        for i in range(len(freq)-1, 0, -1):
            if i == freq[i]:
                return i
        return -1
        
        