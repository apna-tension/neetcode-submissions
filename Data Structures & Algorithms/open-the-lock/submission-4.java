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
            for (String next : children(str)) {
                
                if (next.equals(target)) return p.step+1;

                if (!dead.contains(next)) {
                    q.offer(new Pair(next, p.step+1));
                    dead.add(next);
                }
            }
        }
        return -1;
    }


    private List<String> children(String lock) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char[] arr = lock.toCharArray();
            arr[i] = (char) (((arr[i] - '0' + 1) % 10) + '0');
            res.add(new String(arr));

            arr = lock.toCharArray();
            arr[i] = (char) (((arr[i] - '0' - 1 + 10) % 10) + '0');
            res.add(new String(arr));
        }
        return res;
    }
}