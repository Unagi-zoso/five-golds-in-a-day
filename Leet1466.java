class Solution {
    boolean[] vis = new boolean[100000];
    List<List<List<Integer>>> con = new ArrayList<>();
    public int minReorder(int n, int[][] connections) {
        for (int i = 0; i <= n; i++) con.add(new ArrayList<>());
        for (int[] conn : connections) {
            List<Integer> temp = Arrays.asList(conn[0], 0);
            con.get(conn[1]).add(temp);
            temp = Arrays.asList(conn[1], 1);
            con.get(conn[0]).add(temp);
        }

        vis[0]= true;
        return rec(0);
    }

    public int rec(int to) {
        int retCost = 0;
        for (List<Integer> info : con.get(to)) {
            int from = info.get(0);
            int cost = info.get(1);
            if (vis[from]) continue;
            vis[from] = true;
            retCost += rec(from) + cost;
        }
        return retCost;
    }
}