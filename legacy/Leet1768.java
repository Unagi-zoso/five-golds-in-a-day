class Solution {
    public String mergeAlternately(String word1, String word2) {
        String result = "";
        int w1Idx = 0, w2Idx = 0;
        while (w1Idx < word1.length() && w2Idx < word2.length()) {
            result += word1.charAt(w1Idx++);
            result += word2.charAt(w2Idx++);
        }

        while (w1Idx < word1.length()) {
            result += word1.charAt(w1Idx++);
        }

        while (w2Idx < word2.length()) {
            result += word2.charAt(w2Idx++);
        }

        return result;
    }
}
