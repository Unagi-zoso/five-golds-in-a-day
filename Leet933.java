class RecentCounter {
    private LinkedList<Integer> q;
    public RecentCounter() {
        q = new LinkedList<>();
    }
    
    public int ping(int t) {
        this.q.addLast(t);
        while (!q.isEmpty() && q.getFirst() < t - 3000) q.pollFirst();        
        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */