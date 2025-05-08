class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        l1, l2, l3 = len(s1), len(s2), len(s3)
        if l1 + l2 != l3: return False
        dp = [[False] * (l1 + 1) for _ in range(l2 + 1)]
        dp[0][0] = True

        for i in range(1, l1 + 1):
            dp[0][i] = dp[0][i - 1] and s1[i - 1] == s3[i - 1]

        for i in range(1, l2 + 1):
            dp[i][0] = dp[i - 1][0] and s2[i - 1] == s3[i - 1]

        for i in range(1, l2 + 1):
            for j in range(1, l1 + 1):
                dp[i][j] = (dp[i][j - 1] and s1[j - 1] == s3[i + j - 1]) or (dp[i - 1][j] and s2[i - 1] == s3[i + j - 1])
        
        return dp[l2][l1]
    
# O(n^2), O(n^2)

class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        def rec(_s1, _s2, _s3, cache = {}):
            if not _s3 and (_s1 or _s2): return False
            if not _s1 and _s2 == _s3:
                return True
            if not _s2 and _s1 == _s3:
                return True
            
            flag = False
            ret = False
            if _s1 and _s1[0] == _s3[0]:
                if not _s1[1:] + ' ' + _s2 + ' ' + _s3[1:] in cache and \
                    not _s2 + ' ' + _s1[1:] + ' ' + _s3[1:] in cache : 
                    flag = True
                    cache[_s1[1:] + ' ' + _s2 + ' ' + _s3[1:]] = True
                    cache[_s2 + ' ' + _s1[1:] + ' ' + _s3[1:]] = True
                    ret = ret or rec(_s1[1:], _s2, _s3[1:], cache)
            if _s2 and _s2[0] == _s3[0]:
                if not _s1 + ' ' + _s2[1:] + ' ' + _s3[1:] in cache and \
                    not _s2[1:] + ' ' + _s1 + ' ' + _s3[1:] in cache :
                    flag = True
                    cache[_s1 + ' ' + _s2[1:] + ' ' + _s3[1:]] = True
                    cache[_s2[1:] + ' ' + _s1 + ' ' + _s3[1:]] = True
                    ret = ret or rec(_s1, _s2[1:], _s3[1:], cache)
            
            if not flag:
                return False
            return ret
        
        return rec(s1, s2, s3)

'''
최근 풀어본 문자열 문자에서 영감을 받아 다시 풀어봤습니다.
최악의 경우 O(2^n) 으로 처리되는 재귀형식의 풀이를
(남아있는 s1, 남아있는 s2, 남아있는 s3), (남아있는 s2, 남아있는 s1, 남아있는 s3) 는
subproblem 으로 볼 수 있겠구나 싶어 이 부분을 memoization 했습니다.
캐싱을 통해서 중복된 연산은 빠르게 return 하게 하여 순서를 가진 s1, s2 로 만들 수 있는
경우의 수 memoization 에서 담아내고자 하는 부분은 서로 독립적인 s1, s2 의 각 상태들을
조합한 것이다. 고로 시간복잡도는 O(n * m)
'''

class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
            (n1, n2, n3) = map(len, [s1, s2, s3])
            if n1 + n2 != n3: return False

            dp = [[False] * (n1 + 1) for _ in range(n2 + 1)]

            dp[0][0] = True
            for i in range(1, n1 + 1):
                dp[0][i] = dp[0][i - 1] and s1[i - 1] == s3[i - 1]
            
            for i in range(1, n2 + 1):
                dp[i][0] = dp[i - 1][0] and s2[i - 1] == s3[i - 1]

            for i in range(1, n2 + 1):
                for j in range(1, n1 + 1):                    
                    dp[i][j] = (dp[i - 1][j] and s2[i - 1] == s3[i + j - 1]) \
                        or (dp[i][j - 1] and s1[j - 1] == s3[i + j - 1])
            
            return dp[n2][n1]
    

# 메모리 공간을 줄여보자.
class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
            (n1, n2, n3) = map(len, [s1, s2, s3])

            if n1 + n2 != n3: return False
            
            if n2 > n1:
                s1, s2 = s2, s1
                n1, n2 = n2, n1

            dp = [[False] * (n1 + 1) for _ in range(2)]

            dp[0][0] = True
            for i in range(1, n1 + 1):
                dp[0][i] = dp[0][i - 1] and s1[i - 1] == s3[i - 1]
            
            
            for i in range(1, n2 + 1):
                dp[i % 2][0] = s2[:i] == s3[:i]
                for j in range(1, n1 + 1):                    
                    dp[i % 2][j] = (dp[(i - 1) % 2][j] and s2[i - 1] == s3[i + j - 1]) \
                        or (dp[i % 2][j - 1] and s1[j - 1] == s3[i + j - 1])
            
            return dp[n2 % 2][n1]
# 시간 O(n * m) 공간 O(n) n >= m
