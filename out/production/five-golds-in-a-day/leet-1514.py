from heapq import heappush, heappop

class Solution:
    def maxProbability(self, n: int, edges: List[List[int]], succProb: List[float], start_node: int, end_node: int) -> float:
        visited = dict()
        route = dict()
        for i in range(len(edges)):
            l, r = edges[i]
            if l in route.keys():
                route[l].append((r, succProb[i]))
            else:
                route[l] = [(r, succProb[i])]
            if r in route.keys():
                route[r].append((l, succProb[i]))
            else:
                route[r] = [(l, succProb[i])]
        
        if not start_node in route.keys():
            return 0
            
        q = [(-1, start_node)]
        while q:
            curProb, node = heappop(q)
            curProb *= -1
            if node == end_node:
                return curProb
            if node in visited.keys():
                continue
            visited[node] = True
            for i, succProb in route[node]:
                heappush(q, (-(curProb * succProb), i))
        return 0

# 시간 복잡도: O((V+E) log V)
# 공간 복잡도: O(V)
# 확률은 최대가 1 대부분이 1보다 작은 값이라 나아갈 수로 확률은 무조건 감소한다.
# 따라서 다익스트라 적용이 가능하다.
# 코드는 좀 다듬어야겠네.


