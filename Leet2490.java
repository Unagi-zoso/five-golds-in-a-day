import java.lang.*;
import java.util.*;

class Solution {
    public boolean isCircularSentence(String sentence) {
        StringTokenizer st = new StringTokenizer(sentence);
        List<String> li = new ArrayList();
        while (st.hasMoreTokens()) {
            li.add(st.nextToken());
        }
        
        for (int i = 0; i < li.size(); i++) {
            int nextIdx = (i + 1) % li.size();
            String curStr = li.get(i);
            String nextStr = li.get(nextIdx);

            if (curStr.charAt(curStr.length() - 1) != nextStr.charAt(0)) return false;
        }
        
        return true;
    }
}

/*
 * StringTokenizer
 * - 문자열을 구분자를 기준으로 토큰으로 나누어주는 클래스
 * 
 * hasMoreTokens()
 * - 토큰이 남아있는지 확인
 * 
 * nextToken()
 * - 다음 토큰을 반환 (String)
 * 
 * String.charAt(int index) : char
 * - 문자열에서 해당 인덱스의 문자를 반환
 * 
 * String.length() : int
 * - 문자열의 길이를 반환
 * 
 * List
 * - 인터페이스
 * 
 */