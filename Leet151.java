import java.util.*;

class Solution {
    public String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') continue;
            sb.setLength(0);
            int j = i;
            while (j < s.length()) {
                if (s.charAt(j) == ' ') break;
                sb.append(s.charAt(j));
                j++;
            }
            i = j;
            words.add(sb.toString());
        }
        Collections.reverse(words);
        return String.join(" ", words);
    }
}