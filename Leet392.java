class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.equals("")) return true;
        int sIdx = 0;
        for (char tc : t.toCharArray()) {
            if (s.charAt(sIdx) == tc) sIdx++;
            if (sIdx == s.length()) return true;
        }
        return false;
    }
}