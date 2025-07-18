class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> con = new ArrayList<>();
        for (int[] c : connections) {
            List<Integer> temp = new ArrayList<>();
            temp.add(c[1]);
            temp.add(c[0]);
            temp.add(0);
            con.add(temp);
            temp = new ArrayList<>();
            temp.add(c[0]);
            temp.add(c[1]);
            temp.add(1);
            con.add(temp);
        }
        Collections.sort(con, (a, b)->Integer.compare(a.get(0), b.get(0)));
        int ans = 0;
        boolean[] visited = new boolean[100000];
        LinkedList<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int i = q.poll();
            int lIdx = bsL(con, i);
            int rIdx = bsR(con, i);
            for (int j = lIdx; j < rIdx; j++) {
                int from = con.get(j).get(0);
                int to = con.get(j).get(1);
                int cost = con.get(j).get(2);
                if (visited[to]) continue;
                visited[to] = true;
                q.offer(to);
                ans += cost;
            }
        }
        return ans;
    }

    public int bsR(List<List<Integer>> con, int target) {
        int st = 0;
        int ed = con.size();
        while (st < ed) {
            int mid = st + (ed - st) / 2;
            if (con.get(mid).get(0) <= target) {
                st = mid +1;
            } else if (con.get(mid).get(0) > target) {
                ed = mid;
            }
        }
        return st;
    }

    public int bsL(List<List<Integer>> con, int target) {
        int st = 0;
        int ed = con.size();
        while (st < ed) {
            int mid = st + (ed - st) / 2;
            if (con.get(mid).get(0) < target) {
                st = mid +1;
            } else if (con.get(mid).get(0) >= target) {
                ed = mid;
            }
        }
        return st;
    }
}