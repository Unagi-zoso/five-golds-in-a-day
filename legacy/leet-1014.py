class Solution:
    def maxScoreSightseeingPair(self, values: List[int]) -> int:
        ans = 0
        max_i = values[0]
        for j in range(1, len(values)):
            ans = max(ans, max_i + values[j] - j)
            max_i = max(max_i, values[j] + j)
        
        return ans

        
# value 와 dist 두 가지로 평가되니 뭘 기주느로 접근해야 시간을 단축할 수 있을까
# 반으로 접어버려? dist 가 두 개 중복되니까.. 기준이 늘 상대적이니 의미 없네 

# 연산식을 재정렬한다. 기존 바식을 사용하면 N^2 으로 제한시간을 넘어간다.
# (values[i] + i) + (values[j] - j)
# i < j 란 조건이 있다. (values[i] + i) 은 j 이전의 값 중 가장 큰 것이면 된다.
# 즉 한 번의 순회로 해결할 수 있다.
