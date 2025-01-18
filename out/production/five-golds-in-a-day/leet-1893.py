class Solution:
    def isCovered(self, ranges: List[List[int]], left: int, right: int) -> bool:
        
        s = set()
        for i in range(left, right + 1):
            for l, r in ranges:
                if l <= i <= r:
                    s.add(i)
                    break
        
        return len(s) == (right - left + 1) 
