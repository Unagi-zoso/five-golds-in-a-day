class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        ransomeNoteAlphas = [0] * 30
        magazineAlphas = [0] * 30

        for c in ransomNote:
            ransomeNoteAlphas[ord(c) - ord('a')] += 1
        for c in magazine:
            magazineAlphas[ord(c) - ord('a')] += 1
        
        for idx in range(30):
            if magazineAlphas[idx] < ransomeNoteAlphas[idx]:
                return False
        return True

        
# 시간복잡도 O(N + M)
# 공간복잡도 O(60)

# 코테용으로 파이썬을 쓰는데 전혀 파이썬 답지 못하다.. AI 에게 물어봐야지

# Counter 객체는 다음과 같은 비교 연산자를 지원합니다:
# - ==: 두 Counter 객체가 같은 요소와 개수를 가지고 있는지 비교합니다.
# - !=: 두 Counter 객체가 다른 요소나 개수를 가지고 있는지 비교합니다.
# - <: 한 Counter 객체가 다른 Counter 객체의 부분집합인지 비교합니다.
# - <=: 한 Counter 객체가 다른 Counter 객체의 부분집합이거나 같은지 비교합니다.
# - >: 한 Counter 객체가 다른 Counter 객체의 상위집합인지 비교합니다.
# - >=: 한 Counter 객체가 다른 Counter 객체의 상위집합이거나 같은지 비교합니다.

class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        st1, st2 = Counter(ransomNote), Counter(magazine)
        return st1 <= st2
    