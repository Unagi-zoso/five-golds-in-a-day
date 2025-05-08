import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int st = 1;
        int lst = 200000000;
        int ans = 0;
        while (st <= lst) {
            int mid = (st + lst) / 2;
            boolean flag = check(stones, k, mid);
            
            if (flag) {
                ans = Math.max(ans, mid);
                st = mid + 1;
            } else {
                lst = mid - 1;
            }
        }
        return ans;
    }
    
    public boolean check(int[] stones, int k, int target) {
        int continuousUnableCnt = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] - target < 0) { continuousUnableCnt++;} 
            else { continuousUnableCnt = 0; }
            if (continuousUnableCnt >= k) return false;
        }
        return true;
    }
}

// TLE Case

// import java.util.*;

// class Solution {
//     class Node {
//         public int val;
//         public Node prev = null;
//         public Node next = null;
        
//         Node(int val, Node prev) {
//             this.val = val;
//             this.prev = prev;
//         }
        
//     }
    
//     public boolean check(Map<Integer, Node> visit, int index, int arrSize, int k) {
//         Node cur = visit.get(index);
        
//         if (cur.next.val - cur.prev.val > k) return false;
        
//         cur.prev.next = cur.next;
//         cur.next.prev = cur.prev;
        
//         return true;
//     }
        
//     public int solution(int[] stones, int k) {
//         int answer = 0;
        
//         PriorityQueue<int[]> pq = new PriorityQueue<>(
//             Comparator.comparingInt((int[] arr) -> arr[1])
//             .thenComparingInt(arr -> arr[0]));
        
        
//         for (int i = 0; i < stones.length; i++) {
//             pq.offer(new int[] {i, stones[i]});
//         }
        
//         Node prev = new Node(-1, null);
//         Map<Integer, Node> visit = new HashMap<>();
//         for (int i = 0; i < stones.length; i++) {
//             Node node = new Node(i, prev);
//             visit.put(i, node);
//             prev.next = node;
//             prev = node;
//         }
//         prev.next = new Node(stones.length, prev);
        
//         while (!pq.isEmpty()) {
//             int[] mnInfo = pq.poll();
//             int idx = mnInfo[0];
//             int capacity = mnInfo[1];

//             answer = Math.max(answer, capacity);

//             if (check(visit, idx, stones.length, k)) continue;        
//             return answer;
//         }
        
//         return -1;
//     }
// }


// import java.util.*;

// class Solution {
    
//     public boolean check(boolean[] visit, int index, int arrSize, int k) {
//         visit[index] = true;
//         int cnt = 1;
//         for (int i = 1; i < k; i++) {
//             if (index + i >= arrSize || !visit[index + i]) break;
//             cnt++;
//         }
        
//         for (int i = 1; i < k; i++) {
//             if (index - i < 0 || !visit[index - i]) break;
//             cnt++;
//         }
        
//         if (cnt >= k) return false;
//         return true;
//     }
        
//     public int solution(int[] stones, int k) {
//         int answer = 0;
//         boolean[] visit = new boolean[200005];
        
//         PriorityQueue<int[]> pq = new PriorityQueue<>(
//             Comparator.comparingInt((int[] arr) -> arr[1])
//             .thenComparingInt(arr -> arr[0]));
        
        
//         for (int i = 0; i < stones.length; i++) {
//             pq.offer(new int[] {i, stones[i]});
//         }
        
//         while (!pq.isEmpty()) {
//             int[] mnInfo = pq.poll();
//             int idx = mnInfo[0];
//             int capacity = mnInfo[1];

//             answer = Math.max(answer, capacity);

//             if (check(visit, idx, stones.length, k)) continue;        
//             return answer;
//         }
        
//         return -1;
//     }
// }

// import java.util.*;

// class Solution {
    
//     public boolean check(boolean[] visit, int index, int arrSize, int k) {
//         visit[index] = true;
//         int cnt = 1;
//         for (int i = 1; i < k; i++) {
//             if (index + i >= arrSize || !visit[index + i]) break;
//             cnt++;
//         }
        
//         for (int i = 1; i < k; i++) {
//             if (index - i < 0 || !visit[index - i]) break;
//             cnt++;
//         }
        
//         if (cnt >= k) return false;
//         return true;
//     }
        
//     public int solution(int[] stones, int k) {
//         int answer = 0;
//         boolean[] visit = new boolean[200005];
        
//         List<int[]> li = new ArrayList<>();
        
//         for (int i = 0; i < stones.length; i++) {
//             li.add(new int[] {i, stones[i]});
//         }
        
//         Collections.sort(li, new Comparator<int[]>() {
//             @Override
//             public int compare(int[] a, int[] b) {
//                 if (a[1] != b[1]) return a[1] - b[1];
//                 return a[0] - b[0];
//             }
//         });
        
//         for (int[] info: li) {
//             int idx = info[0];
//             int capacity = info[1];

//             answer = Math.max(answer, capacity);

//             if (check(visit, idx, stones.length, k)) continue;        
//             return answer;
//         }
//         return -1;
//     }
// }

// import java.util.*;

// class Solution {
    
//     public boolean check(boolean[] visit, int index, int arrSize, int k) {
//         visit[index] = true;
//         int cnt = 1;
//         for (int i = 1; i < k; i++) {
//             if (index + i >= arrSize || !visit[index + i]) break;
//             cnt++;
//         }
        
//         for (int i = 1; i < k; i++) {
//             if (index - i < 0 || !visit[index - i]) break;
//             cnt++;
//         }
        
//         if (cnt >= k) return false;
//         return true;
//     }
        
//     public int solution(int[] stones, int k) {
//         int answer = 0;
//         boolean[] visit = new boolean[200005];
        
//         List<int[]> stoneList = new ArrayList<>();
        
//         for (int i = 0; i < stones.length; i++) {
//             stoneList.add(new int[] {i, stones[i] });
//         }
        
//         PriorityQueue<int[]> pq = new PriorityQueue<>(
//             stoneList.size(),
//             Comparator.comparingInt((int[] arr) -> arr[1])
//             .thenComparingInt(arr -> arr[0]));
        
//         pq.addAll(stoneList);
        
//         while (!pq.isEmpty()) {
//             int[] mnInfo = pq.poll();
//             int idx = mnInfo[0];
//             int capacity = mnInfo[1];

//             answer = Math.max(answer, capacity);

//             if (check(visit, idx, stones.length, k)) continue;        
//             return answer;
//         }
        
//         return -1;
//     }
// }
