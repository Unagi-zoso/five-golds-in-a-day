class Node:
    def __init__(self, val, prev, next):
        self.val = val
        self.prev = prev
        self.next = next

class LinkedList:
    def __init__(self, node):
        self.node = node

    def rotate(self, k):
        for j in range(k):       
            self.node = self.node.next

    def removeCurNode(self):
        self.node.prev.next = self.node.next
        self.node.next.prev = self.node.prev

class Solution:
    def findTheWinner(self, n: int, k: int) -> int:
        node = Node(1, None, None)
        linkedList = LinkedList(node)
        
        prevNode = linkedList.node
        for i in range(2, n + 1):
            newNode = Node(i, prevNode, None)
            prevNode.next = newNode
            prevNode = newNode

        prevNode.next = node
        node.prev = prevNode
        node = node.prev

        for i in range(n):
            linkedList.rotate(k)
            linkedList.removeCurNode()

        return linkedList.node.val

#

from collections import deque

class Solution:
    def findTheWinner(self, n: int, k: int) -> int:
        q = deque(range(n))
        for _ in range(n-1):
            q.rotate(1-k)
            q.popleft()
        return q[0] + 1
    
class Solution:
    def findTheWinner(self, n: int, k: int) -> int:
        q = [i + 1 for i in range(n)]
        removeIdx = 0
        while len(q) != 1:
            removeIdx = (removeIdx + k - 1) % len(q)
            q.pop(removeIdx)
        return q[0]
    
# O(N^2)
# O(N)  
# 
# (cur_ind + k - 1) % n 리스트를 순환 리스트처럼 쓸 수 있게 해준다.
#  
#



