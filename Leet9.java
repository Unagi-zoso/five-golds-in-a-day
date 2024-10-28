class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        List arr = new ArrayList<Integer>();
        while (x > 0) {
            arr.add(x % 10);
            x /= 10;
        }
        Collections.reverse(arr);
        
        for (int i = 0; i < arr.size() / 2; i++) {
            if (arr.get(i) != arr.get(arr.size() - 1 - i)) return false;
        }
        return true;
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int originX = x;
        int n = 0;
        while (x > 0) {
            n *= 10;
            n += x % 10;
            x /= 10;
        }
        
        return originX == n;
    }
}

