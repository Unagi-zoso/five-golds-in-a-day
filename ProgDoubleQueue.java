import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> tM = new TreeMap<>();
        for (String op : operations) {
            String[] splited = op.split(" ");
            String cmd = splited[0];
            int val = Integer.parseInt(splited[1]);
            if (cmd.equals("I")) {
                tM.computeIfAbsent(val, k -> 0);
                tM.put(val, tM.get(val) + 1);
            } else {
                if (tM.isEmpty()) continue;
                if (val == 1) {
                    int greatest = tM.lastKey();
                    int greatestCnt = tM.get(greatest);
                    if (greatestCnt == 1) {
                        tM.remove(greatest);
                    } else {
                        tM.put(val, greatestCnt-1);
                    }
                } else if (val == -1) {
                    int lowest = tM.firstKey();
                    int lowestCnt = tM.get(lowest);
                    if (lowestCnt == 1) {
                        tM.remove(lowest);
                    } else {
                        tM.put(val, lowestCnt-1);
                    }
                }
            }
        }
        int[] answer = {0, 0};
        if (!tM.isEmpty()) {
            answer[0] = tM.lastKey();
            answer[1] = tM.firstKey();
        }
        return answer;
    }
}