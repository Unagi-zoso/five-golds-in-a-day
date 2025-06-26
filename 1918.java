import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();
        // StringBuilder sb = new StringBuilder();
        List<String> inputStr = new ArrayList<>();
        for (char c : input) {
            inputStr.add(String.valueOf(c));
        }

        Stack<String> stk = new Stack<>();
        for (String s : inputStr) {
            if (s.equals(")")) {
                List<String> tempList = new ArrayList<>();
                while (!stk.isEmpty()) {
                    String tempStr = stk.pop();
                    if (tempStr.equals("(")) break;
                    tempList.add(tempStr);
                }
                Collections.reverse(tempList);
                String result = compute(tempList);
                stk.push(result);
            } else {
                stk.push(s);
            }
        }
        String ans = compute(stk);
        bw.write(ans);
        bw.flush();
        bw.close();
        br.close();
    }

    public static String compute(List<String> statement) {
        if (statement.size() == 1) return statement.get(0);
        Stack<String> operatorStk = new Stack<>();
        Stack<String> operandStk = new Stack<>();

        for (int i = 0; i < statement.size(); i++) {
            String s = statement.get(i);
            if (s.equals("/") || s.equals("*")) {
                String lhs = operatorStk.pop();
                String rhs = statement.get(++i);
                operatorStk.push(lhs + rhs + s);
            } else if (s.equals("+") || s.equals("-")) {
                operandStk.push(s);
            } else {
                operatorStk.push(s);
            }
        }
        Collections.reverse(operatorStk);
        Collections.reverse(operandStk);

        StringBuilder sb = new StringBuilder();
        sb.append(operatorStk.pop());
        while (!operandStk.isEmpty()) {
            sb.append(operatorStk.pop());
            sb.append(operandStk.pop());
        }
        return sb.toString();
    }
}