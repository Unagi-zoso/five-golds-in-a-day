class Solution {
    public String predictPartyVictory(String senate) {
        LinkedList<Integer> rQ = new LinkedList<>();
        LinkedList<Integer> dQ = new LinkedList<>();
        int n = senate.length();
        for (int i = 0; i < n; i++) {
            char c = senate.charAt(i);
            if (c == 'R') rQ.add(i);
            if (c == 'D') dQ.add(i);
        }
        while (!rQ.isEmpty() && !dQ.isEmpty()) {
            if (rQ.getFirst() < dQ.getFirst()) {
                dQ.pollFirst();
                rQ.addLast(rQ.pollFirst() + n);
            } else {
                rQ.pollFirst();
                dQ.addLast(dQ.pollFirst() + n);
            }
        }
        if (rQ.isEmpty()) return "Dire";
        else return "Radiant";
    }
}