# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def spiralMatrix(self, m: int, n: int, head: Optional[ListNode]) -> List[List[int]]:
        matrix = [[-1] * n for _ in range(m)]
        left, right, top, bottom = 0, n - 1, 0, m - 1

        flag = True
        while flag:
            for x in range(left, right + 1):
                matrix[top][x] = head.val
                head = head.next
                if not head: 
                    flag = False
                    break
            top += 1
            if not flag: break

            for y in range(top, bottom + 1):
                matrix[y][right] = head.val
                head = head.next
                if not head: 
                    flag = False
                    break
            right -= 1
            if not flag: break

            if top <= bottom:
                for x in range(right, left - 1, -1):
                    matrix[bottom][x] = head.val
                    head = head.next
                    if not head: 
                        flag = False
                        break
                bottom -= 1
                if not flag: break

            if left <= right:
                for y in range(bottom, top - 1, -1):
                    matrix[y][left] = head.val
                    head = head.next
                    if not head: 
                        flag = False
                        break
                left += 1
                if not flag: break
                
        return matrix

'''
O(n * m)
'''