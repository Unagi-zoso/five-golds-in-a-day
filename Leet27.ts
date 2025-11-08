function removeElement(nums: number[], val: number): number {
    let pSum = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] === val) {
            pSum++;
            continue;
        }
        nums[i-pSum] = nums[i];
    }
    return nums.length-pSum;
};