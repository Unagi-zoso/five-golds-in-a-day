class Solution {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> m = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> e = equations.get(i);
            m.computeIfAbsent(e.get(0), a -> new HashMap<>()).put(e.get(1), values[i]);
            m.computeIfAbsent(e.get(1), a -> new HashMap<>()).put(e.get(0), 1/values[i]);
        }

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> q = queries.get(i);
            Set<String> vis = new HashSet<>();
            vis.add(q.get(0));
            ans[i] = dfs(m, q.get(0), q.get(1), vis);
        }
        return ans;
    }

    public double dfs(Map<String, Map<String, Double>> m, String a, String b, Set<String> vis) {
        if (!m.containsKey(a)) return -1.0;
        if (m.get(a).containsKey(b)) return m.get(a).get(b);
        
        Map<String, Double> aTable = m.get(a);
        for (String k : aTable.keySet()) {
            if (vis.contains(k)) continue;
            vis.add(k);
            double akResult = aTable.get(k);
            double kbResult = dfs(m, k, b, vis);
            if (kbResult != -1.0) return akResult * kbResult;
        }
        return -1.0;
    }
}