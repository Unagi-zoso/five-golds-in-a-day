import java.util.*;

class Solution {
    public boolean check(int[] nums) {
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[(i) % nums.length] > nums[(i + 1) % nums.length]) {
                if (flag) return false;
                flag = true;
            }
        }
        return true;
    }
}

---

import java.util.*;

class Solution {
    public boolean check(int[] nums) {
        // 시그니쳐 바꾸기 힘드니 min 같이 Optional 타입은 orElseThrow 에 런타임예외 넣기
        int maxVal = Arrays.stream(nums).max().orElseThrow(RuntimeException::new);
        // 비효율 스멜? 일부러 배열 만들어야하나..
        // int maxValIdx = Arrays.stream(nums).boxed().collect(Collectors.toList()).indexOf(maxVal);
        int maxValIdx = IntStream.range(0, nums.length)
        .filter(i -> nums[i] == maxVal)
        .reduce((first, second) -> second)
        .orElse(-1);

        for (int i = 0; i < nums.length - 1; i++) {
            int next = (maxValIdx + 1) % nums.length;
            if (nums[next] != maxVal) break;
            maxValIdx = next;
        }

        int minValIdx = (maxValIdx + 1) % nums.length;
        
        for (int i = 0; i < nums.length - 1; i++) {
            int cur = (minValIdx + i) % nums.length;
            int next = (minValIdx + i + 1) % nums.length;

            // non-decreasing 에는 오름차순과 동일한 부분도 인정해주나보다.
            if (nums[cur] > nums[next]) return false;
        }
        return true;
    }
}