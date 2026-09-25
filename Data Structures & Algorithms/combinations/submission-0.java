class Solution {
    public List<List<Integer>> combine(int n, int k) {
        Set<List<Integer>> list = new HashSet<>();
        dfs(1, n, k, list, new ArrayList<>());
        return new ArrayList<>(list);
    }

    private void dfs(int i, int n, int k, Set<List<Integer>> list, List<Integer> ds) {
        if (ds.size() == k) {
            list.add(new ArrayList<>(ds));
        } 

        if (ds.size() > k || i > n) return;

        ds.add(i);
        dfs(i+1, n, k, list, ds);
        ds.remove(ds.size()-1);
        dfs(i+1, n, k, list, ds);
    }
}