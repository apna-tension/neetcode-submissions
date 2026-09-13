class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

        for (int[] arr : points) {
            int dist = arr[0] * arr[0] + arr[1] * arr[1];
            pq.offer(new int[]{dist, arr[0], arr[1]});
        }

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] temp = pq.poll();
            ans[i] = new int[]{temp[1], temp[2]};
        }

        return ans;
    }
}
