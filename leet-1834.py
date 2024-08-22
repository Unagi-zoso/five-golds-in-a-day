from heapq import heappush, heappop

class Solution:
    def getOrder(self, tasks: List[List[int]]) -> List[int]:
        for i in range(len(tasks)):
            tasks[i] = (tasks[i][0], tasks[i][1], i)
        tasks.sort(key=lambda x: x[0])
        ans = []
        hq = []
        time = tasks[0][0]
        ptr = 0
        while True:
            while ptr < len(tasks) and tasks[ptr][0] <= time:
                enqueTime, execTime,  oriIdx = tasks[ptr]
                heappush(hq, (execTime, oriIdx, enqueTime))
                ptr += 1
            
            if len(hq) == 0 and ptr >= len(tasks):
                break
            
            if len(hq) == 0 and ptr < len(tasks):
                time = tasks[ptr][0]
            elif len(hq) != 0:
                execTime, oriIdx, enqueTime = heappop(hq)
                time += execTime
                ans.append(oriIdx)

        return ans

# idle 을 잘고려해서 앞당겨야한다.
