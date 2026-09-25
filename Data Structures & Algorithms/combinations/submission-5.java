class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(1, n, k, list, new ArrayList<>());
        return new ArrayList<>(list);
    }

    private void dfs(int i, int n, int k, List<List<Integer>> list, List<Integer> ds) {
        if (ds.size() == k) {
            list.add(new ArrayList<>(ds));
            return;
        } 

        
        for (int start = i; start <= n; start++) {
            ds.add(start);
            dfs(start+1, n, k, list, ds);
            ds.remove(ds.size()-1);
        }
    }
}