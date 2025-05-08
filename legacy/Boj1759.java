//4 6
//a t c i s w

import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Boj1759 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input1 = br.readLine().split(" ");
        int l = Integer.parseInt(input1[0]);
        int n = Integer.parseInt(input1[1]);
        String[] input2 = br.readLine().split(" ");
        List<String> chars = new ArrayList<String>(); // input2 입력 초기ㅘ 가능?
        for (int i = 0; i < n; i++) {
            chars.add(input2[i]);
        }
        chars.sort(Comparator.naturalOrder());
        List<ArrayList<Integer>> combs = new ArrayList<>();
        comb(IntStream.range(0, n).toArray(), l, 0, 0, new ArrayList<Integer>(), combs);

        List<String> ans = new ArrayList<String>();
        for (List<Integer> curComb : combs) {
            String newStr = "";
            int vowelCnt = 0;
            for (int idx : curComb) {
                String curChar = chars.get(idx);
                newStr += curChar;
                if (curChar.equals("a") ||
                    curChar.equals("e") || 
                    curChar.equals("i") || 
                    curChar.equals("o") || 
                    curChar.equals("u")) {
                    vowelCnt++;
                }
            }
            if (vowelCnt > 0 && (newStr.length() - vowelCnt) >= 2) {
                ans.add(newStr);
            }
        }
        
        for (String str : ans) {
            bw.write(str + "\n");
        }
        bw.flush();
    }
    
    public static void comb(int[] base, int n, int cur, int start, ArrayList<Integer> curComb, List<ArrayList<Integer>> ret) {
        if (cur >= n) {
            ret.add(new ArrayList<>(curComb));
            return;
        }
        for (int i = start; i < base.length; i++) {
            curComb.add(base[i]);
            comb(base, n, cur + 1, i + 1, curComb, ret); // start 는 index 베이스
            curComb.remove(curComb.size() - 1);
        }
    }
}
