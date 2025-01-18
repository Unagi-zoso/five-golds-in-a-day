class Solution:
    def isSubPath(self, head: Optional[ListNode], root: Optional[TreeNode]) -> bool:
        q = deque()
        def search(root):
            if root.val == head.val:
                q.append(root)
            if root.left: search(root.left) 
            if root.right: search(root.right) 
        
        search(root)
        
        if not q: return False
        
        while True:
            nextQ = deque()
            head = head.next
            if not head: return True
            
            while q:
                n = q.popleft()
                if n.left and n.left.val == head.val: 
                    nextQ.append(n.left) 
                if n.right and n.right.val == head.val: 
                    nextQ.append(n.right)
            
            if not nextQ: return False
            q = nextQ
        
        return False
