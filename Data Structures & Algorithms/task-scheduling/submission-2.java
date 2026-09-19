class Pair {
    int fr;
    char ch;
    Pair(int fr, char ch) {
        this.fr = fr;
        this.ch = ch;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.fr - a.fr);
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            set.add(ch);
        }

        for (char ch : set) {
            pq.offer(new Pair(map.get(ch), ch));
        }

        int time = 0;
        while (!pq.isEmpty()) {
            PriorityQueue<Pair> pq2 = new PriorityQueue<>((a, b) -> b.fr - a.fr);
            for (int i = 0; i <= n; i++) {
                if (pq.isEmpty() && pq2.isEmpty()) return time;
                if (!pq.isEmpty()) {
                    Pair p = pq.poll();
                    p.fr = p.fr-1;
                    if (p.fr != 0) {
                        pq2.offer(p);
                    }
                }
                time++;
            }
            while (!pq2.isEmpty()) pq.offer(pq2.poll());
        }
        return time;
    }
}
