package 25.03.04;

import java.util.*;

class Solution {
    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int curDir = 0;
    public List<Integer> spiralOrder(int[][] matrix) {
        int cnt = 0;
        int targetCnt = matrix.length * matrix[0].length;
        List<Integer> ret = new ArrayList<>();
        boolean[][] isVisited = new boolean[105][105];
        int[] curPos = {0, 0};
        isVisited[0][0] = true;
        ret.add(matrix[curPos[0]][curPos[1]]);
        cnt++;
        
        while (cnt != targetCnt) {
            int nY = curPos[0] + dir[curDir][0];
            int nX = curPos[1] + dir[curDir][1];

            if (nY < 0 || nY >= matrix.length || nX < 0 || nX >= matrix[0].length || isVisited[nY][nX]) {
                curDir = (curDir + 1) % 4;
                continue;
            }
            curPos[0] = nY;
            curPos[1] = nX;
            isVisited[nY][nX] = true;
            cnt++;
            ret.add(matrix[nY][nX]);
        }

        return ret;
    }
}

/*
1회 순회 cnt 와 무한루프로 해결 가능..
진행했다가 막히면 다음 방향으로 순회 ..

list.stream().mapToInt(Integer::intValue).toArray();
*/

