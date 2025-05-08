"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def rec(self, i, li):
        li.append(i.val)
        ch = reversed(i.children)
        for c in ch:
            self.rec(c, li)

    def postorder(self, root: 'Node') -> List[int]:
        if root is None: return []
        # print(root)
        # dq = deque(root)
        # tree = Node(dq.popleft(), [])
        # dq.popleft()
        # while dq:
        #     node = dq.popleft()
        #     if node is None: continue
        #     tree.children.append(node)
        #     dq.push(node)
        
        # print(tree)
        ans = []
        self.rec(root, ans)
        return reversed(ans)




