class Solution:
    def minimumSwap(self, s1: str, s2: str) -> int:
        n_s1, n_s2 = "", ""
        for i in range(len(s1)):
            if s1[i] != s2[i]:
                n_s1 += s1[i]
                n_s2 += s2[i]
        
        if len(n_s1) % 2 != 0: return -1

        n_s1 = sorted(n_s1)
        ans = 0
        for i in range(1, len(n_s1), 2):
            if n_s1[i-1] == n_s1[i]:
                ans += 1
            else:
                ans += 2
        return ans

# yy xx 같은 경우의 비용이 더 저렴하기에 greedy 상 우선순위에 있다.
# 즉 정렬할 경우 유리한 상황을 기대할 수 있다. 최적의 결과를
# 그리고 각 문자들은 독립적인 관계라 정렬을 해 순서를 바꿔도 상관없다.
# matched case 는 제외하고 unmatched case 만 n_s 에 담았다.
# 두 개씩 묶어서 해결할 수 있다는게 좀 어려웠네.. 3개로 다루면 뭔가
# 더 저렴한 경우가 있지 않을까 했는데.. 그렇진 않구나.. 흐

# 똑똑한 선생님의 코드

class Solution:
    def minimumSwap(self, s1: str, s2: str) -> int:
        x_y, y_x = 0, 0
        for c1, c2 in zip(s1, s2):
            if c1 != c2:
                if c1 == 'x':
                    x_y += 1
                else:
                    y_x += 1
        
        if (x_y + y_x) % 2 != 0: return -1

        ans = x_y // 2
        ans += y_x // 2

        ans += 2 if x_y % 2 != 0 else 0

        return ans
        
# 숫자로만 다루고 난 정렬을 해서 두 개씩 다뤘지만
# 독립적인 관계의 한 문자열 상의 문자들을 잘 처리했다.
# 적어도 두 개만 있으면 묶어서 최소처리를 할 수 있다.
