class Pair {
    int fr;
    char ch;
    Pair(int fr, char ch) {
        this.fr = fr;
        this.ch = ch;
    }
}
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((first, second) -> second.fr - first.fr);
        if (a != 0) pq.offer(new Pair(a, 'a'));
        if (b != 0) pq.offer(new Pair(b, 'b'));
        if (c != 0) pq.offer(new Pair(c, 'c'));

        Pair prev = null;
        StringBuilder sb = new StringBuilder();
        char repeat = '1';

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            sb.append(p.ch);
            p.fr = p.fr-1;

            if (sb.length() >= 2 && sb.charAt(sb.length()-1) == sb.charAt(sb.length()-2)) repeat = p.ch;
            else repeat = '1';

            if (prev != null) {
                pq.offer(prev);
                prev = null;
            }

            if (p.fr > 0 && p.ch == repeat) prev = p;
            else if(p.fr > 0 && p.ch != repeat) pq.offer(p);
        }

        return sb.toString();
        // return rec(pq, null);
    }

    // private String rec(PriorityQueue<Pair> pq, Pair prev) {
    //     if (pq.isEmpty()) return "";

    //     Pair p1 = pq.peek();
    //     Pair p2 = pq.poll();

    //     String take1 = p1.ch + "";
    //     p1.fr = p1.fr-1;

    //     String take2 = p2.ch + "";
    //     p2.fr = p2.fr-1;
    //     if (p2.fr > 0) take2 += p2.ch + "";
    //     p2.fr = p2.fr-1;

    //     if (prev != null) pq.offer(prev);
    //     prev = null;

    //     take1 += rec(pq, p1.fr > 0 ? p1 : null);
    //     take2 += rec(pq, p2.fr > 0 ? p2 : null);
    //     System.out.println(take1 + " : " + take2);
    //     return take1.length() > take2.length() ? take1 : take2;
        
    // }
}