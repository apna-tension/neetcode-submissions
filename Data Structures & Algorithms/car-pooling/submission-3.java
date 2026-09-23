class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int[] trip : trips) {
            pq.offer(new int[]{trip[0], trip[1], trip[2]});
        }

        PriorityQueue<int[]> booked = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int time = 0;
        while (!pq.isEmpty()) {
            while (!booked.isEmpty() && booked.peek()[2] == time) {
                capacity += booked.peek()[0];
                booked.poll();
            }

            while (!pq.isEmpty() && time == pq.peek()[1] && pq.peek()[0] <= capacity) {
                capacity -= pq.peek()[0];
                booked.offer(pq.peek());
                pq.poll();
            } 
            if (!pq.isEmpty() && (time > pq.peek()[1] || (time == pq.peek()[1] && pq.peek()[0] > capacity))) return false;
            time += 1;
        }
        return true;
    }
}