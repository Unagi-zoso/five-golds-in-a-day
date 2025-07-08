class Solution {
    public int equalPairs(int[][] grid) {
        List<String> rows = new ArrayList<>();
        Map<String, Integer> cols = new HashMap<>();
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            StringBuilder col = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append(" " + grid[i][j]);
                col.append(" " + grid[j][i]);
            }
            rows.add(row.toString());
            cols.put(col.toString(), cols.getOrDefault(col.toString(), 0) + 1);
        }
        int ans = 0;
        for (String r : rows) {
            if (cols.containsKey(r)) ans += cols.get(r);
        }
        return ans;
    }
}