from collections import defaultdict
from heapq import heapify, heappush, heappop

class Solution:

    def nthUglyNumber(self, n: int) -> int:
        used = defaultdict(bool)
        s = []
        ans = 0
        heappush(s, 1)
        for _ in range(n):
            v = heappop(s)
            ans = v
            if not used[v*2]:
                heappush(s, v*2)
                used[v*2] = True
            if not used[v*3]:
                heappush(s, v*3)
                used[v*3] = True
            if not used[v*5]:
                heappush(s, v*5)
                used[v*5] = True
        return ans

# 시간 복잡도 O(NlogN) 순차조회 시 heap 추가, 제거로 이한 시간복잡도
# 공간 복잡도 O(N) 우선순위 큐와 중복여부를 위한 콜렉션은 같은 최대 크기를 가진다. O(2 * 3 * N)
