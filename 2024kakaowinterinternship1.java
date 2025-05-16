import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int id = 0;
        Map<String, Integer> friendT = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            friendT.put(friends[i], id++);
        }
        
        int[] metric = new int[55];
        int[][] logs = new int[55][55];
        for (String gift : gifts) {
            String[] log = gift.split(" ");
            int from = friendT.get(log[0]);
            int to = friendT.get(log[1]);
            logs[from][to]++;
            metric[from]++;
            metric[to]--;
        }
        
        int[] answers = new int[55];
        for (int i = 0; i < id; i++) {
            for (int j = 0; j < i; j++) {
                if (logs[i][j] > logs[j][i]) {
                    answers[i]++;
                } else if (logs[i][j] < logs[j][i]) {
                    answers[j]++;
                } else {
                    if (metric[i] > metric[j]) {
                        answers[i]++;
                    } else if (metric[i] < metric[j]) {
                        answers[j]++;
                    }
                }
            }
        }
        
        return Arrays.stream(answers).max().orElse(0);
    }
}

/*
* 두 사람 사이에 주고 받은 기록이 있다면 대소 비교를 통해 다음에 보너스
* 로깅 없거나 비교 결과가 동일하면 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 바든다. 선물 지수 큰 사람이 보너스
*  선물 지수 : 이번 달까지 자신이 .. 아웃 디그리 - 인디그리
* 회원별 지수를 따로 관리해야하긴 하겠다. 별개로
* 선물지수조차 같다면 선물을 주고받지 않는다.

* 그 결과 다음 달 선물 젤 많이 받을 애 찾아내기
* 친구의 이름이 담긴 1차원 friend (중복 없음)
* 이번 주고받은 선물 내역 1차원 배열 (로그느낌)
* 2차원 배열로 다뤄야할듯
* 해시로 닉네임 , 아이디
* 일차배열로 아이디 , 선물지수
* 일차원배열로 관계 정의
* 이차원배열로 관계 정의하고 계단만 처리해 
*/