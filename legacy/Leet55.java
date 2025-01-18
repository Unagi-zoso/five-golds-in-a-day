import java.util.*;

public class Leet55 {
    public boolean canJump(int[] nums) {
        int threshold = nums[0];
        if (threshold >= nums.length - 1) {
            return true;
        }

        int[] maxJumpInfo = { 0, nums[0] };
        int i = 1;
        while (i < nums.length) {
            while (i <= threshold) {
                if (i + nums[i] > maxJumpInfo[1]) {
                    maxJumpInfo[0] = i;
                    maxJumpInfo[1] = i + nums[i];
                }
                i++;
            }

            if (maxJumpInfo[1] >= nums.length - 1) {
                return true;
            }

            if (threshold == maxJumpInfo[1]) {
                return false;
            }

            threshold = maxJumpInfo[1];
        }
        return true;
    }
}
