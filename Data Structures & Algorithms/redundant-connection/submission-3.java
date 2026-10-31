class Pair {
    int curr;
    int parent;
    Pair(int curr, int parent) {
        this.curr = curr;
        this.parent = parent;
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Pair>> list = new ArrayList<>();
        for (int i = 0; i < edges.length+1; i++) list.add(new ArrayList<>());
        for (int[] e : edges) {
            list.get(e[0]).add(new Pair(e[1], e[0]));
            list.get(e[1]).add(new Pair(e[0], e[1]));
            boolean[] visit = new boolean[edges.length+1];
            
            if (cycle(new Pair(e[0], e[1]), list, visit)) return new int[]{e[0], e[1]};
        }
        return new int[]{-1, -1};
    }

    private boolean cycle(Pair curr, List<List<Pair>> list, boolean[] visit) {
        
        Stack<Pair> q = new Stack<>();
        q.push(curr);
        visit[curr.curr] = true;
        while (!q.isEmpty()) {
            Pair p = q.pop();
            int v = p.curr;
            int parent = p.parent;
            for (Pair nei : list.get(v)) {
                if (visit[nei.curr] && nei.curr != parent) return true;
                if (!visit[nei.curr]) {
                    visit[nei.curr] = true;
                    q.push(nei);
                }
            }
        }
        return false;
    }
}
