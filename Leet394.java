class Solution {
    public String decodeString(String s) {
        Stack<Character> stk = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ']') {
                StringBuilder sb = new StringBuilder();
                while (!stk.isEmpty() && stk.peek() != '[') {
                    sb.append(stk.pop());
                }
                stk.pop(); // erase [
                char[] targetStr = sb.reverse().toString().toCharArray();
                sb.setLength(0);
                while (!stk.isEmpty() && Character.isDigit(stk.peek())) {
                    sb.append(stk.pop());
                }
                int repeatNum = Integer.parseInt(sb.reverse().toString());

                for (int i = 0; i < repeatNum; i++) {
                    for (char tSC : targetStr) {
                      stk.push(tSC);
                    }
                }
            } else {
                stk.push(c);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char c : stk) {
            ans.append(c);
        }
        return ans.toString();
    }
}