class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        size = 0
        node = head
        while node:
            node = node.next
            size += 1

        answerStart = head
        for i in range(size // 2):
            answerStart = answerStart.next
        
        return answerStart
        
# 링크드 리스트 가운데 노드 찾기는 역시 투 포인터 전략이지 (슬로우 패스트)
# 원리가 무엇이냐 패스트 포인터는 슬로우 포인터의 항상 두배야
# 시작점과 패스트 포인터를 직선으로 보았을 때 슬로우 포인터는 이 직선의 중점인거지
# 이렇게 패스트 포인터가 끝에 달하면 슬로우 포인터는 정중앙이거나 패스트 포인터의
# 종점 오버 여부에 따라 정중앙을 바로 한 칸 넘은 상태일 수 있다.

class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        fast_pointer = head
        slow_pointer = head

        while fast_pointer.next:
            slow_pointer = slow_pointer.next
            fast_pointer = fast_pointer.next
            if fast_pointer.next == None:
                break
            fast_pointer = fast_pointer.next
        
        return slow_pointer
    
# 난 이렇게 해는데 다른 사람은 이렇게 했네

class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        fast_pointer = head
        slow_pointer = head

        while fast_pointer and fast_pointer.next:
            slow_pointer = slow_pointer.next
            fast_pointer = fast_pointer.next.next        
        
        return slow_pointer
    
# 애초에 조건을 다음 노드가 없으면 종료하고 다음 노드가 하나라도 있다면 전진해야하네..

# 시간복잡도는.. O(n) 공간복잡도 O(1)
