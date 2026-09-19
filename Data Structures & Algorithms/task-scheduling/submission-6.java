class Pair {
    int fr;
    int time;
    Pair(int fr, int time) {
        this.fr = fr;
        this.time = time;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        int[] fr = new int[26];

        for (char ch : tasks) {
            fr[ch-'A']++;
        }

        for (int i = 0; i < 26; i++) {
            if (fr[i] > 0) pq.offer(fr[i]);
        }

        int time = 0;
        Queue<Pair> q = new LinkedList<>();
        while (!pq.isEmpty() || !q.isEmpty()) {
            if (pq.isEmpty()) {
                time = q.peek().time;
            } else {
                int cnt = pq.poll()-1;
                if (cnt > 0) {
                    q.offer(new Pair(cnt, time+n));
                }
            }

            if (!q.isEmpty() && q.peek().time == time) {
                pq.offer(q.poll().fr);
            }
            time++;
        }
        return time;
    }
}
