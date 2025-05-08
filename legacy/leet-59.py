class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        val = 1
        ans = [[0] * n for _ in range(n)]
        left, right, top, bottom =  0, n - 1, 0, n - 1
        
        while (left <= right) and (top <= bottom):
            for x in range(left, right + 1):
                ans[top][x] = val
                val += 1
            top += 1

            for y in range(top, bottom + 1):
                ans[y][right] = val
                val += 1
            right -= 1

            if top <= bottom:
                for x in range(right, left - 1, -1):
                    ans[bottom][x] = val
                    val += 1
                bottom -= 1
            
            if left <= right:
                for y in range(bottom, top - 1, -1):
                    ans[y][left] = val
                    val += 1
                left += 1
        
        return ans

