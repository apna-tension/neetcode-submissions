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
    private int dfs(Trio t, List<List<Integer>> adj) {
        int max = t.height;
        for (int nei : adj.get(t.v)) {
            if (nei == t.parent) continue;
            max = Math.max(max, dfs(new Trio(nei, t.v, t.height+1), adj));
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
            int height = dfs(new Trio(i, -1, 1), adj);
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

