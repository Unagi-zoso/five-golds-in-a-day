class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        def rec(string, wordDict, res, cache = {}):
            if string in cache:
                return
            
            cache[string] = True

            if not string:
                res[0] = True
                return
                
            for w in wordDict:
                if string.startswith(w):
                    rec(string[len(w):], wordDict, res, cache)

        
        ans = [False]
        rec(s, wordDict, ans)
        return ans[0]

'''
문자의 길이 300, 사전 단어 수 1000, 사전 단어 최대길이 20
재귀적으로 푼다면 맨 앞에서부터 사전에 있는 1000 개의 단어를 비교해나가며
수많은 가지들을 만들 것이다. 이 시간복잡도는 생각하기가 꽤 까다롭다.
그래도 이 천개의 단어 중 시작부터 통과할 수 있는 최대 수는 300개이다.
수열개념으로.. 첫 재귀호출이 300개가 될 수 있다. 그리고 두 번째 재귀호출에선
한 브랜치다 최대 299 개가 호출 될 수 있다. 그 다음으 298 개 다.
startswith 나 1000개 단어의 반복 시간을 고려하면 재귀만으로는 성공하기가 힘들다.
다행히도 sub problem 으로 나눌 수 있는데 현재 단어로 평가를 한 다음 나머지 문자가
이미 다른 곳에서 먼저 실행된 브랜치에서 다룬 문자라면 이 브랜치는 똑같은 작업을
반복할 필요가 없다. 
문자 = "abcNNNNN" , 사전 = { "a", "ab", "bc", "c", ...} 를 예로 들 수 있겠다.
{"a", "bc"} , {"ab", "c"} 이 둘 중 하나만 실행되어도 된다는 것이다.
이렇게 될 경우 시간복잡도는 어떻게 될까..
다루는 문자가 300개로 고정된다. 중복된 문자평가는 얼리 리턴되니.
300 * 20 * 1000 -> 6000000 정도가 아닐까.
O(n * m * k)
공간복잡도는 스택 깊이 n , 메모이제이션의 n
O(n) 으로 예상하고 있다.
'''
