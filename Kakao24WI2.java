import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        
        int startVertex = -1;
        {

            int[] ods = new int[1000005];
            int[] ids = new int[1000005];
            
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
        
        Map<Integer, Info> m = new HashMap<>();
        // 시작 정점과 이어진 정점을 저장 size 1 의 막대그래프를 구분하기 위한 조건을 검증하기 위함. 
        LinkedList<Integer> startQueue = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> path = new HashMap<>();
        Map<Integer, Boolean> flag2 = new HashMap<>();
        
        for (int[] e : edges) {
            int od = e[0];
            int id = e[1];
            
            if (!path.containsKey(od)) path.put(od, new ArrayList<>());
            path.get(od).add(id);
            
            if (od != startVertex) {
                flag2.put(id, true);
            }
            
            if (od == startVertex) {
                startQueue.offer(id);
                continue;
            }
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
        while (!startQueue.isEmpty()) {
            int s = startQueue.poll();
            if (flag2.containsKey(s) && flag2.get(s)) continue;
            if (!path.containsKey(s)) answer[2]++;
        }
        return answer;
    }
    
    public static int find(int n, int[] unionArr) {
        if (unionArr[n] == n) return n;
        return find(unionArr[n], unionArr);
    }
    
    public static void union(int a, int b, int[] unionArr) {
        int aR = find(a, unionArr);
        int bR = find(b, unionArr);
        
        if (aR == bR) return;
        unionArr[aR] = bR;
    }
}