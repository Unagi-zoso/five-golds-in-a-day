class Solution:
    def numberOfSteps(self, num: int) -> int:
        cnt = 0
        while num != 0:
            cnt += 1
            if num % 2 == 0:
                num //= 2
            else:
                num -= 1
        return cnt

# 시간복잡도 O(N) 이 되려면 전부 1로 빼버리는 수 밖에 없는데
# 양,음수는 절반씩 존재하니 2씩 나누는 행위를 무시하기 힘들다.
# O(log(n)) 으로 보는게 좋을 듯 하다.

# 공간복잡도 O(1)

# 횟수 최소화 문제가 있었던거 같은데.. 뭐였지..
