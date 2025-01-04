// 괴팍한 로봇청소기에 꿈뻑꿈뻑 졸았습니다.

import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int time = 1;
        // 처음 도달 시 -1 * time, 충돌 시 time 으로 변경하며 ans++;
        int[][] collision = new int[105][105];
        
        // inner class 외부요소접근 불가
        class Robot {
            int id;
            int curY;
            int curX;
            int tIdx = 0;
            int[] targets;

            public Robot(int id, int curY, int curX, int[] targets) {
                this.id = id;
                this.curY = curY;
                this.curX = curX;
                this.targets = targets;
            }
            
            public int run(int time, int[][] collision) {
                int[] curTPos = points[targets[tIdx] - 1];
                if (curY != curTPos[0]) {
                    if (curY > curTPos[0]) curY--;
                    else curY++;
                } else if (curX != curTPos[1]) {
                    if (curX > curTPos[1]) curX--;
                    else curX++;    
                }
                if (curY == curTPos[0] && curX == curTPos[1]) {
                    tIdx++;
                }
                if (collision[curY][curX] != -time && collision[curY][curX] != time) {
                    collision[curY][curX] = -time;
                } else if (collision[curY][curX] == -time) {
                    collision[curY][curX] = time;
                    return 1;
                }
                return 0;
            }
        }
        
        
        boolean[] isNotGoal = new boolean[105];
        int robotEmpty = 0;
        
        List<Robot> robots = new ArrayList<>();
        for (int i = 0; i < routes.length; i++) {
            int[] pos = points[routes[i][0] - 1];
            int rId = i + 1;
            robots.add(new Robot(rId, pos[0], pos[1], routes[i]));
            isNotGoal[i] = true;
            robotEmpty += rId;
        }
        
        
        while (robotEmpty > 0) {
            for (int rIdx = 0; rIdx < routes.length; rIdx++) {
                if (!isNotGoal[rIdx]) continue;
                Robot curR = robots.get(rIdx);
                answer += curR.run(time, collision);
                if (curR.tIdx == curR.targets.length) {
                    isNotGoal[rIdx] = false;
                    robotEmpty -= curR.id;
                }
            }
            time++;
        }
        
        return answer;
    }
}