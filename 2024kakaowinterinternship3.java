import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        Set<Integer> oneCoins = new HashSet<>(); // 코인 하나 주면 살 수 있는 애들
        Queue<Integer> twoCoins = new LinkedList<>(); // 코인 두 개 주면 살 수 있는 애들
        int[] cardCnts = new int[505]; // 이미 반영된 애들 (실존)
        int[] candiCnts = new int[505]; // 가질 순 업속 뽑을 수 있는 애드
        int n = cards.length;
        int chance = 0; // 턴을 넘길 수 있는 횟수
        int idx = 0;
        for (; idx < n / 3; idx++) {
            int target = cards[idx] > (n + 1) / 2 ? n + 1 - cards[idx] : cards[idx];
            
            if (++cardCnts[target] == 2) {
                chance++;
            } else if (cardCnts[target] == 1) {
                oneCoins.add(target);
            }
        }
        // 코인 하나로 구할 수 있으면 최고지
        // 코인 두개로 가능한 애들도 추적은 해서 별다른 수 없으면 지르자.
        int ans = 0;
        while (true) {
            ans++;
            if (idx == n) break;
            
            for (int i = 0; i < 2; i++, idx++) {
                int target = cards[idx] > (n + 1) / 2 ? n + 1 - cards[idx] : cards[idx];
                if (coin > 0 && oneCoins.contains(target)) {
                    coin--;
                    chance++;
                } else if (coin > 0 && ++candiCnts[target] == 2) {
                    twoCoins.offer(target);
                }
            }
            if (chance == 0 && coin >= 2 && !twoCoins.isEmpty()) {     
                twoCoins.poll();
                coin -= 2;
                chance++;
            }
            if (--chance < 0) break;
            
        }
        
        return ans;
    }
}

/*
*   1~n 까지 하나씩 있는 카드 뭉치 있다. (유일)
    coin 도 몇 개 가지고 있다.
    
    게임은 다음과 같이 진행
    처음에 카드 n/3 을 뽑아 모두 가진다. (n은 6읩 ㅐ수)
    코인은 coin 개 가진다.
    
    두 잔 뽑. 동전 소모해 가질 수 있다
    카드에 적힌 수의 합이 N+1 이 되게 카드를 내면 다음 라운드로 갈 수 있고 못하면 아웃
    
    최대 라운드 수를 리턴하라. 
*/