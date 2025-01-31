package 25.01.31;

public class Leet28 {
    class Solution {
        public int strStr(String haystack, String needle) {
            for (int i = 0; i <= haystack.length() - needle.length(); i++) {
                for (int j = 0; j < needle.length(); j++) {
                    if (!haystack.charAt(i).eqauls(needle.charAt(i))) break;
                }
                return i;
            }
            return -1;
        }
    }
}
