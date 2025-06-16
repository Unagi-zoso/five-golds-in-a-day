import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] numCnt = new int[1005];
        List<Integer> uniNums = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        String[] numStr = br.readLine().split(" ");
        for (String s : numStr) {
            int num = Integer.parseInt(s);
            numCnt[num]++;
            if (numCnt[num] == 1) uniNums.add(num);
        }

        uniNums.sort(Comparator.naturalOrder());

        LinkedList<int[]> res = new LinkedList<>();
        res.offerLast(new int[] {uniNums.get(0), numCnt[uniNums.get(0)]});

        for (int i = 1; i < uniNums.size(); i++) {
            if (uniNums.get(i) - uniNums.get(i-1) == 1) {
                if (i == uniNums.size()-1) {
                    int[] temp = res.pollLast();
                    res.offerLast(new int[] {uniNums.get(i), numCnt[uniNums.get(i)]});
                    numCnt[uniNums.get(i)] = 0;
                    res.offerLast(temp);
                } else {
                    res.offerLast(new int[] {uniNums.get(i+1), 1});
                    res.offerLast(new int[] {uniNums.get(i), numCnt[uniNums.get(i)]});
                    if (--numCnt[uniNums.get(i+1)] == 0) {
                        uniNums.set(i+1, uniNums.get(i));
                        i++;
                    }
                }
            } else {
                res.offerLast(new int[] {uniNums.get(i), numCnt[uniNums.get(i)]});
            }
        }
        
        for (int[] q : res) {
            for (int i = 0; i < q[1]; i++) {
                bw.write(String.valueOf(q[0]) + " ");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}