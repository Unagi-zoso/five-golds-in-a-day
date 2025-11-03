class Solution {
    public int minCost(String colors, int[] neededTime) {
        char maxCol= colors.charAt(0);
        int maxTime = neededTime[0];

        int time = 0;
        for (int i = 1; i < colors.length(); i++) {
            if (maxCol != colors.charAt(i)) {
                maxCol = colors.charAt(i);
                maxTime = neededTime[i];
            } else {
                if (maxTime < neededTime[i]) {
                    time += maxTime;
                    maxTime = neededTime[i];
                } else {
                    time += neededTime[i];
                }
            }
        }

        return time;
    }
}