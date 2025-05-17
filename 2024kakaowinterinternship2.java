import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[][] edges) {
        Set<Integer> nodeIds = new HashSet<>();
        Map<Integer, List<Integer>> incomingEdges = new HashMap<>();
        Map<Integer, List<Integer>> outgoingEdges = new HashMap<>();

        for (int[] edge : edges) {
            int fromNode = edge[0];
            int toNode = edge[1];

            incomingEdges.computeIfAbsent(toNode, k -> new ArrayList<>()).add(fromNode);
            outgoingEdges.computeIfAbsent(fromNode, k -> new ArrayList<>()).add(toNode);

            nodeIds.add(fromNode);
            nodeIds.add(toNode);
        }

        int[] answer = {0, 0, 0, 0};
        int startNode = 0;

        // 나가는 간선 수가 2 미만인 노드들의 집합 (시작 노드 후보에서 제외)
        Set<Integer> excludedNodes = nodeIds.stream()
                .filter(node -> outgoingEdges.getOrDefault(node, Collections.emptyList()).size() < 2)
                .collect(Collectors.toSet());

        // 들어오는 간선이 없는 노드 중에서 excludedNodes에 포함되지 않은 노드가 시작 노드
        Set<Integer> startNodeCandidates = new HashSet<>(nodeIds);
        startNodeCandidates.removeAll(incomingEdges.keySet());
        startNodeCandidates.removeAll(excludedNodes);

        if (!startNodeCandidates.isEmpty()) {
            startNode = startNodeCandidates.iterator().next();
            answer[0] = startNode;

            Set<Integer> visited = new HashSet<>();
            visited.add(startNode);

            if (outgoingEdges.containsKey(startNode)) {
                for (int neighbor : outgoingEdges.get(startNode)) {
                    LinkedList<Integer> queue = new LinkedList<>();
                    List<Integer> inNeighbors = new ArrayList<>(incomingEdges.getOrDefault(neighbor, Collections.emptyList()));
                    inNeighbors.remove(Integer.valueOf(startNode)); // 시작 노드에서 오는 간선 제거

                    queue.offer(neighbor);
                    visited.add(neighbor);

                    int minIncoming = inNeighbors.size();
                    int maxIncoming = inNeighbors.size();
                    int minOutgoing = outgoingEdges.getOrDefault(neighbor, Collections.emptyList()).size();
                    int maxOutgoing = outgoingEdges.getOrDefault(neighbor, Collections.emptyList()).size();

                    while (!queue.isEmpty()) {
                        Integer currentNode = queue.poll();
                        List<Integer> nextNodes = outgoingEdges.getOrDefault(currentNode, Collections.emptyList());

                        if (nextNodes.isEmpty()) {
                            minOutgoing = Math.min(minOutgoing, 0);
                            maxOutgoing = Math.max(maxOutgoing, 0);
                            continue;
                        }

                        for (Integer nextNode : nextNodes) {
                            if (visited.contains(nextNode)) continue;
                            visited.add(nextNode);

                            int currentIncoming = incomingEdges.getOrDefault(nextNode, Collections.emptyList()).size();
                            int currentOutgoing = outgoingEdges.getOrDefault(nextNode, Collections.emptyList()).size();

                            minIncoming = Math.min(minIncoming, currentIncoming);
                            maxIncoming = Math.max(maxIncoming, currentIncoming);
                            minOutgoing = Math.min(minOutgoing, currentOutgoing);
                            maxOutgoing = Math.max(maxOutgoing, currentOutgoing);

                            queue.offer(nextNode);
                        }
                    }

                    if (minOutgoing == 0) answer[2]++;
                    else if (maxIncoming >= 2) answer[3]++;
                    else if (maxOutgoing == 1 && minOutgoing == 1) answer[1]++;
                }
            }
        }

        return answer;
    }
}