import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int answer = 0;
        
        boolean[] owns = new boolean[1005];
        int matchCnt = 0;
        int n = cards.length;
        
        for (int i = 0; i < (n / 3); i++) {
            int cc = cards[i];
            int matchC = n + 1 - cc;
            owns[cc] = true;
            if (owns[matchC]) {
                matchCnt++;
            }
        }
        
        boolean[] candi = new boolean[1005];
        
        int i = (n / 3);
        while (matchCnt >= 0) {
            answer++;
            if (i == cards.length) {
                break;
            }
            for (int x = 0; x < 2; x++) {
                int cc = cards[i];
                candi[cc] = true;
                i++;
            }
            if (matchCnt == 0 && coin > 0) {
                for (int j = 1; j <= cards.length; j++) {
                    if (candi[j] && owns[n + 1 - j] && coin >= 1) {
                        coin--;
                        matchCnt++;
                        candi[j] = false; 
                    }
                }
                for (int j = 1; j <= cards.length; j++) {
                    if (matchCnt > 0) break;
                    if (candi[j] && candi[n + 1 - j] && coin >= 2) {
                        coin -= 2;
                        matchCnt++;
                        candi[j] = false;
                        candi[n + 1 - j] = false;
                    }
                }
            }
            matchCnt--;
        }
        
        return answer;
    }
}
