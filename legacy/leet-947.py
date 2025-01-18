from collections import defaultdict
from typing import List, Tuple

class Solution:
    def removeStones(self, stones: List[List[int]]) -> int:
        stone_set = set(map(tuple, stones))
        dx = defaultdict(list)
        dy = defaultdict(list)

        for x, y in stones:
            dx[x].append((x, y))
            dy[y].append((x, y))

        connected_components = 0
        for stone in stones:
            if tuple(stone) not in stone_set:
                continue
            
            connected_components += 1
            stack = [tuple(stone)]
            while stack:
                x, y = stack.pop()
                stone_set.discard((x, y))
                for i in dx[x] + dy[y]:
                    if i != (x, y) and i in stone_set:
                        stack.append(i)

        return len(stones) - connected_components
    