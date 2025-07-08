class Solution {
    public boolean closeStrings(String word1, String word2) {

        int[] cntOccEachLetter1 = new int[30];
        for (char ch : word1.toCharArray()) {
            int prevCnt = cntOccEachLetter1[ch - 'a'];
            cntOccEachLetter1[ch - 'a']++;
            cntOcc1[prevCnt]--;
            cntOcc1[prevCnt+1]++;
        }
        int[] cntOccEachLetter2 = new int[30];
        for (char ch : word2.toCharArray()) {
            int prevCnt = cntOccEachLetter2[ch - 'a'];
            cntOccEachLetter2[ch - 'a']++;
            cntOcc2[prevCnt]--;
            cntOcc2[prevCnt+1]++;
        }
        for (int i = 1; i < 100005; i++) {
            if (cntOcc1[i] != cntOcc2[i]) return false;
        }
        for (int i = 1; i < 30; i++) {
            if ((cntOccEachLetter1[i] == 0 && cntOccEachLetter2[i] != 0) || (cntOccEachLetter1[i] != 0 && cntOccEachLetter2[i] == 0)) return false;
        }
        return true;
    }
}