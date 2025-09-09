class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<int[]> stk = new Stack<>(); // 0: temperature, 1: origin index
        for (int i = 0; i < temperatures.length; i++) {
            int curTemper = temperatures[i];
            while (!stk.isEmpty() && stk.peek()[0] < curTemper) {
                int[] lessTemper = stk.pop();
                int temper = lessTemper[0];
                int idx = lessTemper[1];
                answer[idx] = i - idx;
            }
            stk.push(new int[] {curTemper, i});
        }
        return answer;
    }
}