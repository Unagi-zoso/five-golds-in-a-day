import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        Arrays.sort(wallet);
        Arrays.sort(bill);
        
        while ((bill[0] > wallet[0] || bill[1] > wallet[1]) &&
              (bill[1] > wallet[0] || bill[0] > wallet[1])) {
            bill[1] /= 2;
            Arrays.sort(bill);
            answer++;
        }
        
        return answer;
    }
}
// 뭔가 while 문의 조건부는 헷갈린다.