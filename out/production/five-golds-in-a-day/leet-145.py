class Solution:
    def rec(self, root, res):
        if root.left is not None: self.rec(root.left, res)
        if root.right is not None: self.rec(root.right, res)
        res.append(root.val)


    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if root is None: return []
        ans = []
        self.rec(root, ans)
        return ans
    

# rec O(n)    공간복잡도는 O(h) .. 편향트리 전체출력은 O(n) 이고 하나만 찾을 땐 편향정도에 따라 달라져. 최선 로그, 최악 n

# 스택구현.. 
# 접근 순서가 호출자를 처리하고 왼쪽 우선를 하니 스택에 오른쪽을 먼저 담는다. 이걸 다른 order 에도 적용해볼까나.
class Solution(object):
    def postorderTraversal(self, root):
        # Base case...
        if not root: return []
        # Create an array list to store the solution result...
        sol = []
        # Create an empty stack and push the root node...
        bag = [root]
        # Loop till stack is empty...
        while bag:
            # Pop a node from the stack...
            node = bag.pop()
            sol.append(node.val)
            # Push the left child of the popped node into the stack...
            if node.left:
                bag.append(node.left)
            # Append the right child of the popped node into the stack...
            if node.right:
                bag.append(node.right)
        return sol[::-1]       # Return the solution list...
    