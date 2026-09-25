class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        boolean[] visit = new boolean[nums.length];
        permute(nums, ans, new ArrayList<>(), visit);
        
        return ans;
    }

    private void permute(int[] nums, List<List<Integer>> list, List<Integer> ds, boolean[] visit) {
        if (ds.size() == nums.length) {
            list.add(new ArrayList<>(ds));
            return;
        }

        for (int start = 0; start < nums.length; start++) {
            if (visit[start]) continue;
            ds.add(nums[start]);
            visit[start] = true;
            permute(nums, list, ds, visit);
            ds.remove(ds.size()-1);
            visit[start] = false;
        }
    }
}
