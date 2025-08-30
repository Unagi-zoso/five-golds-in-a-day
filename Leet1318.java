class Solution {
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        while (a > 0 || b > 0 || c > 0) {
            int aBit = a & 1;
            int bBit = b & 1;
            int cBit = c & 1;
            a >>= 1;
            b >>= 1;
            c >>= 1;
            if (cBit == 1) {
                ans += (aBit + bBit) > 0 ? 0 : 1;
            } else {
                ans += aBit + bBit;
            }
        }
        return ans;
        // List<Integer> biC = new ArrayList<>();
        // while (c > 0) {
        //     biC.add(c%2);
        //     c /= 2;
        // }
        // List<Integer> biA = new ArrayList<>();
        // while (a > 0) {
        //     biA.add(a%2);
        //     a /= 2;
        // }
        // List<Integer> biB = new ArrayList<>();
        // while (b > 0) {
        //     biB.add(b%2);
        //     b /= 2;
        // }
        // int longestSize = Math.max(biC.size(), Math.max(biA.size(), biB.size()));
        // while (biC.size() < longestSize) {biC.add(0);}
        // while (biA.size() < longestSize) {biA.add(0);}
        // while (biB.size() < longestSize) {biB.add(0);}
        // int ans = 0;
        // for (int i = 0; i < longestSize; i++) {
        //     if (biC.get(i) == 0) {
        //         if (biA.get(i) == 1) ans++;
        //         if (biB.get(i) == 1) ans++;
        //     } else {
        //         if (biA.get(i) == 0 && biB.get(i) == 0) ans++;
        //     }
        // }
        // return ans;
    }
}