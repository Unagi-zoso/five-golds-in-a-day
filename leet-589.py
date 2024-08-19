class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        ans = []
        self.doPreorder(root, ans)
        return ans        
        
    def doPreorder(self, root: 'Node', ans):
        if root == None: return
        ans.append(root.val)
        for i in root.children:
            self.doPreorder(i, ans)

# 


class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        if root is None: return []

        ans = []
        stk = [root]
        while stk:
            cur = stk.pop()
            ans.append(cur.val)
            stk.extend(cur.children[::-1])
        return ans
    