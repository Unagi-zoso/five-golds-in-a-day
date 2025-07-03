class Solution {
    public String reverseVowels(String s) {
        char[] strChArr = s.toCharArray();
        int leftIdx = 0;
        int rightIdx = strChArr.length - 1;
        while (leftIdx < rightIdx) {
            while (leftIdx < strChArr.length && !isVowel(strChArr[leftIdx])) leftIdx++;
            while (rightIdx >= 0 && !isVowel(strChArr[rightIdx])) rightIdx--;
            if (leftIdx >= rightIdx) break;
            char temp = strChArr[leftIdx];
            strChArr[leftIdx] = strChArr[rightIdx];
            strChArr[rightIdx] = temp;
            leftIdx++;
            rightIdx--;
        }
        return new String(strChArr);
    }

    public static boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U');
    }
}