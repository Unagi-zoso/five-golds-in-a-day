class Solution:
    def maximumWealth(self, accounts: List[List[int]]) -> int:
        return max([sum(accounts[i]) for i in range(len(accounts))])
    
# 시간복잡도 O(N * M)
# 공간복잡도 O(1)
