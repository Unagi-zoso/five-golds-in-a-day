class Solution:    
    def maxPoints(self, points: List[List[int]]) -> int:
        m, n = len(points), len(points[0])
        
        prev = points[0]
        for i in range(1, m):
            left = [prev[0]] + [0] * (n - 1)
            for j in range(1, n):
                left[j] = max(left[j - 1] - 1, prev[j])

            right = [0] * (n - 1) + [prev[n - 1]]
            for j in range(n - 2, -1, -1):
                right[j] = max(right[j + 1] - 1, prev[j])
            
            cur = []
            for j in range(n):
                cur.append(max(left[j], right[j]) + points[i][j])
            prev = cur
        
        return max(prev)

# 시간 O(N * M) 
# 공간 O(N)
# left, right 방향의 두포인터 느낌으로 최대값을 찾는 방식
# 두 사이의 거리에 대한 페널티를 dp 에서 1 을 점진적으로 subtract 하면서
# 해결하는 부분은 정말 환상적이다. 똑똑한 사람들 참 많아.
