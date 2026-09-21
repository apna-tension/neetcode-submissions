class Pair {
    int fr;
    char ch;
    Pair(int fr, char ch) {
        this.fr = fr;
        this.ch = ch;
    }
}
class Solution {
    public String reorganizeString(String s) {
        Pair pr = null;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.fr - a.fr);
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            set.add(ch);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : set) {
            pq.offer(new Pair(map.get(ch), ch));
        }

        if (pq.peek().fr > (s.length()+1)/2) return "";

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            sb.append(p.ch);
            p.fr = p.fr-1;
            
            if (pr != null) {
                pq.offer(pr);
                pr = null;
            }

            if (p.fr != 0) pr = p;
        }
        return sb.toString();
    }
}