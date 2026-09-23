class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int max = 0;
        for (int[] trip : trips) {
            // pq.offer(new int[]{trip[0], trip[1], trip[2]});
            max = Math.max(trip[2], max);
        }

        int[] line = new int[max+2];
        for (int[] trip : trips) {
            line[trip[1]] += trip[0];
            line[trip[2]] -= trip[0];
        }

        for (int i = 1; i <= max+1; i++) {
            // System.out.println(Arrays.toString(line));
            line[i] += line[i-1];
            // System.out.println(Arrays.toString(line));
            if (line[i] > capacity) return false;
        }

        
        return true;
    }
}