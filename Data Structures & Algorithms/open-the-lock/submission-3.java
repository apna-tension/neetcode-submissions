class Pair {
    String state;
    int step;
    Pair(String state, int step) {
        this.state = state;
        this.step = step;
    }
}
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        for (String str : deadends) {
            dead.add(str);
        }

        if (dead.contains(target) || dead.contains("0000")) return -1;
        if (target.equals("0000")) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair("0000", 0));
        dead.add("0000");

        while (!q.isEmpty()) {
            Pair p = q.poll();
            String str = p.state;
            for (int i = 0; i < 4; i++) {
                int digit = str.charAt(i) - '0';
                int back = (digit - 1 + 10) % 10;
                int forward = (digit + 1) % 10;

                String s1 = str.substring(0, i) + back + str.substring(i+1, 4);
                String s2 = str.substring(0, i) + forward + str.substring(i+1, 4);

                if (s1.equals(target) || s2.equals(target)) return p.step+1;

                if (!dead.contains(s1)) {
                    q.offer(new Pair(s1, p.step+1));
                    dead.add(s1);
                }

                if (!dead.contains(s2)) {
                    q.offer(new Pair(s2, p.step+1));
                    dead.add(s2);
                }
            }
        }
        return -1;
    }
}