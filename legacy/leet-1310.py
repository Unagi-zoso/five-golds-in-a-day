class Solution:
    def xorQueries(self, arr: List[int], queries: List[List[int]]) -> List[int]:
        prefixXOR = [0] * (3 * 10**4)
        prefixXOR[0] = arr[0]
        for i in range(1, len(arr)):
            prefixXOR[i] = prefixXOR[i - 1] ^ arr[i]
        
        ans = []
        for i, j in queries:
            if i - 1 >= 0:
                ans.append(prefixXOR[j] ^ prefixXOR[i - 1])
            else:
                ans.append(prefixXOR[j])
        return ans

'''
1 <= arr.length, queries.length <= 3 * 10^4
1 <= arr[i] <= 109
queries[i].length == 2
0 <= lefti <= righti < arr.length

조건이 주어진 두 배열 사이즈만 해도 30000 이 넘는다.
게다가 연산대상 숫자는 10억이다
웬만해선 10억의 숫자로 연산을 하기엔 벅찰 것 같다. 비트연산의 신호인가..
보안 공부할 때 배웠던 대칭키의 복호화 개념을 가져오면 꽤 잘 풀릴 수 있다.
a ^ b ^ a -> b
즉 b 와 a 가 한 번 XOR 를 했다면 (암호화) 
한 번 더 a 로 XOR 함으로써 원래 b 를 얻어낼 수 있는 것이다. (복호화)
그리고 누적합의 개념을 가져온다. 
n 개의 배열을 두고 각 원소마다 해당 원소까지 올 때 만난 모든 원소와의 XOR 를 저장한다.
모든 원소는 자신의 원소를 인덱스로 했을 때 arr 배열에 있는 수와 자신의 원소 이전 누적 XOR 와
XOR 하게되는데 
만약 2 ~ 4 사이의 XOR 결과를 얻고 싶다면
4 까지의 누적 XOR 에 1 (2 - 1) 까지의 누적 XOR 을 다시 한 번 XOR 해주면 그 사이 결과를 구할 수 있다.
a ^ b ^ a -> b 로 비유하자면
(0 ~ 1 누적 XOR) ^ (2 ~ 4 누적 XOR) ^ (0 ~ 1 누적 XOR) -> (2 ~ 4 누적 XOR)
우리는 원소 0부터 n - 1 까지 누적 XOR 를 따로 저장했음으로
(0 ~ 1 누적 XOR) ^ (2 ~ 4 누적 XOR) 를 (0 ~ 4 누적 XOR) 이라는 값을 편하게 구할 수 있다.
따라서 이렇게 구할 수 있다.
(0 ~ 4 누적 XOR) ^ (0 ~ 1 누적 XOR) -> (2 ~ 4 누적 XOR)
'''        