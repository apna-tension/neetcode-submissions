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
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            set.add(ch);
        }

        for (char ch : set) {
            pq.offer(map.get(ch));
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
