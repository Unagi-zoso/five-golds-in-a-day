# 표편집하자네
# "U X": 현재 선택된 행에서 X칸 위에 있는 행을 선택합니다.
# "D X": 현재 선택된 행에서 X칸 아래에 있는 행을 선택합니다.
# "C" : 현재 선택된 행을 삭제한 후, 바로 아래 행을 선택합니다. 단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택합니다.
# "Z" : 가장 최근에 삭제된 행을 원래대로 복구합니다. 단, 현재 선택된 행은 바뀌지 않습니다.

# 삭제하면 밀려온다..

# 처음 주어진 표의 상태를 비교하여 삭제되지 않은 행과 삭제된 행 구분해 표시. 처음부터 삭제된 애도 있어?

# 5 ≤ n ≤ 1,000,000 표 행의 수
# 0 ≤ k < n 0부터 시작 . 커서 인덱스
# 1 ≤ cmd의 원소 개수 ≤ 200,000
# cmd의 각 원소는 "U X", "D X", "C", "Z" 중 하나입니다.
# X는 1 이상 300,000 이하인 자연수이며 0으로 시작하지 않습니다.
# X가 나타내는 자연수에 ',' 는 주어지지 않습니다. 예를 들어 123,456의 경우 123456으로 주어집니다.
# cmd에 등장하는 모든 X들의 값을 합친 결과가 1,000,000 이하인 경우만 입력으로 주어집니다. 이게 관계가 있어? 이게 시간 깎는 핵심?
# 표의 모든 행을 제거하여, 행이 하나도 남지 않는 경우는 입력으로 주어지지 않습니다.
# 본문에서 각 행이 제거되고 복구되는 과정을 보다 자연스럽게 보이기 위해 "이름" 열을 사용하였으나, "이름"열의 내용이 실제 문제를 푸는 과정에 필요하지는 않습니다. "이름"열에는 서로 다른 이름들이 중복없이 채워져 있다고 가정하고 문제를 해결해 주세요.
# 표의 범위를 벗어나는 이동은 입력으로 주어지지 않습니다. ?! 오버플로우 케이스는 없다.
# 원래대로 복구할 행이 없을 때(즉, 삭제된 행이 없을 때) "Z"가 명령어로 주어지는 경우는 없습니다. ?! 의미없는 롤백 없다
# 정답은 표의 0행부터 n - 1행까지에 해당되는 O, X를 순서대로 이어붙인 문자열 형태로 return 해주세요.

# 예상 시간복잡도 nlogn

# 제거와 롤백 동기화하며 다룰 수 있는 커서 만들기.
# 이름을 해시테이블에 이건 아닌듯
# 링크드 리스트에 넣을까?, 커서를? n번 돌면서 바이섹트?

# 삭제를 고려하지 않으면 그냥 인덱스 이동.
# 삭제된 녀석을 고려하면 체크하면서 넘어가야해 이렇게 되면 해결 가능한데 백만 * 이십만
# 이동하려는 공간 사이에 제거된거 고려해서 그만큼 플러스 이걸 어떻게 계산하지.
# 각 실제로 삭제를 해버리까. 애초에 실제로 움직이면 답이 없다?

# 삭제된게 뭉티기로 있는 곳에 바이섹트

# cmd에 등장하는 모든 X들의 값을 합친 결과가 1,000,000 이하인 경우만 입력으로 주어집니다. 이게 관계가 있어? 이게 시간 깎는 핵심?
# 니에... 

# 링크드 리스트로 다루면 완전 인덱스 덩이로 다루는 것보다 더 빠르게 할 수 있다.

# 제거될 때마다 양옆 애들을 이어줄 수 있거든 삭제시 바로해줄 수 있어. 롤백은.. 양옆에 애꺼 뻇어오면 되는데 어디있는지 알고

def solution(n, k, cmd):
    class Node:
        def __init__(self, left = None, right = None) -> None:
            self.left = left
            self.right = right
            self.remove_flag = False
            
    answer = ''
    ll = [Node(left=i-1, right=i+1) for i in range(n)]
    ll[0].left = None
    ll[n-1].right = None
    removed_stk = []

    for c in cmd:
        c = c.split()
        if c[0] == 'U':
            for _ in range(int(c[1])):
                k = ll[k].left
        elif c[0] == 'D':
            for _ in range(int(c[1])):
                k = ll[k].right
        elif c[0] == 'C':
            ll[k].remove_flag = True
            l, r = ll[k].left, ll[k].right
            removed_stk.append(k)
            if l:
                ll[l].right = r
            if r:
                ll[r].left = l

            if r:
                k = r
            else:
                k = l
                
        elif c[0] == 'Z':
            rollback_idx = removed_stk.pop()
            ll[rollback_idx].remove_flag = False
            l, r = ll[rollback_idx].left, ll[rollback_idx].right

            if l:
                ll[l].right = rollback_idx
            if r:
                ll[r].left = rollback_idx

    for i in range(n):
        if ll[i].remove_flag:
            answer += "X"
        else:
            answer += "O"

    return answer
