class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        String ans = "0";
        for (int n1Idx = num1.length()-1; n1Idx >= 0; n1Idx--) {
            StringBuilder sb = new StringBuilder();
            int carry = 0;
            int n1Num = num1.charAt(n1Idx) - '0';
            for (int n2Idx = num2.length()-1; n2Idx >= 0; n2Idx--) {
                int n2Num = num2.charAt(n2Idx) - '0';
                sb.append((carry + n1Num * n2Num) % 10);
                carry = (carry + n1Num * n2Num) / 10;                
            }
            if (carry > 0) sb.append(carry);
            String midExpr = sb.reverse().toString() + "0".repeat(num1.length()-1 - n1Idx);
            ans = add(ans, midExpr);
        }
        return ans;
    }
    
    public String add(String num1, String num2) {
        int carry = 0;
        int n1Idx = num1.length()-1;
        int n2Idx = num2.length()-1;

        StringBuilder sb = new StringBuilder();
        while (n1Idx >= 0 && n2Idx >= 0) {
            int n1Num = num1.charAt(n1Idx--) - '0';
            int n2Num = num2.charAt(n2Idx--) - '0';

            sb.append((carry + n1Num + n2Num) % 10);
            carry = (carry + n1Num + n2Num) / 10;
        }
        while (n1Idx >= 0) {
            int n1Num = num1.charAt(n1Idx--) - '0';
            sb.append((carry + n1Num) % 10);
            carry = (carry + n1Num) / 10;
        }
        while (n2Idx >= 0) {
            int n2Num = num2.charAt(n2Idx--) - '0';
            sb.append((carry + n2Num) % 10);
            carry = (carry + n2Num) / 10;
        }
        if (carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
