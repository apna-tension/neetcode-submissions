class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length+1-k];

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i+1-j > k) {
                ans[i-k] = pq.peek();
                pq.remove(nums[j]);
                j++;
            }
            pq.offer(nums[i]);
        }

        ans[nums.length-k] = pq.poll();
        return ans;
    }
}
