class Solution {
    public int maxVowels(String s, int k) {
        int idx = 0;
        int cntVowel = 0;
        int maxCntVowel = 0;
        while (idx < k) {
            char ch = s.charAt(idx++);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                cntVowel++;
            }
        }
        maxCntVowel = cntVowel;
        while (idx < s.length()) {
            char prevCh = s.charAt(idx-k);
            if (prevCh == 'a' || prevCh == 'e' || prevCh == 'i' || prevCh == 'o' || prevCh == 'u') {
                cntVowel--;
            }
            char ch = s.charAt(idx++);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                cntVowel++;
            }
            maxCntVowel = Math.max(maxCntVowel, cntVowel);
        }
        return maxCntVowel;
    }
}