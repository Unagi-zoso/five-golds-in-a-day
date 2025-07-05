class Solution {
    class InsertSupporter {
        int idx = 0;
        char[] chars;
        public InsertSupporter(char[] chars) {
            this.chars = chars;
        }

        public void insert(String ch, int num) {
            if (num == 1) {
                chars[idx++] = ch.charAt(0);
            } else {
                chars[idx++] = ch.charAt(0);
                for (char numCh : String.valueOf(num).toCharArray()) {
                    chars[idx++] = numCh;
                }
            }
        }

        public int getIdx() {
            return idx;
        }
    }

    public int compress(char[] chars) {
        InsertSupporter iSup = new InsertSupporter(chars);
        int i = 0;
        while (i < chars.length) {
            char ch = chars[i];
            int chCnt = 0;
            while (i < chars.length && ch == chars[i]) {
                chCnt++;
                i++;
            }
            iSup.insert(String.valueOf(ch), chCnt);
        }
        return iSup.getIdx();
    }
}