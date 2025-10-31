class Solution {
    public int romanToInt(String s) {
        int ret = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char curC = chars[i];
            if (i == chars.length-1) {
                if (curC == 'I') ret++;
                else if (curC == 'V') ret += 5;
                else if (curC == 'X') ret += 10;
                else if (curC == 'C') ret += 100;
                else if (curC == 'L') ret += 50;
                else if (curC == 'D') ret += 500;
                else if (curC == 'M') ret += 1000;

            } else {
                char nextC = chars[i+1];    
                if (curC == 'I') {
                    if (nextC == 'V') {
                        ret += 4;
                        i++;
                    }
                    else if (nextC == 'X') {
                        ret += 9;
                        i++;
                    }
                    else ret++;
                } else if (curC == 'X') {
                    if (nextC == 'L') {
                        ret += 40;
                        i++;
                    }
                    else if (nextC == 'C') {
                        ret += 90;
                        i++;
                    }
                    else ret += 10;
                } else if (curC == 'C') {
                    if (nextC == 'D') {
                        ret += 400;
                        i++;
                    }
                    else if (nextC == 'M') {
                        ret += 900;
                        i++;
                    }
                    else ret += 100;
                } else if (curC == 'V') ret += 5;
                else if (curC == 'L') ret += 50;
                else if (curC == 'D') ret += 500;
                else if (curC == 'M') ret += 1000;
            }
           
        }

        return ret;
    }
}