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

                String before = "";
                String after = "";
                for (int j = 0; j < i; j++) {
                    before += str.charAt(j);
                }

                for (int j = i+1; j < 4; j++) {
                    after += str.charAt(j);
                }

                String s1 = before + Integer.toString(back) + after;
                String s2 = before + Integer.toString(forward) + after;

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