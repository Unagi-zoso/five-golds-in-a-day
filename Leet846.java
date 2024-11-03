// LinkedList
// tc: O(nlogn), sc: O(n)

import java.util.*;
import java.lang.*;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        Arrays.sort(hand);

        LinkedList<int[]> li = new LinkedList<>();

        for (int i = 0; i < hand.length; i++) {
            if (li.size() != 0 && li.getLast()[0] == hand[i]) {
                li.getLast()[1]++;
            } else {
                li.add(new int[] { hand[i], 1 });
            }
        }

        while (!li.isEmpty()) {
            if (li.size() < groupSize) return false;
            
            int prev = -1;
            for (int i = 0, idx = 0; i < groupSize; i++) {
                int[] data = li.get(idx);

                if (i == 0) {
                    prev = data[0];
                } else {
                    if (prev + 1 != data[0]) return false;
                    prev = data[0];
                }

                data[1]--;
                if (data[1] == 0) li.remove(data);
                else idx++;
            }
        }

        return true;
    }
}

// PriorityQueue
// tc: O(nlogn), sc: O(n)

import java.util.*;
import java.lang.*;

class Solution {
        public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0){
            return false;
        }
        if(groupSize==1)
            return true;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        Arrays.sort(hand);
        for(int i:hand){
            if(pq.isEmpty() || pq.peek()[0]==i){
                pq.add(new int[]{i, 1});
            } else if(i>pq.peek()[0]+1){
                return false;
            } else {
                int[] tmp = pq.poll();
                tmp[0] = i;
                tmp[1]++;
                if(groupSize>tmp[1]){
                    pq.add(tmp);
                }
            }
        }
        if(pq.isEmpty()){
            return true;
        }
        return false;
    }
}