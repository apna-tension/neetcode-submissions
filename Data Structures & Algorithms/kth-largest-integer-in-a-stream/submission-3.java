class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for (int ele : nums) {
            if (pq.size() == k && pq.peek() >= ele) continue;
            if (pq.size() == k) pq.poll();
            pq.offer(ele);
        }
    }
    
    public int add(int val) {
        if (pq.size() == k && pq.peek() < val) pq.poll();
        if (pq.size() != k) pq.offer(val);
        return pq.peek();
    }
}
