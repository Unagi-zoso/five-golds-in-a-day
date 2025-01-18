import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[][] dice) {
        int n = dice.length;
        int diceSize = dice.length / 2;
        int[] diceNumArr = IntStream.range(0, n).toArray();
        
        List<ArrayList<Integer>> permu = new ArrayList<>();
        initPermu(6, diceSize, 0, new ArrayList<Integer>(), permu);
        
        // 0 번은 승리 수, 이후는 주사위 번호 (1 base로 변경해야하고 정렬하자)
        List<Integer> answer = new ArrayList<>();
        answer.add(-1);
        for (int i = 0; i < diceSize; i++) {
            answer.add(0);
        }
        solveComb(diceNumArr, dice, diceSize, 0, 0, new ArrayList<Integer>(), answer, permu);
        
        // ! stream 뒤 괄호 빼먹음
        // i -> i 대신 Integer::intValue
        int[] ansArr = answer.stream().skip(1).mapToInt(i -> i + 1).toArray();
        return ansArr;
    }
    
    // 가능한 주사위 경우의 수 구하기 여기서 제일 큰 경우 하나 구해야해
    public void solveComb(int[] baseArr, int[][] dice, int target, int cur, int startIdx, List<Integer> curDices, List<Integer> answer, List<ArrayList<Integer>> permu) {
        if (cur >= target) {
            List<Integer> result = calculateDice(curDices, dice, permu);
            if (answer.get(0) < result.get(0)) {
                // 재할당 불가능하지 않나? 함수 패럼에
                for (int i = 0; i < answer.size(); i++) {
                    answer.set(i, result.get(i));
                }
            }
            return;
        }
        for (int i = startIdx; i < baseArr.length; i++) {
            curDices.add(baseArr[i]);
            solveComb(baseArr, dice, target, cur + 1, i + 1, curDices, answer, permu);
            curDices.remove(curDices.size() - 1);
        }
    }
    
    // ! 반환형을 void 로 둬버렸다.
    public List<Integer> calculateDice(List<Integer> curDices, int[][] dice, List<ArrayList<Integer>> permu) {
        // permu readOnly 니 빼내자
        // System.out.println(permu.toString());
        
        boolean[] diceFlags = { false, false, false, false, false, false, false, false, false, false };
        
        for (int d : curDices) {
            diceFlags[d] = true;
        }
        
        List<Integer> oppDices = new ArrayList<>();
        for (int i = 0; i < dice.length; i++) {
            if (!diceFlags[i]) {
                oppDices.add(i);
            }
        }
        
        List<Integer> diceSums = new ArrayList<>();
            
        for (int i = 0; i < permu.size(); i++) {
            List<Integer> curTermu = permu.get(i);
            int curSum = 0;
            for (int j = 0; j < curTermu.size(); j++) {
                int[] curDice = dice[curDices.get(j)];
                // ! curTermu 에서 u 누락 (터미널과 헷갈린 네이밍 나빠)
                int curEye = curTermu.get(j);
                // ! curEye 를 적어야 하는데 dice 를 적어버림
                // diceSums 라 해야하는 curSums 라 했다.
                // add 할걸 += 라고했었던게 오해의 시작이였다. 반복문 내 생성 처리는 같은 뎁스
                curSum += (curDice[curEye]);
            }
            diceSums.add(curSum);
        }
        
        List<Integer> oppSums = new ArrayList<>();
        
        for (int i = 0; i < permu.size(); i++) {
            List<Integer> curTermu = permu.get(i);
            int curSum = 0;
            for (int j = 0; j < curTermu.size(); j++) {
                int[] curDice = dice[oppDices.get(j)];
                int curEye = curTermu.get(j);
                // ! collection 이라 add 해야하는걸 += 해버렸다.
                curSum += (curDice[curEye]);
            }
            oppSums.add(curSum);
        }
        
        // 여기서 문제 같네 제대로 값을 채워넣지 못하고 binarySearch 태우니 unknown source 에러가 발생한 듯 하다.
        // 음 밑에서 주석을 해서 그렇구나 .. 마찬가지네
        // System.out.println(diceSums.toString());
        // System.out.println(oppSums.toString());
        
        oppSums.sort(Comparator.naturalOrder()); // collction? collectors?
        
        int winCnt = 0;
        for (int val : diceSums) {
            int pos = Collections.binarySearch(oppSums, val);
            if (pos >= 0) {
                // binarySeach 에서 동일값 있을 시 항상 가장 왼쪽의 값을 반환해주진 않는다.
                // 동일한 값이 있을 때, 그 위치에서 왼쪽으로 중복된 값을 모두 카운트
                while (pos > 0 && oppSums.get(pos - 1).equals(val)) {
                    pos--;
                }
                winCnt += pos;
            } else {
                // 삽입 위치 = -pos - 1
                winCnt += (-pos - 1);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        result.add(winCnt);
        for (int val : curDices) {
            result.add(val);
        }
        return result;
        // return Arrays.asList(1,2,3,4,5,6,6);
    }
    
    // 단체로 재귀에서 배열을 반환하게 하면 어떻게 되는겨. curDice 도 명확히 ArrayList 로?
    public void initPermu(int n, int target, int cur, ArrayList<Integer> curDices, List<ArrayList<Integer>> permu) {
        // permu.add(new ArrayList<>()); // 문제 없는 듯.. 문제 있던 코든데 뭐 안뜬거 보면 글듯
        // ! cur target 대소 비교를 평소와 다르게 했다. 일관성 있게 합시다.
        if (cur >= target) {
            // ! curDices 를 curDice 라고 적었다.
            permu.add(new ArrayList<>(curDices));
            return;
        }
        
        for (int i = 0; i < n; i++) {
            curDices.add(i);
            initPermu(n, target, cur + 1, curDices, permu) ;
            curDices.remove(curDices.size() - 1);
        }
    }
}