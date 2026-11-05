class Pair {
    String state;
    int step;
    String parent;
    Pair(String state, int step, String parent) {
        this.state = state;
        this.step = step;
        this.parent = parent;
    }
}
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        for (String str : deadends) {
            dead.add(str);
        }

        Set<String> vis = new HashSet<>();

        if (dead.contains(target) || dead.contains("0000")) return -1;
        if (target.equals("0000")) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair("0000", 0, "sdks"));
        vis.add("0000");

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

                if (!vis.contains(s1) && !dead.contains(s1) && !s1.equals(p.parent)) {
                    q.offer(new Pair(s1, p.step+1, str));
                    vis.add(s1);
                }

                if (!vis.contains(s2) && !dead.contains(s2) && !s2.equals(p.parent)) {
                    q.offer(new Pair(s2, p.step+1, str));
                    vis.add(s2);
                }
            }
        }
        return -1;
    }
}