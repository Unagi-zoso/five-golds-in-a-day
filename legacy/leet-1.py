class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)):
            nums[i] = (nums[i], i)
        
        nums.sort()

        for i in range(len(nums)-1):
            idx = bisect_left(nums, target - nums[i][0], i + 1, len(nums) - 1, key=lambda x: x[0])
            if nums[idx][0] == target - nums[i][0]:
                return [nums[i][1], nums[idx][1]]

# O(nlog(n)), O(n)

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hM = {}
        
        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in hM:
                return [hM[complement], i]
            hM[nums[i]] = i
        
# O(n) O(n)