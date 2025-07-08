class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] cntOccNum = new int[1005];
        int[] cntOcc = new int[2005];
        for (int n : arr) {
            int prevCnt = cntOcc[n+1000]; 
            cntOccNum[prevCnt]--;
            int cnt = ++cntOcc[n+1000];
            cntOccNum[cnt]++;
        }
        for (int i = 1; i < cntOccNum.length; i++) {
            if (cntOccNum[i] > 1) return false;
        }
        return true;
    }
}