import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int MAX = 1000005;
        int[] indegrees = new int[MAX];
        int[] outdegrees = new int[MAX];
        
        for (int[] e : edges) {
            int from = e[0];
            int to = e[1];
            
            indegrees[to]++;
            outdegrees[from]++;
        }
        
        int origin = -1;
        int stickCnt = 0;
        int eightCnt = 0;
        for (int i = 0; i < MAX; i++) {
            if (indegrees[i] == 0 && outdegrees[i] >= 2) origin = i;
            else if (indegrees[i] >= 1 && outdegrees[i] == 0) stickCnt++;
            else if (indegrees[i] >= 2 && outdegrees[i] == 2) eightCnt++;
        }
        int donutCnt = outdegrees[origin] - stickCnt - eightCnt;
        
        int[] answer = {origin, donutCnt, stickCnt, eightCnt};
        return answer;
    }
}