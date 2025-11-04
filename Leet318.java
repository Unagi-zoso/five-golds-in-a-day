class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int[] ret = new int[nums.length-k+1];
        int[] freqCnt = new int[55];
        int[] numCnt = new int[55];
        for (int i = 0; i < k; i++) {
            int num = nums[i];
            numCnt[num]++;
        }
        
        int maxFreq = 0;
        for (int i = 0; i < numCnt.length; i++) {
            maxFreq = Math.max(maxFreq, numCnt[i]);
        }

        int cnt = 0;
        while (cnt < x) {
            for (int i = numCnt.length - 1; i >= 0 && cnt < x; i--) {
                if (numCnt[i] == maxFreq) {
                    cnt++;
                    ret[0] += maxFreq * i;
                }
            }
            maxFreq--;
        }

        for (int i = k; i < nums.length; i++) {
            int num = nums[i];
            numCnt[num]++;

            int removeNum = nums[i-k];
            numCnt[removeNum]--;

            maxFreq = 0;
            for (int j = 0; j < numCnt.length; j++) {
                maxFreq = Math.max(maxFreq, numCnt[j]);
            }

            cnt = 0;
            while (cnt < x) {
                for (int j = numCnt.length - 1; j >= 0 && cnt < x; j--) {
                    if (numCnt[j] == maxFreq) {
                        cnt++;
                        ret[i-k+1] += maxFreq * j;
                    }
                }
                maxFreq--;
            }
        }

        return ret;
    }
}