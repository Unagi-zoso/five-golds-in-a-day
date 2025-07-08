class Solution {
    public String removeStars(String s) {
        Stack<Character> stk = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (stk.isEmpty()) continue;
                stk.pop();
            } else {
                stk.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stk) sb.append(c);
        return sb.toString();
    }
}