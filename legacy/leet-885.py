class Solution:
    def spiralMatrixIII(self, rows: int, cols: int, rStart: int, cStart: int) -> List[List[int]]:
        if rows * cols == 1: return [[rStart, cStart]]
        ans = []
        def letsSpin(st, l):
            rS, cS = st
            for dS in range(l - 2):
                rS, cS = rS + 1, cS
                if (0 <= rS < rows) and (0 <= cS < cols):
                    ans.append([rS, cS])
            for dS in range(l - 1):
                rS, cS = rS, cS - 1
                if (0 <= rS < rows) and (0 <= cS < cols): 
                    ans.append([rS, cS])
            for dS in range(l - 1):
                rS, cS = rS - 1, cS
                if (0 <= rS < rows) and (0 <= cS < cols): 
                    ans.append([rS, cS])

            for dS in range(l - 1):
                rS, cS = rS, cS + 1
                if (0 <= rS < rows) and (0 <= cS < cols): 
                    ans.append([rS, cS])
            
            

        prev = 1
        curStart = (rStart, cStart)
        
        while True:
            if (0 <= curStart[0] < rows) and (0 <= curStart[1] < cols): 
                ans.append([curStart[0], curStart[1]])
            
            letsSpin(curStart, prev)

            if len(ans) == (rows * cols): break
            if prev == 1: 
                curStart = (curStart[0], curStart[1] + 1)
            else:
                curStart = (curStart[0] - 1, curStart[1] + 1)
            prev = prev + 2
        
        return ans
'''
문제를 제대로 이해하지 않고 풀어서 시간이 많이 걸렸다.
매트릭스를 그려서 풀 땐 좀 더 정확히 그려서 풀어야겠다.
스스로 눈을 속이는 일이 많이 일어난다. 그리고 주어진 문제 예시를
대충 보지말고 꼼꼼히 봐야할 것 같다.
'''

class Solution:
    def spiralMatrixIII(self, rows: int, cols: int, rStart: int, cStart: int) -> List[List[int]]:
        ans = [[rStart, cStart]]

        dir = [[[0, 1], [1, 0]], [[0, -1], [-1, 0]]]
        r, c, step = rStart, cStart, 1
        while len(ans) != (rows * cols):
            for dr, dc in dir[(step % 2) - 1]:
                for _ in range(step):
                    r, c = r + dr, c + dc
                    if 0 <= r < rows and 0 <= c < cols:
                        ans.append([r, c])
            step += 1

        return ans


'''
패턴을 읽으면 첫 스텝에 오른쪽, 밑쪽 접근
다음 스텝에 왼쪽, 윗쪽 접근
이렇게 접근하면 된다.. 똑똑한 사람들이 참 많아..
'''