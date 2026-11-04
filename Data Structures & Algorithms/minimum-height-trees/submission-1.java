class Trio {
    int v;
    int parent;
    int height;
    Trio(int v, int parent, int height) {
        this.v = v;
        this.parent = parent;
        this.height = height;
    }
}


class Solution {
    private int bfs(int v, List<List<Integer>> adj) {
        Stack<Trio> q = new Stack<>();
        q.push(new Trio(v, -1, 1));
        // boolean[] vis = new boolean[adj.size()];

        int max = Integer.MIN_VALUE;
        while (!q.isEmpty()){
            Trio t = q.pop();
            max = Math.max(max, t.height);
            for (int nei : adj.get(t.v)) {
                if (t.parent == nei) continue;
                q.push(new Trio(nei, t.v, t.height+1));
            }
        }
        return max;
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        } 
        int min = n;
        for (int i = 0; i < n; i++) {
            int height = bfs(i, adj);
            map.put(i, height);
            min = Math.min(min, height);
        }

        for (int i = 0; i < n; i++) {
            if (map.get(i) == min) list.add(i);
        }
        // System.out.println(map);
        return list;
    }
}

