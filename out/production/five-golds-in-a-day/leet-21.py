# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        ans = []
        while list1 and list2:
            if list1.val <= list2.val:
                 ans.append(list1)
                 list1 = list1.next
            else:
                ans.append(list2)
                list2 = list2.next
        while list1:
            ans.append(list1)
            list1 = list1.next
        while list2:
            ans.append(list2)
            list2 = list2.next
        
        for i in range(1, len(ans)):
            ans[i - 1].next = ans[i]
            
        if len(ans) >=1 :
            return ans[0]
        else:
            return None
        
# O(n) O(n)

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        head = cur = ListNode()

        while list1 and list2:
            if list1.val <= list2.val:
                cur.next = list1
                cur = cur.next
                list1 = list1.next
            else:
                cur.next = list2
                cur = cur.next
                list2 = list2.next
        while list1:
            cur.next = list1
            cur = cur.next
            list1 = list1.next
        while list2:
            cur.next = list2
            cur = cur.next
            list2 = list2.next

        return head.next
    