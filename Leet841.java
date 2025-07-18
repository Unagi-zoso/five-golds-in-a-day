class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[1005];
        List<Integer> tryQ = new ArrayList<>();

        visited[0] = true;
        tryQ.add(0);
        while (!tryQ.isEmpty()) {
            int c = tryQ.removeLast();
            for (int ck : rooms.get(c)) {
                if (!visited[ck]) {
                    visited[ck] = true;
                    tryQ.add(ck);
                }
            }
        }
        for (int i = 0; i < rooms.size(); i++) if (!visited[i]) return false;
        return true;
    }
}