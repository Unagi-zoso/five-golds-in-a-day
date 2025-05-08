class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        setPos = 0
        for i in range(len(nums)):
            if nums[i] == val:
                setPos += 1
            else:
                nums[i - setPos] = nums[i]
        return len(nums) - setPos
        