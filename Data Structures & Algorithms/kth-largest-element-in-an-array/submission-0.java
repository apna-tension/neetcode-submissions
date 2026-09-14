class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int ele : nums) {
            if (pq.size() == k && pq.peek() >= ele) continue;
            if (pq.size() == k) pq.poll();
            pq.offer(ele);
        }
        return pq.poll();
    }
}
