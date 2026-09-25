class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return Arrays.asList(new ArrayList<>());

        List<List<Integer>> list = permute(Arrays.copyOfRange(nums, 1, nums.length));
        // permute(nums, 0, list, new ArrayList<>());
        List<List<Integer>> ans = new ArrayList<>();

        for (List<Integer> p : list) {
            for (int i = 0; i <= p.size(); i++) {
                List<Integer> p_copy = new ArrayList<>(p);
                p_copy.add(i, nums[0]);
                ans.add(p_copy);
            }
        }
        return ans;
    }

    // private void permute(int[] nums, int i, List<List<Integer>> list, List<Integer> ds) {
    //     if (ds.size() == nums.length) {
    //         list.add(new ArrayList<>(ds));
    //         return;
    //     }

    //     if (i >= nums.length) return;

    //     for (int start = 0; start < nums.length; start++) {
    //         if (start == i) continue;
    //         ds.add(nums[start]);
    //         permute(nums, start+1, list, ds);
    //         ds.remove(ds.size()-1);
    //     }
    // }
}
