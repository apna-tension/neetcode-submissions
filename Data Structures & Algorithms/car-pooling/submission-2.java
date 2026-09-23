class Trio{
    int number;
    int from;
    int to;
    Trio(int number, int from, int to) {
        this.number = number;
        this.from = from;
        this.to = to;
    }
}
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<Trio> pq = new PriorityQueue<>((a, b) -> a.from - b.from);

        for (int[] trip : trips) {
            pq.offer(new Trio(trip[0], trip[1], trip[2]));
        }

        PriorityQueue<Trio> booked = new PriorityQueue<>((a, b) -> a.to - b.to);
        int time = 0;
        while (!pq.isEmpty()) {
            // System.out.println(pq);
            // System.out.println(booked);
            while (!booked.isEmpty() && booked.peek().to == time) {
                capacity += booked.peek().number;
                booked.poll();
            }

            while (!pq.isEmpty() && time == pq.peek().from && pq.peek().number <= capacity) {
                capacity -= pq.peek().number;
                booked.offer(pq.peek());
                pq.poll();
            } 
            if (!pq.isEmpty() && time > pq.peek().from) return false;
            if (!pq.isEmpty() && time == pq.peek().from && pq.peek().number > capacity) return false;
            time++;
        }
        return true;
    }
}