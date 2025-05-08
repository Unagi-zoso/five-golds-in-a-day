from itertools import combinations
class Solution:
    def maxDistance(self, arrays: List[List[int]]) -> int:

        dist = -1
        minSoFar, maxSoFar = arrays[0][0], arrays[0][-1]
        for arr in arrays[1:]:
            dist = max(dist, abs(arr[-1] - minSoFar), abs(maxSoFar - arr[0]))
            minSoFar = min(minSoFar, arr[0])
            maxSoFar = max(maxSoFar, arr[-1])
        return dist

# tc : O(N)
# sc : O(1)

# 조금 복기하자면 가장 큰 거리값을 구하기 위해선 가장 큰 값과 가장 작은 값을 뺄때이다.
# 배열 내부엔 이미 정렬이 되어있었기에 max, min 을 상수시간에
# 구할 수 있었다. 이젠 최대 100000 의 N 을 어떻게 제한시간 내에 다뤄낼 것인가가
# 문제이다. 그냥 Combination 을 진행하면 N*2 로 너무 쉽게 초과한다.
# 이전 인덱스까지의 최대거리와 이전 인덱스까지의 최대값, 최소값을 가지고
# 순차접근한다면 원하는 값을 구할 수 있다. 

# 일부 댓글에선 한 배열에 제일 최대값, 최소값이 다 들어있으면 어떻게
# 처리하냐 물어봤다. 배열은 최소 두 개 이상 있으며 거리를 구할 때 사용되는건
# 이전 인덱스까지의 최대값, 최소값과 현재 인덱스의 최소값, 최대값이다.
# 다이나믹 프로그래밍할 때 가끔식 등장하는 패턴인것 같다.
# 이전의 최적화된 요소들을 관리해 현재의 관점에서 바로 처리해버리는..
