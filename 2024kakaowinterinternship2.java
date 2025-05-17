import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[][] edges) {
        Set<Integer> ids = new HashSet<>();
        Map<Integer, List<Integer>> inMap = new HashMap<>();
        Map<Integer, List<Integer>> outMap = new HashMap<>();
        
        for (int[] e : edges) {
            inMap.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
            outMap.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            ids.add(e[1]);
            ids.add(e[0]);
        }
        
        int[] answer = {0, 0, 0, 0};
        
        for (int id : ids) {
            int indegree = inMap.getOrDefault(id, Collections.emptyList()).size();
            int outdegree = outMap.getOrDefault(id, Collections.emptyList()).size();
            if (indegree == 0 && outdegree >= 2) {
                answer[0] = id;
                break;
            }
        }
        
        for (int id : ids) {
            int indegree = inMap.getOrDefault(id, Collections.emptyList()).stream()
                .filter(i -> i != answer[0])
                .collect(Collectors.toSet())
                .size();
            int outdegree = outMap.getOrDefault(id, Collections.emptyList()).size();
            
            
            if (indegree == 2 && outdegree == 2) answer[3]++;
            else if (outdegree == 0) answer[2]++;            
        }
        answer[1] = outMap.get(answer[0]).size() - answer[2] - answer[3];
        
        return answer;
    }
}