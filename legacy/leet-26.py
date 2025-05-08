class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        ans = []
        ans.append(nums[0])
        for i in nums[1:]:
            if ans[-1] != i:
                ans.append(i)        
        for i in range(len(ans)):
            nums[i] = ans[i]
        return len(ans)

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        setPos = 0
        for i in range(len(nums)):
            if i + 1 < len(nums) and nums[i] != nums[i + 1]:
                nums[setPos] = nums[i]
                setPos += 1
        nums[setPos] = nums[-1]
        return setPos + 1
            
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        setPos = 1
        for i in range(1, len(nums)):
            if nums[i] != nums[i - 1]:
                nums[setPos] = nums[i]
                setPos += 1
        return setPos
            
