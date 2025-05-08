import java.util.*;

class Solution {
    static int[] ranks = new int[1000005];
    public int[] solution(int[][] edges) {
        
        int startVertex = -1;
        (new HashSet<Integer>()).iterator();
        int[] ods = new int[1000005];
        int[] ids = new int[1000005];
        {   
            for (int[] e : edges) {
                int od = e[0];
                int id = e[1];
                ods[od]++;
                ids[id]++;
            }    
            for (int i = 0; i < 1000005; i++) {
                if (ods[i] > 1 && ids[i] == 0) startVertex = i;
            }
        }
        
        int[] unionArr= new int[1000005];
        {
            for (int i = 0; i < 1000005; i++) {
                unionArr[i] = i;
                ranks[i] = 1;
            }
        
            for (int[] e : edges) {
                int od = e[0];
                int id = e[1];
                if (od == startVertex) continue;
                union(od, id, unionArr);
            }
        }
        
        class Info {
            public Set<Integer> set;
            public Integer cnt;
            
            public Info() {
                set = new HashSet<>();
                cnt = 0;
            };
        }
        
        int[] answer = {startVertex, 0, 0, 0};
        
        // 각 집합 별 정점의 수와 간선의 수를 저장
        Map<Integer, Info> m = new HashMap<>();
        for (int[] e : edges) {
            int od = e[0];
            int id = e[1];
            
            if (od == startVertex) continue;
            
            int root = find(od, unionArr);
            if (!m.containsKey(root)) {
                m.put(root, new Info());               
            } 
            Info info = m.get(root);
            info.set.add(od);
            info.set.add(id);
            info.cnt++;
        }

        for (int key : m.keySet()) {
            Info info = m.get(key);
            int vCnt = info.set.size();
            int eCnt = info.cnt;
            if ((vCnt - eCnt) == 0) {
                answer[1]++;
            } else if ((vCnt - eCnt) > 0) {
                answer[2]++;
            } else {
                answer[3]++;
            }
        }

        int[] idsNotFromStart = new int[1000005];
        for (int i = 0; i < 1000005; i++) {
            idsNotFromStart[i] = -1;
        }
        {   
            for (int[] e : edges) {
                int od = e[0];
                int id = e[1];
                if (idsNotFromStart[id] == -1) idsNotFromStart[id] = 0;
                if (od == startVertex) continue;
                idsNotFromStart[id]++;
            }
        }

        for (int i = 0; i < 1000005; i++) {
            if (ods[i] == 0 && idsNotFromStart[i] == 0) answer[2]++;
        }
        return answer;
    }
    
    public static int find(int n, int[] unionArr) {
        if (unionArr[n] == n) return n;
        unionArr[n] = find(unionArr[n], unionArr);
        return unionArr[n];
    }
    
    public static void union(int a, int b, int[] unionArr) {
        int aR = find(a, unionArr);
        int bR = find(b, unionArr);
        
        if (aR == bR) return;
        if (ranks[aR] == ranks[bR]) {
            unionArr[aR] = bR;    
            ranks[bR]++;
        } else if (ranks[aR] < ranks[bR]) {   
            unionArr[aR] =bR;
        } else {
            unionArr[bR] = aR;
        }
    }
}