class Solution {
    public int[] getOrder(int[][] tasks) {
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }
        
        Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));

        int i = 0;
        int time = 1;
        int order = 0;
        int ans[] = new int[tasks.length];
        PriorityQueue<int[]> available = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        while (i < tasks.length || !available.isEmpty()) {
            while (i < tasks.length && tasks[i][0] <= time)
                available.offer(new int[]{tasks[i][1], tasks[i++][2]});
                
            if (available.isEmpty()) {
                time = tasks[i][0];
                continue;
            }
            time += available.peek()[0];
            ans[order++] = available.poll()[1];
        }

        return ans;
        
        
    }
}