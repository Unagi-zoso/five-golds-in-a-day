'''
새로운 노드의 생성 타이밍과 노드끼리의 관계를 이어주는 타이밍 사이를 어떻게 볼 것인가?
1. 재귀를 통해 노드끼리 관계를 이어주며 그 때마다 노드를 생성해준다.
2. 필요한 모든 노드를 만든 뒤 원본과 똑같이 관계를 이어준다.
3. 같은 타이밍에도 할 수 있긴하다. 인지력이 딸리네요..

재귀를 사용하지 않는 2번이 더 빠르다. bfs를 두 번 쓴다.
'''
"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if node is None: return None
        cache = {}
        vis = {}
        q = deque([node])
        while q:
            n = q.popleft()
            vis[n.val] = 1
            cache[n.val] = Node(n.val)
            for i in n.neighbors:
                if i.val in vis: continue
                q.append(i)
                vis[i.val] = 1
        
        vis = {}
        q.append(node)
        while q:
            n = q.popleft()
            vis[n.val] = 1
            for i in n.neighbors:
                cache[n.val].neighbors.append(cache[i.val])
            for i in n.neighbors:
                if i.val in vis: continue
                q.append(i)
                vis[i.val] = 1
        
        return cache[1]

# O(n+e) O(n)

class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return None

        clone_map = {}
        queue = deque([node])
        clone_map[node] = Node(node.val)

        while queue:
            current = queue.popleft()
            for neighbor in current.neighbors:
                if neighbor not in clone_map:
                    clone_map[neighbor] = Node(neighbor.val)
                    queue.append(neighbor)
                clone_map[current].neighbors.append(clone_map[neighbor])

        return clone_map[node]