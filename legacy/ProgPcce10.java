public import java.util.*;
import java.util.stream.*;

class Solution {
    public int countBorder(String[][] park, int[] pos, int cur, int max) {
        int[] temp = { pos[0], pos[1] };
        for (int i = 0; i < cur; i++) {
            temp[0] = pos[0] + i * 1;
            if (temp[0] >= park.length || !park[temp[0]][temp[1]].equals("-1")) return cur - 1;
        }
        
        for (int i = 1; i < cur; i++) {
            temp[1] = pos[1] - i * 1;
            if (temp[1] < 0 || !park[temp[0]][temp[1]].equals("-1")) return cur - 1;
        }
        
        pos[1]++;
        if (pos[1] >= park[0].length) return cur;
        
        return countBorder(park, pos, cur + 1, max);
    }
    
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        int maxMat = Arrays.stream(mats).max().orElseThrow();
        int mv = -1;
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length; j++) {
                if (!park[i][j].equals("-1")) continue;
                int[] newPos = {i, j}; // 패러미터에 넣으면 안되네
                int cnt = countBorder(park, newPos, 1, maxMat);
                mv = Math.max(mv, cnt);
            }
        }
        
        answer = -1;
        for (int i = 0; i < mats.length; i++) {
            if (mats[i] > mv) continue;
            if (mv - mats[i] < mv - answer) {
                answer = mats[i];
            }
        }
        
        return answer;
    }
} 