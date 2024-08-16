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

# 시간복잡도 O(N)
# 공간복잡도 O(1)

# 횟수 최소화 문제가 있었던거 같은데.. 뭐였지..
