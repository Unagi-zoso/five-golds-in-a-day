import java.util.*;

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int firstDiff = -1, secondDiff = -1;
        int diffCnt = 0;

        if (s1.equals(s2)) return true;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCnt++;
                if (firstDiff == -1) firstDiff = i;
                else if (secondDiff == -1) secondDiff = i;
            }
        }

        if (diffCnt > 2 || diffCnt == 1) return false;
        
        return s1.charAt(secondDiff) == s2.charAt(firstDiff) && s1.charAt(firstDiff) == s2.charAt(secondDiff);
    }
}
