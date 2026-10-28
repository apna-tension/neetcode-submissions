class Pair {
    int parent;
    int curr;
    Pair(int parent, int curr) {
        this.parent = parent;
        this.curr = curr;
    }
}
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n-1) return false;
        List<List<Pair>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            list.get(edge[0]).add(new Pair(edge[0], edge[1]));
            list.get(edge[1]).add(new Pair(edge[1], edge[0]));
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(-1, 0));
        boolean[] visit = new boolean[n];
        visit[0] = true;
        
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            for (Pair nei : list.get(curr.curr)) {
                if (visit[nei.curr] && nei.curr != curr.parent) return false;
                if (visit[nei.curr]) continue;
                q.offer(nei);
                visit[nei.curr] = true;
            }
        }
        for (int i = 0; i < n; i++) if (!visit[i]) return false;
        return true;
    }
}
