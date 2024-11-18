import java.util.*;
import java.io.*;

public class Boj2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String nums = br.readLine();

        // 스택 역할을 하는 StringBuilder
        StringBuilder stack = new StringBuilder();
        int toRemove = k; // 제거해야 할 숫자의 개수

        for (int i = 0; i < n; i++) {
            char current = nums.charAt(i);
            // 스택에서 현재 숫자보다 작은 숫자를 제거
            while (toRemove > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) < current) {
                stack.deleteCharAt(stack.length() - 1);
                toRemove--;
            }
            stack.append(current); // 현재 숫자를 스택에 추가
        }

        // 숫자를 너무 적게 제거했으면 뒤에서 제거
        while (toRemove > 0) {
            stack.deleteCharAt(stack.length() - 1);
            toRemove--;
        }

        System.out.println(stack.toString());
    }
}