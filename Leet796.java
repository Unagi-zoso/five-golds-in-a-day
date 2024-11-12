class Solution {
    public boolean rotateString(String s, String goal) {

        String str = s;

        for (int i = 0; i < str.length(); i++) {
            if (str.equals(goal)) {
                return true;
            }
            str = str.substring(1, str.length()) + str.charAt(0);
        }

        return false;
        
    }
}