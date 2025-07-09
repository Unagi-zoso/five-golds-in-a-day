class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> sbStk = new Stack<>();
        Stack<Integer> numStk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num *= 10;
                num += c - '0';
            } else if (c == '[') {
                numStk.push(num);
                num = 0;
                sbStk.push(sb);
                sb = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tempSb = sbStk.pop();
                int repeatNum = numStk.pop();
                for (int i = 0; i < repeatNum; i++) {
                    tempSb.append(sb.toString());
                }
                sb = tempSb;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}