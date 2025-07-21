class SmallestInfiniteSet {

    //TreeSet<Integer> s = new TreeSet<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Set<Integer> s = new HashSet<>();
    public SmallestInfiniteSet() {
        //IntStream.rangeClosed(1, 1000).forEach(i -> s.add(i));
        IntStream.rangeClosed(1, 1000).forEach(i -> {pq.offer(i); s.add(i);});
    }
    
    public int popSmallest() {
        //return s.removeFirst();
        int ret = pq.poll();
        s.remove(ret);
        return ret;
    }
    
    public void addBack(int num) {
        //s.add(num);
        if (s.contains(num)) return;
        s.add(num);
        pq.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */