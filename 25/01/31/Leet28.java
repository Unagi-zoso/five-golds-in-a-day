package 25.01.31;

/*
 * 입력값만 보면 1억번의 연산이 될것 같은데 문제특성상 그렇진 않아서 간단한 풀이로도 해결이 가능했다.
 */

public class Leet28 {
    class Solution {
        public int strStr(String haystack, String needle) {
            for (int i = 0; i <= haystack.length() - needle.length(); i++) {
                boolean flag = true;
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) return i;
            }
            return -1;
        }
    }
}

---

/*
 * 조금 더 개선해보자.
 * 좀 더 심플 바운더리를 쫄깃하게 다룬다. 조금 더 직관적인 느낌
 */

 class Solution {
    public int strStr(String haystack, String needle) {
        for (int st = 0, lst = needle.length(); lst <= haystack.length(); st++, lst++) {
            if (haystack.substring(st, lst).equals(needle)) return st;
        }       
        return -1;
    }
}

---

