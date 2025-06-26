import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();
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
        Stack<String> expressStk = new Stack<>();

        for (int i = 0; i < statement.size(); i++) {
            String s = statement.get(i);
            if (s.equals("/") || s.equals("*")) {
                String lhs = expressStk.pop();
                String rhs = statement.get(++i);
                expressStk.push(lhs + rhs + s);
            } else if (s.equals("+") || s.equals("-")) {
                expressStk.push(s);
            } else {
                expressStk.push(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(expressStk.get(0));
        for (int i = 1; i < expressStk.size(); i += 2) {
            sb.append(expressStk.get(i+1));
            sb.append(expressStk.get(i));
        }
        return sb.toString();
    }
}