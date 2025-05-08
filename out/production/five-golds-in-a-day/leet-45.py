'''
배열에 있는 값만큼 점프해서 갈 수 있는데 마지막원소까지 최소의 점프로 가게 하자.
'''
class Solution:
    def jump(self, nums: List[int]) -> int:
        # INF = float('INF')
        # dp = [0] + [INF] * 10000
        # for i in range(len(nums)):
        #     for j in range(0, nums[i] + 1): # 잘 생각해보면 한 번 순회하는걸로 해결이 가능함
        #         if i + j >= len(nums): break
        #         dp[i + j] = min(dp[i + j], dp[i] + 1)
        
        # return dp[len(nums) - 1]
        ans = 0
        far = 0
        end = 0
        for i in range(len(nums) - 1):
            far = max(far, i + nums[i]) # 현재 인덱스도 함께 저장해야해 뒤에선 최장 far가 누구 인덱스라는걸 알아낼 수 없어
            if far >= (len(nums) - 1):
                return ans + 1
            if i == end:
                ans += 1
                end = far
        return ans
        

        
