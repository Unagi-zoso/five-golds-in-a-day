class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        for (int a : asteroids) {
            if (stk.isEmpty()) {
                stk.add(a);
                continue;
            }
            if (a > 0) {
                stk.add(a);
                continue;
            }
            // 자기보다 작은거 제거
            while (!stk.isEmpty() && stk.peek() > 0 && stk.peek() + a < 0) {
                stk.pop();
            }
            // 동타이면 둘 다 제거
            if (!stk.isEmpty() && stk.peek() + a == 0) {
                stk.pop();
                continue;
            }
            if (stk.isEmpty() || stk.peek() < 0) stk.add(a);
        }
        int[] result = new int[stk.size()];
        for (int i = 0; i < stk.size(); i++) result[i] = stk.get(i);
        return result;
    }
}