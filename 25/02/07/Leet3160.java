import java.util.*;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        List<Integer> answer = new ArrayList<>();
        int ans = 0;
        Map<Integer, Integer> countOfColor = new HashMap<>();  
        Map<Integer, Integer> ballsColor = new HashMap<>();  

        for (int[] q : queries) {
            int target = q[0];
            int nextColor = q[1];

            int curColor = ballsColor.getOrDefault(target, -1);
            if (curColor != -1) {
                if (curColor == nextColor) { 
                    answer.add(ans);
                    continue;
                }

                int curCountOfColor = countOfColor.getOrDefault(curColor, -1);
                
                if (--curCountOfColor == 0) {
                    ans--;
                } 

                countOfColor.put(curColor, curCountOfColor);
                
            }
            
            ballsColor.put(target, nextColor);            
            int nextCountOfColor = countOfColor.getOrDefault(nextColor, 0);

            if (++nextCountOfColor == 1) {
                ans++;
            }
            
            countOfColor.put(nextColor, nextCountOfColor);
            answer.add(ans);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
