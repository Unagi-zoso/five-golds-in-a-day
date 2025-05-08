import java.util.*;

class NumberContainers {
    private Map<Integer, PriorityQueue<Integer>> m = new HashMap<>();
    private Map<Integer, Integer> hist = new HashMap<>();

    public NumberContainers() {
    }

    public void change(int index, int number) {
        if (hist.containsKey(index)) {
            int oldNumber = hist.get(index);
            if (oldNumber != number) {
                m.get(oldNumber).remove(index); // 기존 number의 큐에서 제거
            }
        }

        m.computeIfAbsent(number, k -> new PriorityQueue<>()).offer(index);
        // pq 삽입 시 중복 가능
        hist.put(index, number);
    }

    public int find(int number) {
        PriorityQueue<Integer> pq = m.get(number);
        
        if (pq == null || pq.isEmpty()) return -1;

        while (!pq.isEmpty() && hist.get(pq.peek()) != number) {
            pq.poll(); // 잘못된 값 정리
        }

        return pq.peek();
    }
}