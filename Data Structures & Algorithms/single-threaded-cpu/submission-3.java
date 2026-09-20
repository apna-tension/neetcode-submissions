class Trio {
    int arrival;
    int brust;
    int pos;
    Trio(int arrival, int brust, int pos) {
        this.arrival = arrival;
        this.brust = brust;
        this.pos = pos;
    }
}

class Solution {
    public int[] getOrder(int[][] tasks) {

        PriorityQueue<Trio> pq = new PriorityQueue<>((a, b) -> a.arrival - b.arrival);
        for (int i = 0; i < tasks.length; i++) {
            pq.offer(new Trio(tasks[i][0], tasks[i][1], i));
        }



        
        int time = 0;
        int order = 0;
        int ans[] = new int[tasks.length];
        PriorityQueue<Trio> available = new PriorityQueue<>((a, b) -> a.brust != b.brust ? a.brust - b.brust : a.pos - b.pos);

        while (!pq.isEmpty() || !available.isEmpty()) {
            while (!pq.isEmpty() && pq.peek().arrival <= time) {
                available.offer(pq.poll());
            }
            if (available.isEmpty()) {
                time = pq.peek().arrival;
                System.out.println("Brust time set to : " + time);
                continue;
            }

            Trio t = available.poll();
            time += t.brust;
            ans[order] = t.pos;
            order++;
        }

        return ans;
        
        
    }
}