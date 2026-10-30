class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        
        int count = 0;
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                count++;
                dfs(i, list, visit);
            }
        }
        return count;
    }

    private void dfs(int v, List<List<Integer>> list, boolean[] vis) {
        if (vis[v]) return;

        vis[v] = true;
        for (int nei : list.get(v)) {
            dfs(nei, list, vis);
        }
    }
}
